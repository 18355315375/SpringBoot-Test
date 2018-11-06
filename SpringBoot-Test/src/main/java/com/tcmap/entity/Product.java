package com.tcmap.entity;

import java.util.ArrayList;
import java.util.List;
/**
 *      产品
 * @author 西红柿爱茄子
 *
 */
public class Product {
  private List<String> list = new ArrayList<>();
  
  public void addPart(String partName) {
	  list.add(partName);
  }
  
  public void show() {
	  for (String string : list) {
		System.out.println(string);
	}
  }
}
