import { Component, OnInit } from '@angular/core';
import { ReqTask, Task } from '../task';
import { TaskService } from '../task.service';
import { LoggedInProfile } from '../profile';
import { ProfileService } from '../profile.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {


  allTasks:Task[]=[];
  
  curentLoggedInPRofile:LoggedInProfile = {
    id: '',
    name: '',
    email: '',
    password: '',
    profile_picture: '',
    token: ''
  }
  constructor(
    private taskService: TaskService,
    private profileService : ProfileService
    ){}

  ngOnInit(): void {

    const storedUserData = localStorage.getItem('loggedInUserData');

    if(storedUserData){
      this.curentLoggedInPRofile = JSON.parse(storedUserData);
    }else{
      this.curentLoggedInPRofile = this.profileService.getLoggedInProfile();
    }

    this.taskService.getAllTasks()
                     .subscribe(
                      (response)=>{
                        this.allTasks = response;
                      },
                      (error)=>{
                        console.log(error);
                      });
  }



}
