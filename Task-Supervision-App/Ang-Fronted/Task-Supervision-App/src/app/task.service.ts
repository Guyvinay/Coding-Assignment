import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ReqTask, Task } from './task';

@Injectable({
  providedIn: 'root'
})
export class TaskService {

  // private baseUrl = 'http://localhost:8888/api/tasks';
  private baseUrl = 'https://task-supervision-app.onrender.com/api/tasks';

  constructor(private http : HttpClient) { }

  //   Task
  createTask(task: ReqTask): Observable<ReqTask> {
    return this.http.post<ReqTask>( `${this.baseUrl}/createTask`, task);
  }
  //   Task
  getAllTasks(): Observable<any> {
    return this.http.get<any>(`${this.baseUrl}/getAllTasks`);
  }
  //   Task
  getTaskById( id: Number ): Observable<any> {
    return this.http.get<any>(`${this.baseUrl}/getTaskById/${id}`);
  }
  //   Task
  getTaskByTitle( title: String ): Observable<Task> {
    return this.http.get<Task>(`${this.baseUrl}/getTaskByTitle/${title}`);
  }
  //   Task
  updateTask(task:Task): Observable<Task> {
    return this.http.put<Task>(`${this.baseUrl}/updtateTask`, task);
  }
  //   Task
  deleteTaskById( id: Number ): Observable<String> {
    return this.http.delete<String>(`${this.baseUrl}/deleteTaskById/${id}`);
  }
  //   Task
  markTaskComplete(id:Number): Observable<any> {
    return this.http.get<any>(`${this.baseUrl}/markTaskComplete/${id}`);
  }

}
