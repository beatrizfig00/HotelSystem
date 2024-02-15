package com.example.projetohotel2.Negocio;

public class Transacao {
    private String loginHospede;
    private String servico;
    private double preco;

    public Transacao(String loginHospede, String servico, double preco) {
        this.loginHospede = loginHospede;
        this.servico = servico;
        this.preco = preco;
    }

    public String getLoginHospede() {
        return loginHospede;
    }

    public String getServico() {
        return servico;
    }

    public double getPreco() {
        return preco;
    }
}
