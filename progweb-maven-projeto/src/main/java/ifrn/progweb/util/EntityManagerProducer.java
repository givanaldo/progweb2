package ifrn.progweb.util;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

// informa que a classe deve 'sobreviver' por todo o clico de vida da aplicação.
@ApplicationScoped
public class EntityManagerProducer {

	private EntityManagerFactory factory;
	
	public EntityManagerProducer() {
		this.factory = Persistence.createEntityManagerFactory("BancoPU");
	}
	
	// informa que é um método produtor de EntityManager.
	@Produces     
	// a cada requisição, uma instância nova é criada.
	@RequestScoped    
	public EntityManager createEntityManager() {
		return this.factory.createEntityManager();
	}
	
	// quando acabar o escopo do respectivo EntityManager, o mesmo é fechado.
	public void closeEntityManager(@Disposes EntityManager manager) {
		manager.close();
	}
}