package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import domain.Categoria;
import util.JPAUtil;

public class CategoriaDAO {
	public void salvar(Categoria categoria) {
		//Pego uma sessão
		EntityManager sessao = JPAUtil.getEntityManager();
		//Crio uma transação
		EntityTransaction transaction = sessao.getTransaction();
		//Inicio a transação
		transaction.begin();
		sessao.persist(categoria);
		transaction.commit();
		sessao.close();
	}
	
	public Categoria buscar(Integer codigo) {
		EntityManager sessao = JPAUtil.getEntityManager();
		Categoria categoria = sessao.find(Categoria.class, codigo);
		return categoria;
	}
	
	@SuppressWarnings("unchecked")
	public List<Categoria> listar() {
		//Não é necessário transaction, pois é uma consulta
		String jpql = "SELECT c FROM Categoria c ORDER BY codigo ASC";
		
		EntityManager sessao = JPAUtil.getEntityManager();
		Query consulta = sessao.createQuery(jpql);
		List<Categoria> resultado = consulta.getResultList();
		return resultado;
	}
}