package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import domain.Produto;
import util.JPAUtil;

public class ProdutoDAO {
	public void salvar(Produto produto) {
		//Pego uma sessão
		EntityManager sessao = JPAUtil.getEntityManager();
		//Crio uma transação
		EntityTransaction transaction = sessao.getTransaction();
		//Inicio a transação
		transaction.begin();
		sessao.persist(produto);
		transaction.commit();
		sessao.close();
	}
	
	public Produto buscar(Integer codigo) {
		EntityManager sessao = JPAUtil.getEntityManager();
		Produto produto = sessao.find(Produto.class, codigo);
		return produto;
	}
	
	@SuppressWarnings("unchecked")
	public List<Produto> listar() {
		//Não é necessário transaction, pois é uma consulta
		String jpql = "SELECT p FROM Produto p ORDER BY codigo ASC";
		
		EntityManager sessao = JPAUtil.getEntityManager();
		Query consulta = sessao.createQuery(jpql);
		List<Produto> resultado = consulta.getResultList();
		return resultado;
	}
}