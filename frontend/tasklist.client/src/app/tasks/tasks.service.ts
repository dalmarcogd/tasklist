import { TaskDTO } from './../model/task/task.dto';
import { Http } from '@angular/http';
import { ServiceLocator } from './../service/locator/service.locator';
import { HttpService } from './../service/http/http.service';
import { Injectable } from '@angular/core';

@Injectable()
export class TasksService {

    private get httpService() : HttpService {
        return ServiceLocator.get(HttpService);
    }

    /**
     * Listar todas as tarefas.
     */
    public list() : Promise<TaskDTO[]> {
        return this.httpService.get('/tasks', null);
    }

    /**
     * Deletar uma tarefa.
     */
    public delete(task: TaskDTO) : Promise<TaskDTO[]> {
        return this.httpService.delete('/tasks', task);
    }

    /**
     * Salvar uma tarefa.
     */
    public save(task: TaskDTO) : Promise<TaskDTO[]> {
        return this.httpService.post('/tasks', task);
    }
}