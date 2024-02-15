package com.example.projetohotel2.Dados;
import com.example.projetohotel2.Negocio.Pagamento;

import java.util.ArrayList;
import java.io.*;

public class RepositorioPagamento {
    private ArrayList<Pagamento> pagamentos;
    private final String arquivoCSV = "pagamentos.csv";

    public RepositorioPagamento() {

        this.pagamentos = new ArrayList<>();
    }

    public void adicionarPagamento(Pagamento pagamento) {

        pagamentos.add(pagamento);
    }

    public ArrayList<Pagamento> getAllPagamentos() {

        return pagamentos;
    }

    public void removerPagamento(int idPagamento) {
        pagamentos.removeIf(pagamento -> pagamento.getIdPagamento() == idPagamento);
    }

    public Pagamento getPagamentoPorId(int idPagamento) {
        for (Pagamento pagamento : pagamentos) {
            if (pagamento.getIdPagamento() == idPagamento) {
                return pagamento;
            }
        }
        return null;
    }

    public void salvarPagamentos() {
        try (PrintWriter writer = new PrintWriter(new File(arquivoCSV))) {
            for (Pagamento pagamento : pagamentos) {
                writer.println(organizarLinhas(pagamento));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void carregarPagamentos() {
        pagamentos.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(arquivoCSV))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                pagamentos.add(criarPagamento(linha));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String organizarLinhas(Pagamento pagamento) {
        return String.format("%d,%d,%.2f,%s,%b",
                pagamento.getIdPagamento(), pagamento.getIdHospede(), pagamento.getValor(),
                pagamento.getMetodoPagamento(), pagamento.getPago());
    }

    private static Pagamento criarPagamento(String linha) {
        String[] atributos = linha.split(",");
        return new Pagamento(
                Integer.parseInt(atributos[0]), Integer.parseInt(atributos[1]), Double.parseDouble(atributos[2]),
                atributos[3], Boolean.parseBoolean(atributos[4])
        );
    }
}