import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from '../services/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  email: string;
  password: string;

  constructor(private loginService: LoginService, private router: Router) { 
    this.email = "";
    this.password = "";
  }

  ngOnInit(): void {
    if (localStorage.getItem('user')) {
      localStorage.removeItem('user');
      this.loginService.logout().then(() => {
        console.log('Logout successful!')
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
        }
        this.router.navigate(['/mainpage']);
      }).catch(error => {
        console.log('Login error:', error);
      })
    }
  }

}
