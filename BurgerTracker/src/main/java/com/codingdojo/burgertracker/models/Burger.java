package com.codingdojo.burgertracker.models;

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
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="burger")
public class Burger {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Size(min=2, max=255)
	@NotEmpty(message="burger name is requried")
	private String burgername;
	
	@Size(min=2, max=255)
	@NotEmpty(message = "restaurant name is required")
	private String restaurantname;
	
	@Min(0)
	@Max(5)
	@NotNull
	private Integer rating;
	
	@Size(min=5, max=255)
	@NotBlank(message="notes cannot be blank and is required")
	private String notes;
	
	@Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
	
	
	public Burger() {
	
	}


	public Burger(@Size(min = 2, max = 255) @NotEmpty(message = "burger name is requried") String burgername,
			@Size(min = 2, max = 255) @NotEmpty(message = "restaurant name is required") String restaurantname,
			@Min(0) @Max(5) @NotNull Integer rating,
			@Size(min = 5, max = 255) @NotBlank(message = "notes cannot be blank and is required") String notes) {
		super();
		this.burgername = burgername;
		this.restaurantname = restaurantname;
		this.rating = rating;
		this.notes = notes;
	}


	public Burger(Long id, @Size(min = 2, max = 255) @NotEmpty(message = "burger name is requried") String burgername,
			@Size(min = 2, max = 255) @NotEmpty(message = "restaurant name is required") String restaurantname,
			@Min(0) @Max(5) @NotNull Integer rating,
			@Size(min = 5, max = 255) @NotBlank(message = "notes cannot be blank and is required") String notes) {
		super();
		this.id = id;
		this.burgername = burgername;
		this.restaurantname = restaurantname;
		this.rating = rating;
		this.notes = notes;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getBurgername() {
		return burgername;
	}


	public void setBurgername(String burgername) {
		this.burgername = burgername;
	}


	public String getRestaurantname() {
		return restaurantname;
	}


	public void setRestaurantname(String restaurantname) {
		this.restaurantname = restaurantname;
	}


	public Integer getRating() {
		return rating;
	}


	public void setRating(Integer rating) {
		this.rating = rating;
	}


	public String getNotes() {
		return notes;
	}


	public void setNotes(String notes) {
		this.notes = notes;
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
