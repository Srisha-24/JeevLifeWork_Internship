import { Component } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { TodoService } from '../services/todo.service';
import { AuthService } from '../services/auth.service';

@Component({ selector: 'app-todo', templateUrl: './todo.component.html' })
export class TodoComponent {
  todoForm = this.fb.group({
    title: ['', Validators.required],
    description: ['']
  });

  tasks = this.todoService.getTasks();

  constructor(private fb: FormBuilder, private todoService: TodoService, public auth: AuthService) {}

  addTask() {
    if (this.todoForm.valid) {
      this.todoService.addTask({
        ...this.todoForm.value,
        completed: false
      });
      this.tasks = this.todoService.getTasks();
      this.todoForm.reset();
    }
  }

  deleteTask(i: number) {
    this.todoService.deleteTask(i);
    this.tasks = this.todoService.getTasks();
  }

  toggleComplete(i: number) {
    this.tasks[i].completed = !this.tasks[i].completed;
    this.todoService.updateTasks(this.tasks);
  }
}

