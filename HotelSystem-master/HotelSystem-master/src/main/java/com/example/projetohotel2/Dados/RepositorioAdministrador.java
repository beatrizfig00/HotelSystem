package com.example.projetohotel2.Dados;

import com.example.projetohotel2.Negocio.Administrador;

import java.io.*;
import java.util.ArrayList;

public class RepositorioAdministrador {
    private ArrayList<Administrador> administradores;
    private final String arquivoCSV = "administradores.csv";

    public RepositorioAdministrador() {
        this.administradores = new ArrayList<>();
    }

    public void adicionarAdministrador(Administrador administrador) {
        administradores.add(administrador);
    }

    public ArrayList<Administrador> getAllAdministradores() {
        return administradores;
    }

    public void removerAdministrador(int id) {
        administradores.removeIf(administrador -> administrador.getId() == id);
    }

    public Administrador getAdministradorPorId(int id) {
        for (Administrador administrador : administradores) {
            if (administrador.getId() == id) {
                return administrador;
            }
        }
        return null;
    }

    public void salvarAdministradores() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(arquivoCSV, true))) {
            for (Administrador administrador : administradores) {
                writer.println(organizarLinhas(administrador));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void carregarAdministradores() {
        administradores.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(arquivoCSV))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                administradores.add(criarAdministrador(linha));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String organizarLinhas(Administrador administrador) {
        return String.format("%s,%s,%s,%d,%s,%s,%d,%s,%s",
                administrador.getNome(), administrador.getSobrenome(), administrador.getCpf(), administrador.getId(),
                administrador.getLogin(), administrador.getSenha(), administrador.getIdade(), administrador.getContato(),
                administrador.getEmail());
    }

    private static Administrador criarAdministrador(String linha) {
        String[] atributos = linha.split(",");
        return new Administrador(
                atributos[0], atributos[1], atributos[2], Integer.parseInt(atributos[3]),
                atributos[4], atributos[5], Integer.parseInt(atributos[6]), atributos[7],
                atributos[8], atributos[9]
        );
    }
}
