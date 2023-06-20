package com.livro.livro.Menu;

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
public class MenuResource {

    @Autowired
    public MenuService menuService;

    @GetMapping("/menu")
    public List<MenuTO> getPratos(@RequestParam(name = "prato", defaultValue = "") String prato) {
        return (prato.length() > 0)
            ? menuService.list().stream().filter(menu -> menu.prato().toLowerCase().contains(prato.toLowerCase())).toList()
            : menuService.list();
    }

    @GetMapping("/menu/{id}")
    public MenuTO getPrato(@PathVariable("id") String id) {
        return menuService.find(id);
    }

    @PostMapping("/menu")
    public void postPrato(@RequestBody MenuTO in) {
        menuService.create(in);
    }

    @DeleteMapping("/menu/{id}")
    public void deletePrato(@PathVariable("id") String id) {
        menuService.delete(id);
    }
    
    @PutMapping("/menu/{id}")
    public void putPrato(@PathVariable("id") String id, @RequestBody MenuTO in) {
        menuService.update(id, in);
    }
}