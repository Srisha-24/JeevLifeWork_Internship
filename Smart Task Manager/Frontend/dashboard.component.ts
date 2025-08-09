import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
@Component({
  selector: 'app-dashboard',
  template: `<h3>Dashboard</h3>
  <button (click)="load()">Load tasks</button>
  <pre>{{tasks | json}}</pre>`
})
export class DashboardComponent implements OnInit {
  tasks: any[] = [];
  constructor(private http: HttpClient){}
  ngOnInit(){}
  load(){
    this.http.get<any[]>('http://localhost:8080/api/tasks').subscribe(r=> this.tasks = r);
  }
}
