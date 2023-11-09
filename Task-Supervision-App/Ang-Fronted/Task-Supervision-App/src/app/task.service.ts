import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ReqTask, Task } from './task';
import { ProfileService } from './profile.service';
import { LoggedInProfile } from './profile';

@Injectable({
  providedIn: 'root'
})
export class TaskService {

  private baseUrl = 'http://localhost:8888/api/tasks';
  // private baseUrl = 'https://task-supervision-app.onrender.com/api/tasks';

  currentLoggedInProfile: LoggedInProfile={
    name: '',
    email: '',
    password: '',
    profile_picture: '',
    token: ''
  };



  constructor(
    private http : HttpClient,
    private profileService : ProfileService
    ) { }

  //   Task
  createTask(task: ReqTask): Observable<ReqTask> {
    // this.currentLoggedInProfile = this.profileService.getLoggedInProfile();
    // console.log(this.currentLoggedInProfile.token);
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
