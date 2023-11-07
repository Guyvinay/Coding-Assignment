
export interface Task {
    id: number;
    taskTitle: string;
    taskDesc: string;
    status: string;
    createdAt:string
    // Add more properties as needed
  }
  
  export interface ReqTask {
    taskTitle: string;
    taskDesc: string;
    status: string;
    // Add more properties as needed
  }