package com.example.projetohotel2.Negocio;

import java.util.HashMap;
import java.util.Map;
public class Quarto {
    private String tipoQuarto;
    private int numeroQuarto;
    private boolean statusDisponibilidade;
    private double precoTipo1;
    private double precoTipo2;
    private double precoTipo3;
    private double precoTipo4;
    private static Map<String, Integer> tipoDeQuartosDisponiveis = new HashMap<>();

    public Quarto (int numeroQuarto, String tipoQuarto, boolean statusDisponibilidade, double preco) {
        this.tipoQuarto = tipoQuarto;
        this.numeroQuarto = numeroQuarto;
        this.statusDisponibilidade = statusDisponibilidade;

        if (tipoQuarto.equals("Tipo1")) {
            this.precoTipo1 = 75.0;
        } else if (tipoQuarto.equals("Tipo2")) {
            this.precoTipo2 = 125.0;
        } else if (tipoQuarto.equals("Tipo3")) {
            this.precoTipo3 = 200.0;
        } else if (tipoQuarto.equals("Tipo4")) {
            this.precoTipo4 = 300.0;
        }
    }
    public static void preencherQuartosDisponiveis() {
        tipoDeQuartosDisponiveis.put("Tipo1", 20);
        tipoDeQuartosDisponiveis.put("Tipo2", 20);
        tipoDeQuartosDisponiveis.put("Tipo3", 20);
        tipoDeQuartosDisponiveis.put("Tipo4", 20);
    }

    public static boolean verificarDisponibilidadeQuarto(String tipoQuarto) {
        // Verifique se há quartos disponíveis do tipo especificado
        return tipoDeQuartosDisponiveis.getOrDefault(tipoQuarto, 0) > 0;
    }

    public static void reservarQuarto(String tipoQuarto) {
        int quantidadeAtual = tipoDeQuartosDisponiveis.getOrDefault(tipoQuarto, 0);
        if (quantidadeAtual > 0) {
            tipoDeQuartosDisponiveis.put(tipoQuarto, quantidadeAtual - 1);
        }
    }

    public String getTipoQuarto() {

        return tipoQuarto;
    }

    public void setTipoQuarto(String tipoQuarto) {

        this.tipoQuarto = tipoQuarto;
    }

    public int getNumeroQuarto() {

        return numeroQuarto;
    }

    public void setNumeroQuarto(int numeroQuarto) {

        this.numeroQuarto = numeroQuarto;
    }

    public boolean getStatusDisponibilidade() {

        return statusDisponibilidade;
    }

    public void setStatusDisponibilidade(boolean statusDisponibilidade) {
        this.statusDisponibilidade = statusDisponibilidade;
    }

    public void reservar(Hospede hospede) {
        if (statusDisponibilidade) {
            System.out.println("Reserva realizada para o quarto " + numeroQuarto + " pelo hóspede " + hospede.getNome());
            statusDisponibilidade = false;
            reservarQuarto(tipoQuarto);
        } else {
            System.out.println("Quarto já está ocupado!");
        }
    }

    public void realizarCheckOut() {
        if (!statusDisponibilidade) {
            System.out.println("CheckOut realizado para o quarto " + numeroQuarto);
            statusDisponibilidade = true;
        } else {
            System.out.println("Quarto não está ocupado!");
        }
    }
    public double calcularValorTotalReserva(int numeroDias) {
        double valorTotal = 0.0;

        if (tipoQuarto.equals("Tipo1")) {
            valorTotal = numeroDias * precoTipo1;
        } else if (tipoQuarto.equals("Tipo2")) {
            valorTotal = numeroDias * precoTipo2;
        } else if (tipoQuarto.equals("Tipo3")) {
            valorTotal = numeroDias * precoTipo3;
        } else if (tipoQuarto.equals("Tipo4")) {
            valorTotal = numeroDias * precoTipo4;
        }
        return valorTotal;
    }

    @Override
    public String toString() {
        return "Quarto{" +
                "tipoQuarto='" + tipoQuarto + '\'' +
                ", numeroQuarto=" + numeroQuarto +
                ", statusDisponibilidade=" + statusDisponibilidade +
                '}';
    }
}