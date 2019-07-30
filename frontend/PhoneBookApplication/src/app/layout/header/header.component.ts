import { Component, OnInit } from '@angular/core';
import { Router, NavigationEnd } from '@angular/router';
import * as jwt_decode from "jwt-decode";
@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {
  private username: string;
  
  ngOnInit() {
    this.getUser();
  }
  onLoggedout() {
    localStorage.removeItem('token');
  }

  public  getUser() {
    const token = localStorage.getItem('token')
    const data = jwt_decode(token);
    this.username = data.user_name;
  }
}
