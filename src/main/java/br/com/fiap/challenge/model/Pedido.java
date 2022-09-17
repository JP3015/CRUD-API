package br.com.fiap.challenge.model;

import javax.persistence.*;

@Entity
@SequenceGenerator(name="pedido", sequenceName = "TB_PEDIDO", allocationSize = 1)
public class Pedido {

	// ATRIBUTOS
	
	@Id
	@GeneratedValue(generator = "pedido", strategy = GenerationType.IDENTITY)
	private Long id;
	
    private int quantidade;
	
    private Double valor_uni;

    private Double valor_total ;
	

	// METODOS GET E SET
	
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Double getValor_uni() {
        return valor_uni;
    }

    public void setValor_uni(Double valor_uni) {
        this.valor_uni = valor_uni;
    }

    public void setValor_total(Double valor_total) {
        this.valor_total = valor_uni * quantidade;
    } 
	
    public Double getValor_total() {
        if (quantidade <= 0 && valor_uni <=0){
            return 0.0;
        }
        else{
            return valor_uni * quantidade;
        } 
    }
}