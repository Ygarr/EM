package net.kldov.employeemanager.domain;

/**
 * Описываем сущность Entity Сотрудник
 */

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import org.apache.commons.lang.WordUtils;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
/**
 * @Table Свойства класса будем хранить в таблице employees.
 */
@Table(name = "employees")
public class Employee {

	/**
	 * Значение поля ID идентификатор будет назначаться не нами, а генерироваться автоматически.
	 * id
	 */
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
		
	/**
	 * firstname
	 */
	@Column(name = "FIRSTNAME")
	@Pattern(regexp = "^[a-zA-Zа-яА-Я]+$",message="Имя сотрудника должно состоять только из букв алфавита")
	@NotEmpty(message = "Имя сотрудника должно быть задано(Аннотац.)")
	private String firstname;
		
	/**
	 * lastname
	 */
	@Column(name = "LASTNAME")
	@Pattern(regexp = "^[a-zA-Zа-яА-Я]+$",message="Фамилия сотрудника должна состоять только из букв алфавита")
	@NotEmpty(message = "Фамилия сотрудника должна быть задана(Аннотац.)")
	private String lastname;
	
	/**
	 * salary
	 */
	@Column(name = "SALARY")
	private Double salary;
	
	/**
	 * birthday
	 */
	@Column(name = "BIRTHDAY")
	private Date birthday;
	
	/**
	 * По умолчанию — Сотрудник "Работает"
	 * active
	 */
	@Column(name = "ACTIVE")
	private Boolean active=true;
	
	/**
	 * division
	 */
	@ManyToOne (fetch=FetchType.EAGER)
	@JoinColumn (name="division_ID",nullable=true)
	public Division division;
	
	
	/**
	 * Getter
	 * @return id
	 */
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
	 * @return firtsname
	 */
	public String getFirstname() {
		return firstname;
	}
	/**
	 * Setter
	 * @param firstname
	 */
	public void setFirstname(String firstname) {
			this.firstname = WordUtils.capitalizeFully(firstname).trim();
	}
	
	/**
	 * Getter
	 * @return lastname
	 */
	public String getLastname() {
		return lastname;
	}
	/**
	 * Setter
	 * @param lastname
	 */
	public void setLastname(String lastname) {
		 this.lastname = WordUtils.capitalizeFully(lastname).trim();
		}
	/**
	 * Getter
	 * @return salary
	 */
	public Double getSalary() {
		return salary;
	}
	/**
	 * Setter
	 * @param salary
	 */
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	
	/**
	 * Getter
	 * @return birthday
	 */
	public Date getBirthday() {
		return birthday;
	}
	
	/**
	 * Setter
	 * @param birthday
	 */
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	/**
	 * Getter
	 * @return active
	 */
	public Boolean getActive() {
		return active;
	}

	/**
	 * Setter
	 * @param active
	 */
	public void setActive(Boolean active) {
		this.active = active;
	}
	
	/**
	 * Getter
	 * @return division
	 */
	public Division getDivision() {
		return division;
	}
	
	/**
	 * Setter
	 * @param division
	 */
	public void setDivision(Division division) {
		this.division = division;
	}
	
	
}
