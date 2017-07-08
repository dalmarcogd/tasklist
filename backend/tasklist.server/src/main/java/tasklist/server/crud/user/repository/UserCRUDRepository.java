package tasklist.server.crud.user.repository;

import org.springframework.stereotype.Repository;

import tasklist.server.crud.base.repository.AbstractCRUDRepository;
import tasklist.server.model.user.UserEntity;

/**
 * Respositório de {@link UserEntity}.
 *
 * @author Guilherme Dalmarco (dalmarco.gd@gmail.com)
 */
@Repository
public class UserCRUDRepository extends AbstractCRUDRepository<UserEntity> {
}