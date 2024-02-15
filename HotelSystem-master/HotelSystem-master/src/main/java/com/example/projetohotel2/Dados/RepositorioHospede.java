package com.example.projetohotel2.Dados;
import com.example.projetohotel2.Negocio.Hospede;

import java.util.ArrayList;
import java.io.*;

public class RepositorioHospede {
    private ArrayList<Hospede> hospedes;
    private final String arquivoCSV = "hospedes.csv";

    public RepositorioHospede() {
        this.hospedes = new ArrayList<>();
    }

    public void adicionarHospede(Hospede hospede) {
        hospedes.add(hospede);
    }

    public ArrayList<Hospede> getAllHospede() {
        return hospedes;
    }

    public void removerHospede(int id) {
        hospedes.removeIf(hospede -> hospede.getId() == id);
    }

    public Hospede getHospedePorId(int id) {
        for (Hospede hospede : hospedes) {
            if (hospede.getId() == id) {
                return hospede;
            }
        }
        return null;
    }

    public void salvarHospedes() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(arquivoCSV, true))) {
            for (Hospede hospede : hospedes) {
                writer.println(organizarLinhas(hospede));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void carregarHospedes() {
        hospedes.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(arquivoCSV))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                hospedes.add(criarHospede(linha));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static String organizarLinhas(Hospede hospede) {
        return String.format("%s,%s,%s,%d,%s,%s,%d,%s,%s,%s",
                hospede.getNome(), hospede.getSobrenome(), hospede.getCpf(), hospede.getId(),
                hospede.getLogin(), hospede.getSenha(), hospede.getIdade(), hospede.getContato(),
                hospede.getEmail(), hospede.getEndereco());
    }
    private static Hospede criarHospede(String linha) {
        String[] atributos = linha.split(",");
        return new Hospede(
                atributos[0], atributos[1], atributos[2], Integer.parseInt(atributos[3]),
                atributos[4], atributos[5], Integer.parseInt(atributos[6]), atributos[7],
                atributos[8], atributos[9]
        );
    }
}