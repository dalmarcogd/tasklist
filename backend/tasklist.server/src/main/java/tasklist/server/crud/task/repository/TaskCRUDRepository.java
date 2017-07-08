package tasklist.server.crud.task.repository;

import org.springframework.stereotype.Repository;

import tasklist.server.crud.base.repository.AbstractCRUDRepository;
import tasklist.server.model.task.TaskEntity;

/**
 * Respositório de {@link TaskEntity}.
 *
 * @author Guilherme Dalmarco (dalmarco.gd@gmail.com)
 */
@Repository
public class TaskCRUDRepository extends AbstractCRUDRepository<TaskEntity> {
}