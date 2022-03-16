package org.exemple;

import org.exemple.model.Cliente;
import org.exemple.util.ArraySequencial;
import org.exemple.util.TypeAccont;
import org.exemple.util.TypePerson;

import java.util.Objects;
import java.util.Scanner;

public class Lab {

    public static void main(String[] args){
        Scanner leitor = new Scanner(System.in);
        ArraySequencial<Cliente> sequencial = new ArraySequencial<>();
        Cliente cliente = new Cliente();

        boolean on = true;

        while (on) {



            int escolha;

            System.out.println("--------------------------------------");
            System.out.println("[1] - Abrir uma conta");
            System.out.println("[2] - Consultar dados");
            System.out.println("[3] - Deletar conta");
            System.out.println("[4] - Atualizar conta");
            System.out.println("[5] - turn off");
            System.out.println("------------------------------------");
            escolha = leitor.nextInt();


            switch (escolha) {

                case 1:

                    String tipoPessoa;
                    String tipoConta;

                    System.out.println("Insira o nome: ");
                    cliente.setNome(leitor.next());
                    System.out.println("Insira o cpf: ");
                    cliente.setCpf(leitor.next());
                    System.out.println("Insira seu telefone: ");
                    cliente.setTelefone(leitor.next());

                    System.out.println("Deseja abrir uma conta como pessoa fisica ? ");
                    tipoPessoa = leitor.next();

                    if (Objects.equals(tipoPessoa, "sim")){
                        cliente.setPerson(TypePerson.PESSOA_FISICA);
                    }
                    else{
                        cliente.setPerson(TypePerson.PESSOA_JURIDICA);
                    }

                    System.out.println("Deseja abrir uma conta corrente ?");
                    tipoConta = leitor.next();

                    if (Objects.equals(tipoConta, "sim")){
                        cliente.setAccont(TypeAccont.CONTA_CORRENTE);
                    }
                    else {
                        cliente.setAccont(TypeAccont.CONTA_POUPACA);

                    }

                    sequencial.insere(cliente);

                    break;
                case 2:

                try {
                    System.out.println("qual cliente você deseja consultar: ");
                    int pos = leitor.nextInt();

                    cliente = sequencial.elementAt(pos);

                    System.out.println("Nome: " + cliente.getNome());
                    System.out.println("CPF: " + cliente.getCpf());
                    System.out.println("Telefone: " + cliente.getTelefone());
                    System.out.println("Tipo de pessoa: " + cliente.getPerson());
                    System.out.println("Tipo de conta: " + cliente.getAccont());
                }
                catch (ArrayIndexOutOfBoundsException e){
                    System.err.println("usuario vazio");
                }
                    break;

                case 3:
                    System.out.println("Insira a posição do cliente que deseja deletar: ");
                    int alvo = leitor.nextInt();

                    sequencial.removeElement(alvo);

                    System.out.println("deletado com sucesso");


                    break;

                case 4:

                    String nome, cpf, telefone, pessoa, conta;

                    System.out.println("qual cliente você deseja atualizar: ");
                    int pos1 = leitor.nextInt();

                    System.out.println("Deseja alterar o nome ? ");
                    nome = leitor.next();

                    System.out.println("Deseja alterar o cpf ? ");
                    cpf = leitor.next();

                    System.out.println("Deseja alterar o telefone ? ");
                    telefone = leitor.next();

                    System.out.println("Deseja alterar o tipo pessoa ? ");
                    pessoa = leitor.next();

                    System.out.println("Deseja alterar o tipo conta ? ");
                    conta = leitor.next();

                    if (Objects.equals(nome, "sim")){
                        String novoNome;

                        System.out.println("Insira o novo nome");
                        novoNome = leitor.next();

                        cliente.setNome(novoNome);
                    }
                    if (Objects.equals(cpf, "sim")){
                        String novoCpf;

                        System.out.println("Insira o novo cpf");
                        novoCpf = leitor.next();

                        cliente.setCpf(novoCpf);
                    }
                    if (Objects.equals(telefone, "sim")){
                        String novoTelefone;

                        System.out.println("Insira o novo telefone");
                        novoTelefone = leitor.next();

                        cliente.setTelefone(novoTelefone);
                    }
                    if (Objects.equals(pessoa, "sim")){

                        System.out.println("Deseja mudar para pessoa juridica ? ");
                        String escolhaPessoa = leitor.next();

                        if (Objects.equals(escolhaPessoa, "sim")){
                            cliente.setPerson(TypePerson.PESSOA_JURIDICA);
                        }
                        else {
                            cliente.setPerson(TypePerson.PESSOA_FISICA);
                        }
                    }
                    if (Objects.equals(conta, "sim")){
                        System.out.println("Deseja mudar para conta corrente ? ");
                        String escolhaPessoa = leitor.next();

                        if (Objects.equals(escolhaPessoa, "sim")){
                            cliente.setAccont(TypeAccont.CONTA_CORRENTE);
                        }
                        else {
                            cliente.setAccont(TypeAccont.CONTA_POUPACA);
                        }
                    }

                    sequencial.atualizar(cliente, pos1);

                    break;

                case 5:
                    on = false;
                    break;
            }
        }


    }

}
