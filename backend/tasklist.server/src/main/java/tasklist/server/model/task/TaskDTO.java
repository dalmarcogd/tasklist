package tasklist.server.model.task;

import java.time.LocalDate;

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
	private LocalDate dateStart;
	private LocalDate dateUpdate;
	private LocalDate dateRemove;
	private LocalDate dateEnd;
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
	 * Retorna uma instancia de {@link LocalDate}
	 * @return {@link LocalDate}
	 */
	public LocalDate getDateStart() {
		return dateStart;
	}

	/**
	 * Atribui um {@link LocalDate}
	 * @param dateStart - {@link LocalDate}
	 */
	public void setDateStart(LocalDate dateStart) {
		this.dateStart = dateStart;
	}

	/**
	 * Retorna uma instancia de {@link LocalDate}
	 * @return {@link LocalDate}
	 */
	public LocalDate getDateUpdate() {
		return dateUpdate;
	}

	/**
	 * Atribui um {@link LocalDate}
	 * @param dateUpdate - {@link LocalDate}
	 */
	public void setDateUpdate(LocalDate dateUpdate) {
		this.dateUpdate = dateUpdate;
	}

	/**
	 * Retorna uma instancia de {@link LocalDate}
	 * @return {@link LocalDate}
	 */
	public LocalDate getDateRemove() {
		return dateRemove;
	}

	/**
	 * Atribui um {@link LocalDate}
	 * @param dateRemove - {@link LocalDate}
	 */
	public void setDateRemove(LocalDate dateRemove) {
		this.dateRemove = dateRemove;
	}

	/**
	 * Retorna uma instancia de {@link LocalDate}
	 * @return {@link LocalDate}
	 */
	public LocalDate getDateEnd() {
		return dateEnd;
	}

	/**
	 * Atribui um {@link LocalDate}
	 * @param dateEnd - {@link LocalDate}
	 */
	public void setDateEnd(LocalDate dateEnd) {
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