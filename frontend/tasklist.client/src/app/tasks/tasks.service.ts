import { TokenService } from './../service/token/token.service';
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

    private get tokenService() : TokenService {
        return ServiceLocator.get(TokenService);
    }

    /**
     * Listar todas as tarefas.
     */
    public list() : Promise<TaskDTO[]> {
        return this.httpService.get('/tasks', null, new Map([["username", this.tokenService.getToken().username]]));
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