package com.tcmap.entity;
/**
 *   建造者抽象类
 * @author 西红柿爱茄子
 *
 */
public abstract class Builder {
   public abstract void buildPartA();
   public abstract void buildPartB();
   public abstract void buildPartC();
   
   public abstract Product getResult();
}
