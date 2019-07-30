import { Component, OnInit } from '@angular/core';
import {AuthenticationService} from '../services/authentication.service';
import { Router, ActivatedRoute } from '@angular/router';
import {FormGroup} from '@angular/forms';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  model: any = {};
  loading = false;
  returnUrl: string;
  loginForm: FormGroup;
  submitted = false;
  errorMsg="";
  
  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private authenticationService: AuthenticationService) { }

 

  ngOnInit() {
  // reset login status
  this.authenticationService.logout();
  // get return url from route parameters or default to '/'
   this.returnUrl = this.route.snapshot.queryParams['returnUrl'] || '/';
  }

 
  onLoggedin() {
      this.loading = true ;
      this.submitted = true;
      this.authenticationService.login(this.model.username, this.model.password)
      .subscribe(
         (res) => {
             console.log(res.status, res.response);
             localStorage.setItem('token', res.body.access_token);
            this.router.navigate([this.returnUrl]);
           },
          
           (err) =>{
              console.log(err.message)
              this.errorMsg = "Invalid  Username or Password";
              this.loading = false;
          }
              
      );
      localStorage.setItem('isLoggedin', 'true');
  }

  

}
