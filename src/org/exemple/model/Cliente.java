package org.exemple.model;

import org.exemple.util.TypeAccont;
import org.exemple.util.TypePerson;

public class Cliente {

    private String nome;
    private String cpf;
    private String telefone;
    private TypeAccont accont;
    private TypePerson person;


    public Cliente (){}

    public Cliente (String nome, TypeAccont accont, String cpf, String telefone, TypePerson person){
        this.accont = accont;
        this.nome = nome;
        this.cpf = cpf;
        this.person = person;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TypeAccont getAccont() {
        return accont;
    }

    public void setAccont(TypeAccont accont) {
        this.accont = accont;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public TypePerson getPerson() {
        return person;
    }

    public void setPerson(TypePerson person) {
        this.person = person;
    }

}
