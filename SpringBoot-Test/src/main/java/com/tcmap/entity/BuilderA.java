package com.tcmap.entity;

public class BuilderA extends Builder{
   private Product product = new Product();
   
	@Override
	 public void buildPartA() {
		product.addPart("parta");
	}
	@Override
	 public void buildPartB() {
		product.addPart("partb");
	}
	@Override
	 public void buildPartC() {
		product.addPart("partc");
	}
	@Override
	public Product getResult() {
		return product;
	}
}
