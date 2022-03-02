package bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.omnifaces.util.Messages;

import dao.CategoriaDAO;
import dao.ProdutoDAO;
import domain.Categoria;
import domain.Produto;
import lombok.Data;

@SuppressWarnings("serial")
@Named
@ViewScoped
@Data

public class ProdutoBean implements Serializable {
	private Produto produto;
	private List<Categoria> categorias;
	private List<Produto> produtos;
	private CategoriaDAO categoriaDAO;
	private ProdutoDAO produtoDAO;
	
	@PostConstruct
	public void iniciar() {
		categoriaDAO = new CategoriaDAO();
		produtoDAO = new ProdutoDAO();
		produto = new Produto();
		categorias = categoriaDAO.listar();
		produtos = produtoDAO.listar();
	}
	
	public void salvar() {
		produtoDAO.salvar(produto);
		produto = new Produto();
		categorias = categoriaDAO.listar();
		produtos = produtoDAO.listar();
		Messages.addGlobalInfo("Produto salvo com sucesso");
	}
}
