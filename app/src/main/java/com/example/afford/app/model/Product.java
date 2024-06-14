package com.example.afford.app.model;

import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="CreateJob")
public class Product{
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	private Long pid;
	private String productname;
    private String price;
    private String rating;
    private String discount;
    private String availability;
	
}
