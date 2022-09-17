package br.com.fiap.challenge.model;

import javax.persistence.*;

@Entity
@SequenceGenerator(name="produto",sequenceName = "TB_PRODUTO",allocationSize = 1)
public class Produto {

	// ATRIBUTOS
	
	@Id
	@GeneratedValue(generator = "produto", strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String nome; 

	private Long estoque;
	
    private Double valor;
	


	// METODOS GET E SET
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Long getEstoque() {
		return estoque;
	}

	public void setEstoque(Long estoque) {
		this.estoque = estoque;
	}

	
}