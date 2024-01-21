package com.codingdojo.dojos_ninjas.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="Ninjas")
public class Ninjas {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message="first name is required")
	private String first;
	
	@NotBlank(message="last name is requried")
	private String last;
	
	@NotNull
	private Integer age;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="dojo_id")
    private Dojos dojo;
	
	@Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
	
	
	public Ninjas() {
		
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getFirst() {
		return first;
	}


	public void setFirst(String first) {
		this.first = first;
	}


	public String getLast() {
		return last;
	}


	public void setLast(String last) {
		this.last = last;
	}


	public Integer getAge() {
		return age;
	}


	public void setAge(Integer age) {
		this.age = age;
	}


	public Dojos getDojo() {
		return dojo;
	}


	public void setDojo(Dojos dojo) {
		this.dojo = dojo;
	}
	
	@PrePersist
    protected void onCreate(){
    	 this.createdAt = new Date();
    }
    @PreUpdate  
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
	
}
