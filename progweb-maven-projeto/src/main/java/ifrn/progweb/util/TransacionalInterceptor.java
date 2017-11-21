package ifrn.progweb.util;

import java.io.Serializable;

import javax.annotation.Priority;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

// anotação do CDI que informa que esta classe é interceptadora.
@Interceptor
// informa ao CDI que a classe (poderia ser método também) abre e fecha transações.
@Transacional
// ativar o interceptador com prioridade de aplicação.
@Priority(Interceptor.Priority.APPLICATION)     
public class TransacionalInterceptor implements Serializable {

	private static final long serialVersionUID = 1L;

	// atributo que será injetado pelo CDI depois da chamada do método produtor.
	@Inject     
	private EntityManager manager;

	// método interceptador que é chamado pela anotação @Transacional.
	@AroundInvoke      
	public Object invoke(InvocationContext context) throws Exception {
		EntityTransaction trx = manager.getTransaction();
		boolean criador = false;

		try {
			if (!trx.isActive()) {
				// truque para fazer rollback no que já passou
				// (senão, um futuro commit confirmaria até mesmo operações sem transação)
				trx.begin();
				trx.rollback();

				// agora sim inicia a transação
				trx.begin();

				criador = true;
			}

			return context.proceed();
		} catch (Exception e) {
			if (trx != null && criador) {
				trx.rollback();
			}

			throw e;
		} finally {
			if (trx != null && trx.isActive() && criador) {
				trx.commit();
			}
		}
	}

}