import { Component, OnInit } from '@angular/core';
import { Task } from '../task';
import { TaskService } from '../task.service';
import { response } from 'express';
import { error } from 'console';

@Component({
  selector: 'app-task-list',
  templateUrl: './task-list.component.html',
  styleUrls: ['./task-list.component.css']
})
export class TaskListComponent implements OnInit {

  allTasks:Task[]=[];

  constructor(private taskService: TaskService){}

  ngOnInit(): void {

    this.taskService.getAllTasks()
                     .subscribe(
                      (response)=>{
                        this.allTasks = response.data;
                        console.log(this.allTasks);
                      },
                      (error)=>{
                        console.log(error);
                      }
                     )

  }

  deleteTask(id:Number){
    this.taskService.deleteTaskById(id).subscribe(
      (response)=>{
        console.log(response);

        const index = this.allTasks.findIndex((task)=>task.id===id);
        if(index!=-1){
          this.allTasks.splice(index, 1);
        }

      },
      (error)=>{
        console.log(error);
      }
    );
  };

  markTaskComplete(id:Number){
    this.taskService.markTaskComplete(id)
                    .subscribe(
                      (response)=>{
                        console.log(response);
                        const index = this.allTasks.findIndex((task)=>task.id===id);
                        if(index!==-1){
                          this.allTasks[index].status = "Completed";
                        }
                      },
                      (error)=>{
                        console.log(error);
                      }
                    )
  }

}
