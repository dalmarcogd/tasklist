package tasklist.server.crud.task.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.WebRequest;

import tasklist.server.crud.base.repository.AbstractCRUDRepository;
import tasklist.server.crud.base.service.AbstractCRUDService;
import tasklist.server.crud.task.repository.TaskCRUDRepository;
import tasklist.server.crud.user.service.UserAuthenticationService;
import tasklist.server.crud.user.service.UserQueryService;
import tasklist.server.model.base.BaseDTO;
import tasklist.server.model.task.TaskDTO;
import tasklist.server.model.task.TaskEntity;
import tasklist.server.model.user.Credentials;
import tasklist.server.model.user.UserEntity;

/**
 * Serviço de persistencia de {@link TaskEntity}
 *
 * @author Guilherme Dalmarco (dalmarco.gd@gmail.com)
 */
@Service
public class TaskCRUDService extends AbstractCRUDService<TaskEntity, TaskDTO> {

    @Autowired
    private TaskCRUDRepository userCRUDRepository;
    @Autowired
    private UserQueryService userQueryService;
    @Autowired
    private UserAuthenticationService userAuthenticationService;

    /**
     * {@inheritDoc}
     */
    @Override
    protected AbstractCRUDRepository<TaskEntity> getCRUDRepository() {
        return userCRUDRepository;
    }

    /**
     * Converte os dados do dto para entity.
     * @param dto    - {@link BaseDTO}
     * @param entity - {@link TaskEntity}
     * @return {@link TaskEntity}
     */
    @Override
    public TaskEntity convertToEntity(TaskDTO dto, TaskEntity entity) {
    	entity.setId(dto.getId());
    	entity.setVersion(dto.getVersion());
    	entity.setTitle(dto.getTitle());
    	entity.setDescription(dto.getDescription());
    	entity.setTaskStatus(dto.getTaskStatus());
    	entity.setDateStart(dto.getDateStart());
    	entity.setDateUpdate(dto.getDateUpdate());
    	entity.setDateRemove(dto.getDateRemove());
    	entity.setDateEnd(dto.getDateEnd());
    	Credentials c = this.userAuthenticationService.getCredentials(String.valueOf(RequestContextHolder.getRequestAttributes().getAttribute("token", WebRequest.SCOPE_REQUEST)));
    	if (c != null) {
    		UserEntity userByUsername = userQueryService.getUserByUsername(c.getUsername());
    		entity.setUser(userByUsername);
		}
        return entity;
    }

    /**
     * Converte os dados do entity para dto.
     * @param dto    - {@link BaseDTO}
     * @param entity - {@link TaskEntity}
     * @return {@link TaskDTO}
     */
    @Override
    public TaskDTO convertToDTO(TaskEntity entity, TaskDTO dto) {
    	dto.setId(entity.getId());
    	dto.setVersion(entity.getVersion());
    	dto.setTitle(entity.getTitle());
    	dto.setDescription(entity.getDescription());
    	dto.setTaskStatus(entity.getTaskStatus());
    	dto.setDateStart(entity.getDateStart());
    	dto.setDateUpdate(entity.getDateUpdate());
    	dto.setDateRemove(entity.getDateRemove());
    	dto.setDateEnd(entity.getDateEnd());
//    	dto.setIdUser(entity.getUser() != null? entity.getUser().getId() : null);
        return dto;
    }

    /**
     * Cria uma entidade nova e vazia.
     * @return {@link TaskEntity}
     */
    @Override
    public TaskEntity createEmptyEntity() {
        return new TaskEntity();
    }

    @Override
    public TaskDTO createEmptyDTO() {
        return new TaskDTO();
    }

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void internalValidate(TaskEntity entity) {

	}
}