package tasklist.server.crud.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tasklist.server.crud.base.repository.AbstractCRUDRepository;
import tasklist.server.crud.base.service.AbstractCRUDService;
import tasklist.server.crud.user.repository.UserCRUDRepository;
import tasklist.server.model.base.BaseDTO;
import tasklist.server.model.user.UserDTO;
import tasklist.server.model.user.UserEntity;

/**
 * Serviço de persistencia de {@link UserEntity}
 *
 * @author Guilherme Dalmarco (dalmarco.gd@gmail.com)
 */
@Service
public class UserCRUDService extends AbstractCRUDService<UserEntity, UserDTO> {

    @Autowired
    private UserCRUDRepository userCRUDRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    protected AbstractCRUDRepository<UserEntity> getCRUDRepository() {
        return userCRUDRepository;
    }

    /**
     * Converte os dados do dto para entity.
     * @param dto    - {@link BaseDTO}
     * @param entity - {@link UserEntity}
     * @return {@link UserEntity}
     */
    @Override
    public UserEntity convertToEntity(UserDTO dto, UserEntity entity) {
        entity.setName(dto.getName());
        entity.setEmail(dto.getEmail());
        entity.setUsername(dto.getUsername());
        entity.setPassword(dto.getPassword());
        entity.setId(dto.getId());
        entity.setVersion(dto.getVersion());
        return entity;
    }

    /**
     * Converte os dados do entity para dto.
     * @param dto    - {@link BaseDTO}
     * @param entity - {@link UserEntity}
     * @return {@link TaskDTO}
     */
    @Override
    public UserDTO convertToDTO(UserEntity entity, UserDTO dto) {
        dto.setName(entity.getName());
        dto.setEmail(entity.getEmail());
        dto.setUsername(entity.getUsername());
        dto.setPassword(entity.getPassword());
        dto.setId(entity.getId());
        dto.setVersion(entity.getVersion());
        return dto;
    }

    /**
     * Cria uma entidade nova e vazia.
     * @return {@link UserEntity}
     */
    @Override
    public UserEntity createEmptyEntity() {
        return new UserEntity();
    }

    @Override
    public UserDTO createEmptyDTO() {
        return new UserDTO();
    }

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void internalValidate(UserEntity entity) {

	}
}