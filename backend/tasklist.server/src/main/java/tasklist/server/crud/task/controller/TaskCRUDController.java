package tasklist.server.crud.task.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.WebRequest;

import tasklist.server.core.spring.context.ManagerInstance;
import tasklist.server.crud.base.controller.AbstractCRUDController;
import tasklist.server.crud.base.service.AbstractCRUDService;
import tasklist.server.crud.task.service.TaskCRUDService;
import tasklist.server.crud.task.service.TaskQueryService;
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
    private TaskQueryService taskQueryService;

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
	 * Retorna uma instancia de {@link TaskQueryService}
	 * @return {@link TaskQueryService}
	 */
	public TaskQueryService getTaskQueryService() {
		if (taskQueryService == null) {
			taskQueryService = ManagerInstance.get(TaskQueryService.class);
		}
		return taskQueryService;
	}

    /**
     * Serviço de persistencia de {@link TaskEntity}
     * @return {@link AbstractCRUDService} of {@link TaskEntity}
     */
    @Override
    protected AbstractCRUDService<TaskEntity, TaskDTO> getService() {
        return getTaskCRUDService();
    }

    /**
     * Disponibiliza uma forma de leitura da entidade a partir do id.
     * @param id - {@link Long}
     * @return {@link ResponseEntity}
     */
	@GetMapping(params={"username"})
    public @ResponseBody ResponseEntity<?> read(@RequestParam(value = "username") String username){
		RequestContextHolder.getRequestAttributes().setAttribute("username", username, WebRequest.SCOPE_REQUEST);
        return ResponseEntity.ok(getService().convertAllToDTO(getTaskQueryService().getTasksByUser(username)));
    }
}