package com.livro.livro.Menu;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class MenuService {

    @Autowired
    private MenuRepository menuRepository;

    public List<MenuTO> list() {
        List<MenuTO> menu = new ArrayList<>();
        menuRepository.findAll().forEach(l -> 
            menu.add(new MenuTO(l.getId(), l.getPrato(),l.getPreco())));
        return menu;
    }

    public MenuTO find(String id) {
        return menuRepository.findById(id)
            .map(l -> new MenuTO(l.getId(), l.getPrato(),l.getPreco()))
            .orElse(null);
    }

    public void create(MenuTO menu) {
        menuRepository.save(new Menu(menu));
    }

    public void delete(String id) {
        menuRepository.deleteById(id);
    }

    public void update(String id, MenuTO in) {

        menuRepository.findById(id).ifPresent(l -> {
            l.setPrato(in.prato());
            l.setPreco(in.preco());
            menuRepository.save(l);
        });
    }
    
    
}
