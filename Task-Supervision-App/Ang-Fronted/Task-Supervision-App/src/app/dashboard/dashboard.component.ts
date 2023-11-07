import { Component, OnInit } from '@angular/core';
import { ReqTask, Task } from '../task';
import { TaskService } from '../task.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {


  allTasks:Task[]=[];

  taskToBeCreated: ReqTask = {
    taskTitle : '',
    taskDesc: '',
    status: ''
  }

  constructor(private taskService: TaskService){}

  ngOnInit(): void {

    this.taskService.getAllTasks()
                     .subscribe(
                      (response)=>{
                        this.allTasks = response;
                        // console.log(this.allTasks[0]);
                      },
                      (error)=>{
                        console.log(error);
                      }
                     )

  }

  createProject(){
    this.taskService.createTask(this.taskToBeCreated)
           .subscribe(
            (response)=>{
              console.log(response);
            },
            (error)=>{
              console.log(error);
            }
           );
  }

}
