package com.example.projetohotel2.Negocio;

import com.example.projetohotel2.Dados.RepositorioContaAtual;

public class ContaAtual {
    private String loginHospede;
    private double totalConta;

    public ContaAtual(String loginHospede) {
        this.loginHospede = loginHospede;
        this.totalConta = 0.0;
    }

    public String getLoginHospede() {
        return loginHospede;
    }

    public double getTotalConta() {
        return totalConta;
    }

    public void adicionarServico(Spa servico) {
        totalConta += servico.getPreco();
        String dados = loginHospede + ": " + servico.getNome() + " - R$ " + servico.getPreco();
        RepositorioContaAtual.salvarContaAtual(dados);
    }
}
