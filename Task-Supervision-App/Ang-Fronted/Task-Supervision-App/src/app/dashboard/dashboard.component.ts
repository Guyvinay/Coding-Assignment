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

    this.curentLoggedInPRofile = this.profileService.getLoggedInProfile();
    // console.log("Profle From Dashboard");
    if(storedUserData){
      this.curentLoggedInPRofile = JSON.parse(storedUserData);
    }else{
      this.curentLoggedInPRofile = this.profileService.getLoggedInProfile();
      console.log("Gettin Profile from Local Profile Service");
    }
    this.taskService.getAllTasks()
                     .subscribe(
                      (response)=>{
                        this.allTasks = response;
                        console.log(this.allTasks);
                      },
                      (error)=>{
                        console.log(error);
                      });

                      

  }



}
