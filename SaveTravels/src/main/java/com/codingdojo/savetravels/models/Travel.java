package com.codingdojo.savetravels.models;

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
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table (name="travel")
public class Travel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Size(min=2, max=255)
	@NotBlank(message="expense is required")
	private String expense;
	
	@Size(min=2, max=255)
	@NotBlank(message="expense is required")
	private String vendor;
	
	@Min(0)
	@NotNull
	private Double amount;
	
	@Size (min=2, max=255)
	@NotBlank(message="description is required")
	private String Description;
	
	
	@Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
	
    
    
	public Travel() {
		
	}



	public Travel(@Size(min = 2, max = 255) @NotBlank(message = "expense is required") String expense,
			@Size(min = 2, max = 255) @NotBlank(message = "expense is required") String vendor,
			@Min(0) @NotNull Double amount,
			@Size(min = 2, max = 255) @NotBlank(message = "description is required") String description) {
		super();
		this.expense = expense;
		this.vendor = vendor;
		this.amount = amount;
		Description = description;
	}



	public Travel(Long id, @Size(min = 2, max = 255) @NotBlank(message = "expense is required") String expense,
			@Size(min = 2, max = 255) @NotBlank(message = "expense is required") String vendor,
			@Min(0) @NotNull Double amount,
			@Size(min = 2, max = 255) @NotBlank(message = "description is required") String description) {
		super();
		this.id = id;
		this.expense = expense;
		this.vendor = vendor;
		this.amount = amount;
		Description = description;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getExpense() {
		return expense;
	}



	public void setExpense(String expense) {
		this.expense = expense;
	}



	public String getVendor() {
		return vendor;
	}



	public void setVendor(String vendor) {
		this.vendor = vendor;
	}



	public Double getAmount() {
		return amount;
	}



	public void setAmount(Double amount) {
		this.amount = amount;
	}



	public String getDescription() {
		return Description;
	}



	public void setDescription(String description) {
		Description = description;
	}



	public Date getCreatedAt() {
		return createdAt;
	}



	public Date getUpdatedAt() {
		return updatedAt;
	}
	
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
