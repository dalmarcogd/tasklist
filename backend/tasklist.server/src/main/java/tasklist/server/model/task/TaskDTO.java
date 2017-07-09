package tasklist.server.model.task;

import java.util.Date;

import tasklist.server.model.base.BaseDTO;
import tasklist.server.model.user.UserEntity;

/**
 * Representa um {@link UserEntity}.
 *
 * @author Guilherme Dalmarco (dalmarco.gd@gmail.com)
 */
public class TaskDTO extends BaseDTO {

	private String title;
	private String description;
	private TaskStatus taskStatus = TaskStatus.OPENED;
	private Date dateStart;
	private Date dateUpdate;
	private Date dateRemove;
	private Date dateEnd;
    private Long idUser;

	/**
	 * Retorna uma instancia de {@link String}
	 * @return {@link String}
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Atribui um {@link String}
	 * @param title - {@link String}
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Retorna uma instancia de {@link String}
	 * @return {@link String}
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Atribui um {@link String}
	 * @param description - {@link String}
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Retorna uma instancia de {@link TaskStatus}
	 * @return {@link TaskStatus}
	 */
	public TaskStatus getTaskStatus() {
		return taskStatus;
	}

	/**
	 * Atribui um {@link TaskStatus}
	 * @param taskStatus - {@link TaskStatus}
	 */
	public void setTaskStatus(TaskStatus taskStatus) {
		this.taskStatus = taskStatus;
	}

	/**
	 * Retorna uma instancia de {@link Date}
	 * @return {@link Date}
	 */
	public Date getDateStart() {
		return dateStart;
	}

	/**
	 * Atribui um {@link Date}
	 * @param dateStart - {@link Date}
	 */
	public void setDateStart(Date dateStart) {
		this.dateStart = dateStart;
	}

	/**
	 * Retorna uma instancia de {@link Date}
	 * @return {@link Date}
	 */
	public Date getDateUpdate() {
		return dateUpdate;
	}

	/**
	 * Atribui um {@link Date}
	 * @param dateUpdate - {@link Date}
	 */
	public void setDateUpdate(Date dateUpdate) {
		this.dateUpdate = dateUpdate;
	}

	/**
	 * Retorna uma instancia de {@link Date}
	 * @return {@link Date}
	 */
	public Date getDateRemove() {
		return dateRemove;
	}

	/**
	 * Atribui um {@link Date}
	 * @param dateRemove - {@link Date}
	 */
	public void setDateRemove(Date dateRemove) {
		this.dateRemove = dateRemove;
	}

	/**
	 * Retorna uma instancia de {@link Date}
	 * @return {@link Date}
	 */
	public Date getDateEnd() {
		return dateEnd;
	}

	/**
	 * Atribui um {@link Date}
	 * @param dateEnd - {@link Date}
	 */
	public void setDateEnd(Date dateEnd) {
		this.dateEnd = dateEnd;
	}

	/**
	 * Retorna uma instancia de {@link Long}
	 * @return {@link Long}
	 */
	public Long getIdUser() {
		return idUser;
	}

	/**
	 * Atribui um {@link Long}
	 * @param idUser - {@link Long}
	 */
	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}
}