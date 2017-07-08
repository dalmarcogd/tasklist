package tasklist.server.model.task;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import tasklist.server.model.base.BaseEntity;
import tasklist.server.model.user.UserEntity;

/**
 * Define uma tarfe da aplicação.
 *
 * <br />- <b>Data de criação:</b> 8 de jul de 2017
 *
 * @autor Guilherme Dalmarco (dalmarco.gd@gmail.com)
 */
@Entity
@Table(name = "task")
public class TaskEntity extends BaseEntity {

	public static final String USER = "user";

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "task_id", nullable = false)
	private Long id;

	@NotNull
	@Column(nullable = false, name = "task_title")
	private String title;

	@NotNull
	@Column(nullable = true, name = "task_description")
	private String description;

	@Enumerated(EnumType.STRING)
	@Column(name = "task_status", nullable = false)
	private TaskStatus taskStatus = TaskStatus.OPENED;

	@Column(name = "task_date_start", nullable = false)
	private LocalDate dateStart;

	@Column(name = "task_date_update", nullable = true)
	private LocalDate dateUpdate;

	@Column(name = "task_date_remove", nullable = true)
	private LocalDate dateRemove;

	@Column(name = "task_date_end", nullable = true)
	private LocalDate dateEnd;

	@NotNull
    @ManyToOne(targetEntity = UserEntity.class, fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_user_task"), nullable = false, name = "task_user_id")
    private UserEntity user;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Long getId() {
		return this.id;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setId(Long id) {
		this.id = id;
	}

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
	 * Retorna uma instancia de {@link UserEntity}
	 * @return {@link UserEntity}
	 */
	public UserEntity getUser() {
		return user;
	}

	/**
	 * Atribui um {@link UserEntity}
	 * @param user - {@link UserEntity}
	 */
	public void setUser(UserEntity user) {
		this.user = user;
	}
}