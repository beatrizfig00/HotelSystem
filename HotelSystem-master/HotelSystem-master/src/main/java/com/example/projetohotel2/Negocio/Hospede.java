package com.example.projetohotel2.Negocio;
import java.util.ArrayList;

public class Hospede {
    private String nome;
    private String sobrenome;
    private String cpf;
    private int id;
    private String login;
    private String senha;
    private int idade;
    private String contato;
    private String email;
    private String endereco;
    private ArrayList<Pagamento> pagamentos;

    public Hospede(String nome, String sobrenome, String cpf, int id, String login, String senha, int idade, String contato, String email, String endereco) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.id = id;
        this.login = login;
        this.senha = senha;
        this.idade = idade;
        this.contato = contato;
        this.email = email;
        this.endereco = endereco;
        this.pagamentos = new ArrayList<>();
    }

    public String getNome() {

        return nome;
    }

    public String getSobrenome() {

        return sobrenome;
    }

    public String getCpf() {

        return cpf;
    }

    public int getId() {

        return id;
    }

    public String getLogin() {

        return login;
    }

    public String getSenha() {

        return senha;
    }

    public int getIdade() {

        return idade;
    }

    public String getContato() {

        return contato;
    }

    public String getEmail() {

        return email;
    }

    public String getEndereco() {

        return endereco;
    }

    public void setNome(String nome) {

        this.nome = nome;
    }

    public void setSobrenome(String sobrenome) {

        this.sobrenome = sobrenome;
    }

    public void setCpf(String cpf) {

        this.cpf = cpf;
    }

    public void setId(int id) {

        this.id = id;
    }

    public void setLogin(String login) {

        this.login = login;
    }
    public void setSenha(String senha) {

        this.senha = senha;
    }

    public void setIdade(int idade) {

        this.idade = idade;
    }

    public void setContato(String contato) {

        this.contato = contato;
    }

    public void setEmail(String email) {

        this.email = email;
    }

    public void setEndereco(String endereco) {

        this.endereco = endereco;
    }
    public ArrayList<Pagamento> getPagamentos() {

        return pagamentos;
    }

    public void adicionarPagamento(Pagamento pagamento) {

        pagamentos.add(pagamento);
    }

    public boolean validarSenha(String senha) {
        return this.senha.equals(senha);
    }

}