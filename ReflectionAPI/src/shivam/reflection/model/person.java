package shivam.reflection.model;

import shivam.reflection.annotation.Column;
import shivam.reflection.annotation.PrimaryKey;

public class person {
	@PrimaryKey
	private long id;
	@Column
	private String name;
	@Column
	private int age;
	public person() {
		
	}
	public person(String name, int age) {
		
		this.name = name;
		this.age = age;
	}
	public static person of(String name, int age) {
		return new person(name,age);
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "person [id= "+ id +", name= "+ name +", age="+ age +"]";
	}
	
	

}
