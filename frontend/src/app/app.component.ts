import { Component, OnInit } from '@angular/core';
import { DataService } from './services/data.service';
import { LoggedInService } from './services/logged-in.service';
import { LoginService } from './services/login.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{

  title = 'PRF-Frontend';
  admin!: boolean;
  loggedIn!: boolean;

  constructor(private loginService: LoginService, private dataService: DataService, private loggedInService: LoggedInService) {
    this.dataService.currentMessage.subscribe(message => this.admin = message === "true" ? true : false);
    this.loggedInService.currentMessage.subscribe(message => this.loggedIn = message === "true" ? true : false);
  }

  ngOnInit(): void {
    this.admin = this.loginService.isAdmin();
    this.loggedIn = this.loginService.isLoggedIn();
  }  

  logout() {
    this.loginService.logout();
  }

}
