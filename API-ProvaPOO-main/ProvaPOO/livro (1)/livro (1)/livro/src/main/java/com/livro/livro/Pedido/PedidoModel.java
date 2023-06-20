package com.livro.livro.Pedido;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "pedido")

public class PedidoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)

    @Column(name = "id")
    private String id;

    @Column(name = "nump")
    private String nump;

    @Column(name = "total")
    private float total;

    @Column(name = "statusp")
    private String statusp;

    public String getId() {
        return id;
    }

    public String getNump() {
        return nump;
    }

    public float getTotal() {
        return total;
    }

    public String getStatus() {
        return statusp;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNump(String nump) {
        this.nump = nump;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public void setStatus(String status) {
        this.statusp = status;
    }

    public PedidoModel() {

    }

    public PedidoModel(PedidoTO to) {
        this.id = to.id();
        this.nump = to.nump();
        this.total = to.total();
        this.statusp = to.statusp();
    }

}