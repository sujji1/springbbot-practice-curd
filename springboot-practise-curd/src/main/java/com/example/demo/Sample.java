package com.example.demo;

import jakarta.persistence.*;

@Entity
public class Sample {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
public Sample() {
	
}
public Sample(int id, String name) {
	super();
	this.id = id;
	this.name = name;
}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Sample [id=" + id + ", name=" + name + "]";
	}
	
	

}
