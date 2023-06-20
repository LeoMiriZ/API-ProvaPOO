package com.livro.livro.ItemPedido;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class ItemPedidoService {

    @Autowired
    private ItemPedidoRepository itemPedidoRepository;

    public List<ItemPedidoTO> list() {
        List<ItemPedidoTO> item = new ArrayList<>();
        itemPedidoRepository.findAll().forEach(l -> 
            item.add(new ItemPedidoTO(l.getId(), l.getPrato(),l.getPreco())));
        return item;
    }

    public ItemPedidoTO find(String id) {
        return itemPedidoRepository.findById(id)
            .map(l -> new ItemPedidoTO(l.getId(), l.getPrato(),l.getPreco()))
            .orElse(null);
    }

    public void create(ItemPedidoTO item) {
        itemPedidoRepository.save(new ItemPedidoModel(item));
    }

    public void delete(String id) {
        itemPedidoRepository.deleteById(id);
    }

    public void update(String id, ItemPedidoTO in) {

        itemPedidoRepository.findById(id).ifPresent(l -> {
            l.setPrato(in.prato());
            l.setPreco(in.preco());
            itemPedidoRepository.save(l);
        });
    }
    
    
}
