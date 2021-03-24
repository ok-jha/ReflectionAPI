package shivam.reflection;

import shivam.reflection.model.person;
import shivam.reflection.orm.EntityManager;

public class ReadingObject {

	public static void main(String[] args)throws Exception {
		EntityManager<person> entityManager = EntityManager.of(person.class);
		
		person om = entityManager.find(person.class,1L);
		person shivam = entityManager.find(person.class,2L);
		person ok = entityManager.find(person.class,3L);
		person john = entityManager.find(person.class,4L);
		
		System.out.println(om);
        System.out.println(shivam);
        System.out.println(ok);
        System.out.println(john);

	}

}
