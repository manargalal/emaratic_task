import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LayoutRoutingModule } from './layout-routing.module';
import { LayoutComponent } from './layout.component';
import { AgGridModule } from 'ag-grid-angular';
import { HeaderComponent } from './header/header.component';
import { HomeComponent } from './home/home.component';
import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';
import { PhoneBookService } from '../services/phone-book-service';
import { TokenInterceptor } from '../services/token-interceptor';
import { ErrorInterceptor } from '../services/error_interceptor.service';
import { HttpModule } from '@angular/http';


@NgModule({
    imports: [
        CommonModule,
        LayoutRoutingModule,HttpClientModule,
        HttpModule, AgGridModule.withComponents([]),
    ],
    providers:[PhoneBookService, {
        provide: HTTP_INTERCEPTORS,
        useClass: TokenInterceptor,
        multi: true
      }, {
        provide: HTTP_INTERCEPTORS,
        useClass: ErrorInterceptor,
        multi: true
      }],

    declarations: [LayoutComponent, HeaderComponent, HomeComponent]
})
export class LayoutModule {}
