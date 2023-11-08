import { Component, OnInit } from '@angular/core';
import { Task } from '../task';
import { ActivatedRoute } from '@angular/router';
import { TaskService } from '../task.service';
import { error } from 'console';

@Component({
  selector: 'app-update-task',
  templateUrl: './update-task.component.html',
  styleUrls: ['./update-task.component.css']
})
export class UpdateTaskComponent implements OnInit {

  task:Task={
    id: 0,
    taskTitle: '',
    taskDesc: '',
    status: '',
    createdAt: ''
  };

  constructor(
    private route : ActivatedRoute,
    private taskService : TaskService
  ){}

  ngOnInit(): void {

    const taskId = this.route.snapshot.params['id'];
    // console.log(taskId);

    this.taskService.getTaskById(taskId)
                    .subscribe((resp)=>{
                      this.task = resp.task;
                      console.log(this.task)
                    },
                    (error)=>{
                      console.log(error);
                    }
                    );
                    // console.log(this.task);
  }

  updateTask(){
    this.taskService.updateTask(this.task).subscribe(
      (resp)=>{
        console.log(resp);
    },
    (error)=>{
      console.log(error);
    }
    )
  }

}
