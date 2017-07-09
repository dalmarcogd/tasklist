import { TaskDTO } from './../model/task/task.dto';
import { TasksService } from './tasks.service';
import { ServiceLocator } from './../service/locator/service.locator';
import { Component, OnInit } from '@angular/core';
import {LocalDataSource} from 'ng2-smart-table';

@Component({
  selector: 'app-task',
  templateUrl: './tasks.component.html',
  styleUrls: ['./tasks.component.css']
})
export class TasksComponent implements OnInit {

  settings = {
      mode:'external',
      add: {
        addButtonContent:'Adicionar'

      },
      edit: {
        editButtonContent: 'Editar',
      },
      delete: {
        deleteButtonContent: 'Deletar',
        confirmDelete: true
      },
      columns: {
        title: {
          title: "Título",
          filter: true
        },
        taskStatus: {
          title: "Status",
          filter: true,
        },
        dateStart: {
          title: "Início",
          filter: true
        },
        dateUpdate: {
          title: "Alteração",
          filter: true
        },
        dateRemoção: {
          title: "Remoção",
          filter: true
        },
        dateEnd: {
          title: "Finalização",
          filter: true
        }
      }
    };
    source: LocalDataSource;
    opened: boolean = false;
    taskCurrent: TaskDTO = new TaskDTO();

  constructor() { }

  private tasksService() : TasksService {
    return ServiceLocator.get(TasksService);
  }

  ngOnInit() {
    this.tasksService().list().then((value) => {
      if (value instanceof Array) {
        this.source = new LocalDataSource(value);
      }
    });
  }

  onCreate(event: any): void {
    this.taskCurrent = new TaskDTO();
    this.opened = true;
  }

  onEdit(event: any): void {
    this.taskCurrent = event.data;
    this.opened = true;
  }

  onCancel(): void {
    this.taskCurrent = new TaskDTO();
    this.opened = false;
  }

  onSaveConfirm(): void {
    this.tasksService().save(this.taskCurrent).then(() => this.opened = false);
  }

  onDeleteConfirm(event: any): void {
    this.tasksService().delete(event.data).then(() => this.opened = false);
  }
}
