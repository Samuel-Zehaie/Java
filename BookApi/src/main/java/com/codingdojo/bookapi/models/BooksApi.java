package com.codingdojo.bookapi.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="book")
public class BooksApi {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	@Size(min=3, max=255)
	@NotEmpty(message="title is required")
	private String title;
	
	@Size(min=5, max=100)
	@NotEmpty(message="description is required")
	private String description;
	
	@Size(min=5, max=10)
	@NotEmpty(message="lang is required")
	private String lang;
	
	@Min(0)
	@NotNull
	private Integer numofpages;
	
	@Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;

	public BooksApi() {
		
	}

	public BooksApi(@Size(min = 3, max = 255) @NotEmpty(message = "title is required") String title,
			@Size(min = 5, max = 100) @NotEmpty(message = "description is required") String description,
			@Size(min = 5, max = 10) @NotEmpty(message = "lang is required") String lang,
			@Min(0) @NotNull Integer numofpages) {
		super();
		this.title = title;
		this.description = description;
		this.lang = lang;
		this.numofpages = numofpages;
	}

	public BooksApi(Long id, @Size(min = 3, max = 255) @NotEmpty(message = "title is required") String title,
			@Size(min = 5, max = 100) @NotEmpty(message = "description is required") String description,
			@Size(min = 5, max = 10) @NotEmpty(message = "lang is required") String lang,
			@Min(0) @NotNull Integer numofpages) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.lang = lang;
		this.numofpages = numofpages;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	public Integer getNumofpages() {
		return numofpages;
	}

	public void setNumofpages(Integer numofpages) {
		this.numofpages = numofpages;
	}

	public Long getId() {
		return id;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}
	
	//adds the created at date and time to sql on creation
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    //add the updated at date and time when being updated
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }

}
