package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	// Criando uma estância única
	private static EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("DafitiTestPU");
	// Sem dar new no JPAUtil
	public static EntityManager getEntityManager() {
		EntityManager sessao = fabrica.createEntityManager();
		return sessao;
	}
}