package com.livro.livro.Menu;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "menu")

public class Menu{

    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    
    @Column(name = "id")
    private String id;

    @Column(name = "prato")
    private String prato;

    @Column(name = "preco")
    private float preco;


    public String getId() {
        return id;
    }

    public String getPrato() {
        return prato;
    }

    public float getPreco() {
        return preco ;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPrato(String prato) {
        this.prato = prato;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public Menu() {

    }

    public Menu(MenuTO to) {
        this.id = to.id();
        this.prato = to.prato();
        this.preco = to.preco();
    }
  
    


}