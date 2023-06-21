package com.livro.livro.Pedido;

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
public class PedidoResource {

    @Autowired
    public PedidoService PedidoService;

    @GetMapping("/menu/pedido")
    public List<PedidoTO> getNmPedidoTOs(@RequestParam(name = "nump", defaultValue = "") String nump) {
        return (nump.length() > 0)
                ? PedidoService.list().stream()
                        .filter(pedido -> pedido.nump().toLowerCase().contains(nump.toLowerCase())).toList()
                : PedidoService.list();
    }

    @GetMapping("/menu/pedido/{id}")
    public PedidoTO getNmPedidoTO(@PathVariable("id") String id) {
        return PedidoService.find(id);
    }

    @PostMapping("/menu/pedido")
    public void postNmPedidoTOs(@RequestBody PedidoTO in) {
        PedidoService.create(in);
    }

    @DeleteMapping("/menu/pedido/{id}")
    public void deleteNmPedidoTOs(@PathVariable("id") String id) {
        PedidoService.delete(id);
    }

    @PutMapping("/menu/pedido/{id}")
    public void putNmPedidoTOs(@PathVariable("id") String id, @RequestBody PedidoTO in) {
        PedidoService.update(id, in);
    }
}