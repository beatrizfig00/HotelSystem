package com.example.projetohotel2.Dados;

import com.example.projetohotel2.Negocio.Transacao;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class RepositorioContaAtual {
    private static final String FILE_NAME = "conta_atual.txt";

    public static void salvarContaAtual(String dados) {
        try {
            FileWriter fileWriter = new FileWriter(FILE_NAME, true);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.println(dados);
            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void adicionarTransacao(Transacao transacao, String loginHospede, String nomeArquivo) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(nomeArquivo, true))) {
            writer.println(loginHospede + "," + transacao.getServico() + "," + transacao.getPreco());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
