package com.sapient.product.app.productapp;

public class Product {

	private String id;

	private String name;

	private String type;

	private boolean avalability;

	public Product(String id, String name, String type, boolean avalability) {
		this.id = id;
		this.name = name;
		this.type = type;
		this.avalability = avalability;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean isAvalability() {
		return avalability;
	}

	public void setAvalability(boolean avalability) {
		this.avalability = avalability;
	}

}
