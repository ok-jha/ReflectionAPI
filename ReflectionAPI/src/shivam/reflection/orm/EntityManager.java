package shivam.reflection.orm;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

import shivam.reflection.annotation.PrimaryKey;
import shivam.reflection.model.person;

public interface EntityManager<T> {

	static <T> EntityManager<T> of(Class<T> clss) {
		// TODO Auto-generated method stub
		return new EntityManagerImpl<>();
	}

	void persist(T t) throws IllegalArgumentException, IllegalAccessException, SQLException;

	T find(Class<T> clss, Object primaryKey)throws SQLException,InstantiationException ,IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,SecurityException;

}
