package com.tcmap.entity;

/**
 *  指导员
 * @author 西红柿爱茄子
 *
 */
public class BuilderDirector {
    
	private Builder builder = null;
	
	public BuilderDirector() {}
	public BuilderDirector(Builder builder) {
		this.builder = builder;
	}
	
	public Product build() {
		builder.buildPartA();
		builder.buildPartB();
		builder.buildPartC();
		return builder.getResult();
	}
}
