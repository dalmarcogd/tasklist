package tasklist.server.crud.user.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tasklist.server.core.spring.context.ManagerInstance;
import tasklist.server.crud.base.controller.AbstractCRUDController;
import tasklist.server.crud.base.service.AbstractCRUDService;
import tasklist.server.crud.user.service.UserCRUDService;
import tasklist.server.model.user.UserDTO;
import tasklist.server.model.user.UserEntity;

/**
 * Implementação de {@link AbstractCRUDController} para {@link TaskDTO}
 *
 * @author Guilherme Dalmarco (dalmarco.gd@gmail.com)
 */
@RestController
@RequestMapping("/users")
public class UserCRUDController extends AbstractCRUDController<UserDTO, UserEntity> {

    private UserCRUDService userCRUDService;

    /**
     * Retorna o userCRUDService - {@link TaskCRUDService}
     * @return {@link TaskCRUDService}
     */
    public UserCRUDService getUserCRUDService() {
        if (userCRUDService == null) {
			userCRUDService = ManagerInstance.get(UserCRUDService.class);
		}
        return userCRUDService;
    }

    /**
     * Serviço de persistencia de {@link UserEntity}
     * @return {@link AbstractCRUDService} of {@link UserEntity}
     */
    @Override
    protected AbstractCRUDService<UserEntity, UserDTO> getService() {
        return getUserCRUDService();
    }
}