package br.com.fiap.challenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.fiap.challenge.model.Pedido;


public interface PedidoRepository extends JpaRepository<Pedido, Long>{
}