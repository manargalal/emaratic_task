import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule,FormGroup } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { LoginRoutingModule } from './login-routing.module';
import { LoginComponent } from './login.component';
import { AuthenticationService } from '../services/authentication.service';
import { TokenInterceptor } from '../services/token-interceptor';

 

@NgModule({
    imports: [CommonModule, ReactiveFormsModule,LoginRoutingModule,FormsModule],

    declarations: [LoginComponent],
    providers: [ 
      
        AuthenticationService,
        HttpClientModule,
        HttpModule
      ],
})
export class LoginModule {}
