import { Component, OnInit } from '@angular/core';
import { GridOptions ,IDatasource,GridApi, IGetRowsParams} from 'ag-grid-community';
import { PhoneBookService } from 'src/app/services/phone-book-service';
import { FilterObject } from 'src/app/models/filterObject';


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {
  public loading = true;
  gridApi:GridApi;
  confirmationMsg: string
  message: string;
  createdDoctor: any
  gridColumnApi
  sortingOrder;
  rowSelection;
  columnDefs;
  rowData: any[];
  gridOptions: GridOptions;
  groupHeaderHeight;
  headerHeight;
  floatingFiltersHeight;
  pivotGroupHeaderHeight;
  pivotHeaderHeight;
  paginationPageSize = 14;
  rowModelType;
  constructor(public _phoneBookServiceService: PhoneBookService) {
    this.creatColumns();
    this.gridOptions = <GridOptions>{
      context: {
        componentParent: this
      },
      pagination: true,
      enableFilter:false,
      enableSorting:true,
      enableServerSideFilter:false,
      enableServerSideSorting:true,
      rowModelType: 'infinite',
      cacheBlockSize: 14,
      paginationPageSize: 14
    };
  }

  ngOnInit() { 
  }
  creatColumns() {
    this.columnDefs = [
      {
        field:'-',
        hide:true,
        lockVisible:true,
        filter:"agTextColumnFilter",
        filterParams:{
          newRowsAction: "keep"
        }
      },
      {
        headerName: "ID",
        field: "phoneBook.id",
        minWidth: 200,
        cellStyle: { color: 'BLACK', 'font-weight': 'bold' },
        filterParams: {
          filterOptions: ["contains"]
        }
      },
      {
        headerName: "Phone Number",
        minWidth: 200,
        suppressSizeToFit: true,
        field: "phoneBook.phoneNumber",
      },
     

    ];
    this.sortingOrder = ['desc', 'asc', null];
    this.rowSelection = "single";
    this.rowModelType = "infinite";
    this.groupHeaderHeight = 100;
    this.headerHeight = 37;
    this.floatingFiltersHeight = 50;
    this.pivotGroupHeaderHeight = 50;
    this.pivotHeaderHeight = 100;
  }

  
  onGridReady(params) {
    this.gridApi = params.api;
    this.gridColumnApi = params.columnApi;
    this.gridApi.setDatasource(this.dataSource);
    this.gridApi.setDomLayout("autoHeight");
    params.api.sizeColumnsToFit();
  }

 
 
  public onRowClicked(e) {
   
  }

  
  onFilterTextBoxChanged(value) {
    this.gridApi.setFilterModel({"-":{filter: value}});
  }

  refreshGrid() {
    this.gridApi.setDatasource(this.dataSource);
  }

  dataSource: IDatasource = {
    getRows: (params: IGetRowsParams) => {
      let sortModel=params.sortModel;
      let filterModel=params.filterModel;
      let filter =this.getFilterModel(filterModel);
      if(filter == undefined){
        filter ="";
      }
       this._phoneBookServiceService.viewAllNumbers(this.gridApi.paginationGetCurrentPage(),filter).subscribe(data => {
          this.loading = false;
          let rowData= data.body.numbers;
          params.successCallback(
            rowData,
           data.body.totalElements
          );
        });
    }
  };
  
  getFilterModel(filterModel){
    let filterObject:FilterObject=new FilterObject();
    let filterPresent = filterModel && Object.keys(filterModel).length > 0;
    if (filterPresent) {
      for(let f= 0 ; f < Object.keys(filterModel).length;f++){
        let filterObject:FilterObject=new FilterObject();
        let filterKey=Object.keys(filterModel)[f];
        let filterModelTarget=filterModel[filterKey];
        if (filterKey === '-'){
          filterObject.operation=filterModelTarget.type;
          filterObject.value=filterModelTarget.filter;
         return filterObject.value
        } 
      }
    
    }
   
  }
}
