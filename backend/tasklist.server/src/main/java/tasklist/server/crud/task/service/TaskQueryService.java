package tasklist.server.crud.task.service;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tasklist.server.core.criteria.CriteriaFactory;
import tasklist.server.model.task.TaskEntity;

/**
 * Serviço de consulta de usuário.
 *
 * @author Guilherme Dalmarco (dalmarco.gd@gmail.com)
 */
@Service
public class TaskQueryService {

    @Autowired
    private CriteriaFactory criteriaFactory;

    @Transactional(readOnly = true)
    public List<TaskEntity> getTasksByUser(String username) {
        Criteria q = criteriaFactory.createCriteria(TaskEntity.class);
        q.add(Restrictions.eq("user.username", username));
        return q.list();
    }
}