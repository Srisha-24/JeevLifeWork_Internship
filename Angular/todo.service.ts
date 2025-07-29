import { Injectable } from '@angular/core';

@Injectable({ providedIn: 'root' })
export class TodoService {
  private tasks: any[] = JSON.parse(localStorage.getItem('tasks') || '[]');

  getTasks() {
    return this.tasks;
  }

  addTask(task: any) {
    this.tasks.push(task);
    localStorage.setItem('tasks', JSON.stringify(this.tasks));
  }

  deleteTask(index: number) {
    this.tasks.splice(index, 1);
    localStorage.setItem('tasks', JSON.stringify(this.tasks));
  }

  updateTasks(tasks: any[]) {
    this.tasks = tasks;
    localStorage.setItem('tasks', JSON.stringify(this.tasks));
  }
}

