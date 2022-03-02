package main;

import javax.persistence.EntityManager;

import util.JPAUtil;

public class TestConnection {
	public static void main(String[] args) {
		/*
		 * EntityManagerFactory fabrica =
		 * Persistence.createEntityManagerFactory("DafitiTestPU"); EntityManager sessao
		 * = fabrica.createEntityManager(); sessao.close(); fabrica.close(); 
		 * CTRL + SHIFT + o - Corrige as importações
		 */
		EntityManager sessao = JPAUtil.getEntityManager();
		sessao.close();
	}
}
