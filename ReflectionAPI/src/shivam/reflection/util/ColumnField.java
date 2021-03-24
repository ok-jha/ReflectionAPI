package shivam.reflection.util;

import java.lang.reflect.Field;

public class ColumnField {

	private Field field;

	public ColumnField(Field field) {
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

	public Field getField() {
		return this.field;
		
	}

}
