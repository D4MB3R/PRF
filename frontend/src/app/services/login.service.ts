import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { AngularFireAuth } from '@angular/fire/auth';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  

  constructor(private http: HttpClient, private auth: AngularFireAuth, private router: Router) { }

  login(email: string, password: string) {
    return this.auth.signInWithEmailAndPassword(email, password);
  }

  logout() {
    this.router.navigate(['/login']);
    return this.auth.signOut();
  }

  isAdmin(): boolean {
    return localStorage.getItem('user') === "szaboz@inf.u-szeged.hu"
  }

  isLoggedIn(): boolean {
    return !!localStorage.getItem('user');
  }
}
