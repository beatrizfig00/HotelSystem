package com.example.projetohotel2.Dados;
import com.example.projetohotel2.Negocio.Reserva;

import java.util.ArrayList;

public class RepositorioReserva {
    private ArrayList<Reserva> reservas;

    public RepositorioReserva() {
        this.reservas = new ArrayList<>();
    }

    public void adicionarReserva(Reserva reserva) {
        reservas.add(reserva);
    }

    public ArrayList<Reserva> getAllReserva() {
        return reservas;
    }

    public void removerReserva(int id) {
        reservas.removeIf(reserva -> reserva.getId() == id);
    }

    public Reserva getReservaPorId(int id) {
        for (Reserva reserva : reservas) {
            if (reserva.getId() == id) {
                return reserva;
            }
        }
        return null;
    }
}
