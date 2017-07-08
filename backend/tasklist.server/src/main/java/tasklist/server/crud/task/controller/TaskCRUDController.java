package tasklist.server.crud.task.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tasklist.server.core.spring.context.ManagerInstance;
import tasklist.server.crud.base.controller.AbstractCRUDController;
import tasklist.server.crud.base.service.AbstractCRUDService;
import tasklist.server.crud.task.service.TaskCRUDService;
import tasklist.server.model.task.TaskDTO;
import tasklist.server.model.task.TaskEntity;

/**
 * Implementação de {@link AbstractCRUDController} para {@link TaskDTO}
 *
 * @author Guilherme Dalmarco (dalmarco.gd@gmail.com)
 */
@RestController
@RequestMapping("/tasks")
public class TaskCRUDController extends AbstractCRUDController<TaskDTO, TaskEntity> {

    private TaskCRUDService userCRUDService;

    /**
     * Retorna o userCRUDService - {@link TaskCRUDService}
     * @return {@link TaskCRUDService}
     */
    public TaskCRUDService getTaskCRUDService() {
        if (userCRUDService == null) {
			userCRUDService = ManagerInstance.get(TaskCRUDService.class);
		}
        return userCRUDService;
    }

    /**
     * Serviço de persistencia de {@link TaskEntity}
     * @return {@link AbstractCRUDService} of {@link TaskEntity}
     */
    @Override
    protected AbstractCRUDService<TaskEntity, TaskDTO> getService() {
        return getTaskCRUDService();
    }
}