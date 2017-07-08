package tasklist.server.model.base;

import java.sql.Timestamp;

import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

/**
 * Entidade b�sica para a implementa��o de uma entidade.
 *
 * <br />- <b>Data de cria��o:</b> 8 de jul de 2017
 *
 * @author Guilherme Dalmarco (dalmarco.gd@gmail.com)
 */
@MappedSuperclass
public abstract class BaseEntity {

    public static final String VERSION = "version";

    @Version
	private Timestamp version;

	/**
	 * Retorna um {@link Timestamp} - (version)
	 * @return {@link Timestamp}
	 */
	public final Timestamp getVersion() {
        return version;
	}

	/**
	 * Atribui um {@link Timestamp} para (version).
	 * @param version - {@link Timestamp}
	 */
	public final void setVersion(Timestamp version) {
        this.version = version;
	}

	/**
	 * Retorna uma instancia de {@link Long}
	 * @return {@link Long}
	 */
	public abstract Long getId();

	/**
	 * Atribui um {@link Long}
	 * @param id - {@link Long}
	 */
	public abstract void setId(Long id);
}