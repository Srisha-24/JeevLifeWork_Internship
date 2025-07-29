Angular Auth + Todo Application

This is a simple Angular application that demonstrates:
- ✅ User Signup & Login with validations
- ✅ Protected To-Do List accessible only after login
- ✅ Form handling with Reactive Forms
- ✅ Simple in-memory authentication logic
- ✅ Component-based modular structure

---

##  Tech Stack

- Angular 16+
- TypeScript
- SCSS (optional styling)
- Reactive Forms
- Angular Routing

---

##  Project Structure

src/
├── app/
│ ├── auth/
│ │ ├── login/
│ │ │ └── login.component.ts / html / scss
│ │ ├── signup/
│ │ │ └── signup.component.ts / html / scss
│ │ └── auth.service.ts
│ ├── todo/
│ │ └── todo.component.ts / html / scss
│ ├── app-routing.module.ts
│ ├── app.component.ts
│ └── app.module.ts