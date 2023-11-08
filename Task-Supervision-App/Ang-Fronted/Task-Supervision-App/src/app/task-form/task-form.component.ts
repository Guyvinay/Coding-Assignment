import { Component } from '@angular/core';
import { Task, ReqTask } from '../task';
import { TaskService } from '../task.service';

@Component({
  selector: 'app-task-form',
  templateUrl: './task-form.component.html',
  styleUrls: ['./task-form.component.css']
})
export class TaskFormComponent {

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
                        console.log(this.allTasks);
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
