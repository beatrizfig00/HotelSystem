package com.example.projetohotel2;

import com.example.projetohotel2.Dados.RepositorioHospede;
import com.example.projetohotel2.Negocio.Hospede;
import com.example.projetohotel2.Exception.HospedeNaoExisteException;
import com.example.projetohotel2.Dados.RepositorioReserva;
import com.example.projetohotel2.Exception.ReservaNaoExisteException;
import com.example.projetohotel2.Negocio.Quarto;
import com.example.projetohotel2.Negocio.Reserva;
import com.example.projetohotel2.Negocio.Pagamento;
import com.example.projetohotel2.Dados.RepositorioPagamento;
import com.example.projetohotel2.Dados.RepositorioAdministrador;
import com.example.projetohotel2.Negocio.Administrador;

import java.util.ArrayList;

public class HotelFachada {
    private RepositorioHospede repositorioHospede;
    private RepositorioAdministrador repositorioAdministrador;
    private RepositorioReserva repositorioReserva;
    private static HotelFachada instance;
    private ArrayList<Quarto> quartosDisponiveis;
    private RepositorioPagamento repositorioPagamento;

    private HotelFachada() {
        this.repositorioHospede = new RepositorioHospede();
        this.repositorioAdministrador = new RepositorioAdministrador();
        this.repositorioReserva = new RepositorioReserva();
        this.quartosDisponiveis = new ArrayList<>();
        this.repositorioPagamento = new RepositorioPagamento();
    }

    public static HotelFachada getInstance() {
        if (instance == null) {
            instance = new HotelFachada();
        }
        return instance;
    }

    //hóspedes
    public void cadastrarHospede(Hospede hospede) {
        this.repositorioHospede.adicionarHospede(hospede);
    }

    public void removerHospede(int id) {
        this.repositorioHospede.removerHospede(id);
    }

    public Hospede buscarHospedePorLogin(String login) {
        for (Hospede hospede : listarHospedes()) {
            if (hospede.getLogin().equals(login)) {
                return hospede;
            }
        }
        return null;
    }

    public ArrayList<Hospede> listarHospedes() {
        return this.repositorioHospede.getAllHospede();
    }

    //administradores
    public void cadastrarAdministrador(Administrador administrador) {
        this.repositorioAdministrador.adicionarAdministrador(administrador);
    }

    public void removerAdministrador(int id) {
        this.repositorioAdministrador.removerAdministrador(id);
    }

    public Administrador buscarAdministradorPorLogin(String login) {
        for (Administrador admin : listarAdministradores()) {
            if (admin.getLogin().equals(login)) {
                return admin;
            }
        }
        return null;
    }

    public ArrayList<Administrador> listarAdministradores() {
        return this.repositorioAdministrador.getAllAdministradores();
    }

    // reservas
    public void fazerReserva(Reserva reserva) {
        this.repositorioReserva.adicionarReserva(reserva);
    }

    public void cancelarReserva(int id) throws ReservaNaoExisteException {
        if (this.repositorioReserva.getReservaPorId(id) != null) {
            this.repositorioReserva.removerReserva(id);
        } else {
            throw new ReservaNaoExisteException("Reserva com ID " + id + " não encontrada.");
        }
    }

    public ArrayList<Reserva> listarReservas() {
        return this.repositorioReserva.getAllReserva();
    }

    //quartos
    public boolean verificarDisponibilidadeQuarto(Quarto quarto) {
        return quarto.getStatusDisponibilidade();
    }

    public void reservarQuarto(Quarto quarto, Hospede hospede) {
        quarto.reservar(hospede);
    }

    public ArrayList<Quarto> listarQuartosDisponiveis() {
        return this.quartosDisponiveis;
    }

    //pagamentos
    public void registrarPagamento(Pagamento pagamento) {
        repositorioPagamento.adicionarPagamento(pagamento);
    }

    public ArrayList<Pagamento> listarPagamentos() {
        return repositorioPagamento.getAllPagamentos();
    }
}
