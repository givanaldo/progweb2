package view;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.JpaUtil;

public class TesteLocadora {

	public static void main(String[] args) {
		
		EntityManager manager = JpaUtil.getEntityManager();

		//manager.getTransaction().begin();
		
		
			
		//manager.getTransaction().commit();
		
	}

}
