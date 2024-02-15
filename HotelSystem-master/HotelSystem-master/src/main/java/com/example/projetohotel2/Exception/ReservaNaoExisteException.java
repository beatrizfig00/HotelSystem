package com.example.projetohotel2.Exception;

public class ReservaNaoExisteException extends Exception {

    public ReservaNaoExisteException(String mensagem) {
        super(mensagem);
    }
}