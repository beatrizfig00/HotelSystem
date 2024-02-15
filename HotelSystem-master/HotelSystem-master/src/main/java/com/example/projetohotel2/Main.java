package com.example.projetohotel2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;


import com.example.projetohotel2.Negocio.Quarto;
import com.example.projetohotel2.Negocio.Hospede;
import com.example.projetohotel2.Negocio.Pagamento;
import com.example.projetohotel2.Negocio.Reserva;
import com.example.projetohotel2.Dados.RepositorioReserva;

public class Main {

    public static void main(String[] args) {
        Quarto quarto1 = new Quarto(10,"Tipo2",true,300);

        try {
            Date checkIn1 = new SimpleDateFormat("dd/MM/yyyy").parse("01/02/2024");
            Date checkOut1 = new SimpleDateFormat("dd/MM/yyyy").parse("10/02/2024");
            Hospede hospede1 = new Hospede("João", "Silva", "0345129875205", 45456, "joaosilva", "senhajoao",20, "(81)94000233655", "joaosilva@gmail.com", "Rua A, 12");

            Pagamento pagamento1 = new Pagamento(123,45456,500,"pix",true);

            Reserva reserva1 = new Reserva(checkIn1, checkOut1, hospede1, quarto1, 500, 1, pagamento1);

            RepositorioReserva repositorio = new RepositorioReserva();

            repositorio.adicionarReserva(reserva1);
            reserva1.fazerReserva();
            reserva1.cancelarReserva();
            reserva1.exibirDetalhesReserva();

            ArrayList<Reserva> todasAsReservas = repositorio.getAllReserva();
            System.out.println("Todas as reservas:");
            for (Reserva reserva : todasAsReservas) {
                System.out.println("ID: " + reserva.getId() + ", Quarto: " + reserva.getQuartoReservado().getNumeroQuarto());
            }

            repositorio.removerReserva(1);
            System.out.println("Reserva removida.");

            todasAsReservas = repositorio.getAllReserva();
            System.out.println("Todas as reservas após a remoção:");
            for (Reserva reserva : todasAsReservas) {
                System.out.println("ID: " + reserva.getId() + ", Quarto: " + reserva.getQuartoReservado().getNumeroQuarto());
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}