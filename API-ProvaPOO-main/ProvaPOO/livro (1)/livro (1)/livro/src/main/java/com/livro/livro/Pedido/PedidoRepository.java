package com.livro.livro.Pedido;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface PedidoRepository extends CrudRepository<PedidoModel, String> {
    
}
