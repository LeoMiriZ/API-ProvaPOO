package com.livro.livro.ItemPedido;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
public class ItemPedidoResource {

    @Autowired
    public ItemPedidoService itemPedidoService;

    @GetMapping("/menu/item")
    public List<ItemPedidoTO> getPratos(@RequestParam(name = "prato", defaultValue = "") String prato) {
        return (prato.length() > 0)
            ? itemPedidoService.list().stream().filter(menu -> menu.prato().toLowerCase().contains(prato.toLowerCase())).toList()
            : itemPedidoService.list();
    }

    @GetMapping("/menu/item/{id}")
    public ItemPedidoTO getPrato(@PathVariable("id") String id) {
        return itemPedidoService.find(id);
    }

    @PostMapping("/menu/item")
    public void postPrato(@RequestBody ItemPedidoTO in) {
        itemPedidoService.create(in);
    }

    @DeleteMapping("/menu/item/{id}")
    public void deletePrato(@PathVariable("id") String id) {
        itemPedidoService.delete(id);
    }
    
    @PutMapping("/menu/item/{id}")
    public void putPrato(@PathVariable("id") String id, @RequestBody ItemPedidoTO in) {
        itemPedidoService.update(id, in);
    }
}