package com.example.projetohotel2.Negocio;

public class Pagamento {
    private int idPagamento;
    private int idHospede;
    private double valor;
    private String metodoPagamento;
    private boolean pago;

    public Pagamento(int idPagamento, int idHospede, double valor, String metodoPagamento, boolean pago) {
        this.idPagamento = idPagamento;
        this.idHospede = idHospede;
        this.valor = valor;
        this.metodoPagamento = metodoPagamento;
        this.pago = pago;
    }
    public int getIdPagamento() {

        return idPagamento;
    }
    public int getIdHospede() {

        return idHospede;
    }
    public double getValor() {

        return valor;
    }
    public String getMetodoPagamento() {

        return metodoPagamento;
    }
    public boolean getPago() {

        return pago;
    }
    public void setIdPagamento(int idPagamento) {

        this.idPagamento = idPagamento;
    }
    public void setIdHospede(int idHospede) {

        this.idHospede = idHospede;
    }
    public void setValor(double valor) {

        this.valor = valor;
    }
    public void setMetodoPagamento(String metodoPagamento) {

        this.metodoPagamento = metodoPagamento;
    }
    public void setPago(boolean pago) {

        this.pago = pago;
    }
}