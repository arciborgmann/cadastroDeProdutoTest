package dao;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import domain.Produto;

@FixMethodOrder(MethodSorters.JVM)
public class ProdutoDAOTest {
	private ProdutoDAO produtoDAO;
	
	@Before
	public void iniciar() {
		produtoDAO = new ProdutoDAO();
	}

	private void salvar() {
		Produto p1 = new Produto();
		p1.setDataDeValidade(LocalDate.of(2022, 3, 1));
		p1.setNome("Coca Cola 2LT");
		p1.setPreco(BigDecimal.valueOf(10.50));
		p1.setQuantidade(15);
		
		//Produto p2 = new Produto(null, "Heineken", 10, null, null, BigDecimal.valueOf(8.00), LocalDate.of(2022, 3, 3), null);

		produtoDAO.salvar(p1);
		//produtoDAO.salvar(p2);
	}

	private void buscar() {
		Produto p1 = produtoDAO.buscar(1);
		//Produto p2 = produtoDAO.buscar(2);

		System.out.println(p1);
		//System.out.println(p2);
	}
	
	private void listar() {
		List<Produto> produtos = produtoDAO.listar();
		
		for(Produto produto : produtos) {
			System.out.println(produto);
		}
	}
	
	@Test
	public void testar() {
		salvar();
		buscar();
		listar();
	}
}
