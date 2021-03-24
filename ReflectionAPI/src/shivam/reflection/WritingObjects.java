package shivam.reflection;

import java.sql.SQLException;

import shivam.reflection.model.person;
import shivam.reflection.orm.EntityManager;

public class WritingObjects {

	public static void main(String[] args) throws Exception {
		EntityManager<person> entityManager= EntityManager.of(person.class);
		
		person om = new person("Om",28);
		person shivam = new person("Shivam",26);
		person ok = new person("OK",30);
		person john = new person("John",32);
		
		System.out.println(om);
        System.out.println(shivam);
        System.out.println(ok);
        System.out.println(john);
        
        System.out.println("Writing to Db");

        entityManager.persist(om);
        entityManager.persist(shivam);
        entityManager.persist(ok);
        entityManager.persist(john);
        
        System.out.println(om);
        System.out.println(shivam);
        System.out.println(ok);
        System.out.println(john);

	}

}
