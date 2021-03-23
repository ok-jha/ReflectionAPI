package shivam.reflection.util;

import java.lang.reflect.Field;

public class PrimaryKeyField {

	private Field field;

	public PrimaryKeyField(Field field) {
		this.field = field;
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		// TODO Auto-generated method stub
		return field.getName();
	}

	public Class<?> getType() {
		// TODO Auto-generated method stub
		return field.getType();
	}

}
