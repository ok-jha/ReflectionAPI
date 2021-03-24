package shivam.reflection.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.h2.index.Index;

import shivam.reflection.annotation.Column;
import shivam.reflection.annotation.PrimaryKey;
import shivam.reflection.model.person;

public class Metamodel {
	private Class<?> clss;
	private String collect;

	public static Metamodel of(Class<?> clss) {
		// TODO Auto-generated method stub
		return new Metamodel(clss);
	}
	
	public Metamodel(Class<?> clss) {
		this.clss = clss;
		// TODO Auto-generated constructor stub
	}

	public PrimaryKeyField getPrimaryKey() {
		Field[] fields = clss.getDeclaredFields();
		for (Field field : fields) {
			PrimaryKey primaryKey = field.getAnnotation(PrimaryKey.class);
			if(primaryKey != null) {
				PrimaryKeyField primaryKeyField =new PrimaryKeyField(field);
				return primaryKeyField;
			}
		}
		throw new IllegalArgumentException("No Primary Key Found in Class"+ clss.getSimpleName());
	}

	public List<ColumnField> getColumns() {
		List<ColumnField> columnFields = new ArrayList<>();
		Field[] fields = clss.getDeclaredFields();
		for (Field field : fields) {
			Column column = field.getAnnotation(Column.class);
			if(column != null) {
				ColumnField columnField =new ColumnField(field);		
				columnFields.add(columnField);
			}
		}
		return columnFields;
	}

	public String buildInsertRequest() {
		//insert into person(id,name,age) value(?,?,?)
		String columnElement = buildColumnNames();
	    
	    String questionMarkElement = buildQuestionMarksElement();
	    
		return "insert into "+ this.clss.getSimpleName()+
				" ("+columnElement+") values ("+ questionMarkElement+")";
	}
	
	public String buildSelectRequest() {
		// select id , name, age from person where id =?
		String columnElement = buildColumnNames();
		return "select "+ columnElement + " from "+ this.clss.getSimpleName() + 
				 	 " where "+ getPrimaryKey().getName() + " ?";
	}

	private String buildQuestionMarksElement() {
		int numberOfColumns = getColumns().size()+1;
	    String questionMarkElement = IntStream.range(0, numberOfColumns).mapToObj(Index -> "?").
	    collect(Collectors.joining(", "));
		return questionMarkElement;
	}

	private String buildColumnNames() {
		String primaryKeyColumnName = getPrimaryKey().getName();
		List<String> columnNames = 
				getColumns().stream().map(ColumnField::getName).collect(Collectors.toList());
		columnNames.add(0, primaryKeyColumnName);
	    String columnElement = String.join(", ", columnNames);
		return columnElement;
	}

	

}
