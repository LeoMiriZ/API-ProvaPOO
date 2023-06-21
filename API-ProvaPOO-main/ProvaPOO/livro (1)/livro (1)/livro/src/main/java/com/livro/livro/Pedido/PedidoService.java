package com.livro.livro.Pedido;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository PedidoRepository;

    public List<PedidoTO> list() {
        List<PedidoTO> pedido = new ArrayList<>();
        PedidoRepository.findAll()
                .forEach(l -> pedido.add(new PedidoTO(l.getId(), l.getNump(), l.getTotal(), l.getStatus())));
        return pedido;
    }

    public PedidoTO find(String id) {
        return PedidoRepository.findById(id)
                .map(l -> new PedidoTO(l.getId(), l.getNump(), l.getTotal(), l.getStatus()))
                .orElse(null);
    }

    public void create(PedidoTO pedido) {
        PedidoRepository.save(new PedidoModel(pedido));
    }

    public void delete(String id) {
        PedidoRepository.deleteById(id);
    }

    public void update(String id, PedidoTO in) {

        PedidoRepository.findById(id).ifPresent(l -> {
            l.setNump(in.nump());
            l.setTotal(in.total());
            l.setStatus(in.statusp());
            PedidoRepository.save(l);
        });
    }

}
