package ifrn.progweb.view;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TesteBanco {

	public static void main(String[] args) {
		EntityManagerFactory factory = 
				Persistence.createEntityManagerFactory("ExemploPU");
		EntityManager manager = factory.createEntityManager();	
		
	}	
}
