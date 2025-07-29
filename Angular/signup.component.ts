import { Component } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from '../../services/auth.service';

@Component({ selector: 'app-signup', templateUrl: './signup.component.html' })
export class SignupComponent {
  signupForm = this.fb.group({
    fullName: ['', Validators.required],
    email: ['', [Validators.required, Validators.email]],
    password: ['', [Validators.required, Validators.minLength(6)]],
    confirmPassword: ['', Validators.required],
  }, { validators: this.passwordMatch });

  constructor(private fb: FormBuilder, private auth: AuthService, private router: Router) {}

  passwordMatch(form: any) {
    return form.get('password').value === form.get('confirmPassword').value ? null : { mismatch: true };
  }

  onSubmit() {
    if (this.signupForm.valid) {
      const { fullName, email, password } = this.signupForm.value;
      this.auth.signup({ fullName, email, password });
      this.router.navigate(['/login']);
    }
  }
}

