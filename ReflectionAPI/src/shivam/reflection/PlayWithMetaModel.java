package shivam.reflection;



import java.util.List;

import shivam.reflection.model.person;
import shivam.reflection.util.ColumnField;
import shivam.reflection.util.Metamodel;
import shivam.reflection.util.PrimaryKeyField;

public class PlayWithMetaModel {

	public static void main(String[] args) {
		Metamodel<person> metamodel = Metamodel.of(person.class);
		
		PrimaryKeyField primaryKeyField = metamodel.getPrimaryKey();
		List<ColumnField> columnFields = metamodel.getColumns();
		
		System.out.println("Primary Key Name: "+primaryKeyField.getName()+ ", type : "
				+primaryKeyField.getType().getSimpleName());
		
		for (ColumnField columnField : columnFields) {
			System.out.println("Column Name: "+columnField.getName()+ ", type : "
					+columnField.getType().getSimpleName());
		}
		
	}

}
