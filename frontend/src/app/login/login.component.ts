import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { DataService } from '../services/data.service';
import { LoggedInService } from '../services/logged-in.service';
import { LoginService } from '../services/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  email: string;
  password: string;

  constructor(private loginService: LoginService, private router: Router, private dataService: DataService, private loggedInService: LoggedInService) { 
    this.email = "";
    this.password = "";
  }

  ngOnInit(): void {
    if (localStorage.getItem('user')) {
      localStorage.removeItem('user');
      this.loginService.logout().then(() => {
        console.log('Logout successful!');
        this.dataService.changeMessage("false");
        this.loggedInService.changeMessage("false");
      }).catch(error => {
        console.log('Logout error: ', error);
      });
    }
  }

  login() {
    if (this.email != "" && this.password != "") {
      this.loginService.login(this.email, this.password).then(res => {
        console.log(res);
        if (res.user?.email) {
          let email = res.user!.email;
          localStorage.setItem('user', email);
          if(email === "szaboz@inf.u-szeged.hu") this.dataService.changeMessage("true");
          this.loggedInService.changeMessage("true");
        }
        this.router.navigate(['/mainpage']);
      }).catch(error => {
        console.log('Login error:', error);
      })
    }
  }

}
