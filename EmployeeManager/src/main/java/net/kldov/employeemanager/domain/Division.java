package net.kldov.employeemanager.domain;


/**
 * Описываем сущность Отдел
 */

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.apache.commons.lang.WordUtils;


@Entity
@Table(name = "division")
public class Division {

	/**
	 * Колонка для поля
	 * id
	 */
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	/**
	 * Колонка для поля
	 * name
	 */
	@Column(name = "NAME")
	private String name;
	
	/**
	 * Getter
	 * @return id
	 */
	@OneToMany(mappedBy = "division")
	public Integer getId() {
		return id;
	}
	/**
	 * Setter
	 * @param id
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	
	/**
	 * Getter
	 * @param name
	 */
	public String getNAME() {
		return name;
	}
	
	/**
	 * Setter
	 * @param name
	 */
	public void setNAME(String name) {
		this.name = WordUtils.capitalizeFully(name);
	}

}
