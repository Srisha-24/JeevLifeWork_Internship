import { Injectable } from '@angular/core';
import { Router } from '@angular/router';

@Injectable({ providedIn: 'root' })
export class AuthService {
  private users: any[] = JSON.parse(localStorage.getItem('users') || '[]');
  private loggedInUser: any = null;

  constructor(private router: Router) {}

  signup(user: any) {
    this.users.push(user);
    localStorage.setItem('users', JSON.stringify(this.users));
  }

  login(email: string, password: string): boolean {
    const user = this.users.find(u => u.email === email && u.password === password);
    if (user) {
      this.loggedInUser = user;
      return true;
    }
    return false;
  }

  logout() {
    this.loggedInUser = null;
    this.router.navigate(['/login']);
  }

  isLoggedIn(): boolean {
    return this.loggedInUser !== null;
  }
}
