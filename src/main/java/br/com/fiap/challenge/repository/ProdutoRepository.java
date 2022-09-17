package br.com.fiap.challenge.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.fiap.challenge.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

	//Pesquisar por parte do nome ignorando case sensitive
    List<Produto> findByNomeContainsIgnoreCase(String nome);

    List<Produto> deleteByNome(String nome);

}