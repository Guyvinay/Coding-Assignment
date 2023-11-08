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



}
