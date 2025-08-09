import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-login',
  template: `<h3>Login</h3>
  <form (ngSubmit)="login()">
    <input placeholder="email" [(ngModel)]="email" name="email" required>
    <input placeholder="password" [(ngModel)]="password" type="password" name="password" required>
    <button type="submit">Login</button>
  </form>
  <div *ngIf="token">Token: {{token}}</div>`
})
export class LoginComponent {
  email='admin@example.com'; password='Admin123'; token='';
  constructor(private http: HttpClient){}
  login(){
    this.http.post<any>('http://localhost:8080/api/auth/login',{email:this.email,password:this.password})
      .subscribe(res=>{ this.token = res.token; localStorage.setItem('token', this.token); });
  }
}
