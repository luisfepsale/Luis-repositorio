package com.example.demo.model;

public class Veiculo {
    private int codigo;
    private String modelo;
    private float valorDiaria;

    public void setValorDiaria(float valorDiaria) {
        this.valorDiaria = valorDiaria;
    }
    public String getModelo() {
        return modelo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public float getValorDiaria() {
        return valorDiaria;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public int getCodigo() {
        return codigo;
    }
}
