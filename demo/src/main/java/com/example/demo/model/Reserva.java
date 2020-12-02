package com.example.demo.model;

public class Reserva {


    private Cliente cliente;
    private Veiculo veiculo;


    public void setVeiculo(Veiculo veiculo){
        this.veiculo = veiculo;
    }
    public void setCliente(Cliente cliente){
        this.cliente = cliente;
    }
    public Cliente getCliente(){
        return cliente;
    }
    public Veiculo getVeiculo(){
        return veiculo;
    }
}
