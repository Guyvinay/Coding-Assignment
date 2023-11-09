import { Component, OnInit } from '@angular/core';
import { ReqTask, Task } from '../task';
import { TaskService } from '../task.service';
import { LoggedInProfile } from '../profile';
import { ProfileService } from '../profile.service';
import Swal from 'sweetalert2';
import { Router } from '@angular/router';

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
    private profileService : ProfileService,
    private router : Router,
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


  logOutUser(){
    localStorage.removeItem('loggedInUserData');
    Swal.fire({
      icon: 'success', // Set the alert icon (success, error, warning, info, etc.)
      title: 'Successfully Logged Out',
      text: "You Have Been Successfully Logged Out",
      showConfirmButton: false, // Automatically close the alert after a short delay
      timer: 1500, // Adjust the duration (in milliseconds) for the alert to disappear
    });
    setTimeout(()=>{
      this.router.navigate(['/login']);
    },2000);
  }

}
