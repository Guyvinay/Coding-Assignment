import { Component } from '@angular/core';
import { Task, ReqTask } from '../task';
import { TaskService } from '../task.service';
import Swal from 'sweetalert2';
import { LoggedInProfile } from '../profile';
import { CurrencyPipe } from '@angular/common';

@Component({
  selector: 'app-task-form',
  templateUrl: './task-form.component.html',
  styleUrls: ['./task-form.component.css']
})
export class TaskFormComponent {

  allTasks:Task[]=[];

  taskToBeCreated: ReqTask = {
    taskTitle: '',
    taskDesc: '',
    status: '',
    profileId: '1'
  }

  curentLoggedInPRofile:LoggedInProfile = {
    name: '',
    email: '',
    password: '',
    profile_picture: '',
    token: ''
  }

  constructor(private taskService: TaskService){}

  ngOnInit(): void {

    this.taskService.getAllTasks()
                     .subscribe(
                      (response)=>{
                        this.allTasks = response;
                        console.log(this.allTasks);
                      },
                      (error)=>{
                        console.log(error);
                      }
                     );

  }

  createProject(){
    this.taskService.createTask(this.taskToBeCreated)
           .subscribe(
            (response)=>{
              // console.log(response);
              Swal.fire({
                icon: 'success', // Set the alert icon (success, error, warning, info, etc.)
                title: 'Success!',
                text: 'Your operation was successful.',
                showConfirmButton: false, // Automatically close the alert after a short delay
                timer: 1500, // Adjust the duration (in milliseconds) for the alert to disappear
              });
            },
            (error)=>{
              console.log(error);
              Swal.fire({
                icon: 'error',
                title: "Failed Creating",
                text: "Task-Creation-Failed",
                showConfirmButton: false, // Automatically close the alert after a short delay
                timer: 1500,
              });
            }
           );
  }


}
