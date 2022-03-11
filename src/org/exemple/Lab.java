package org.exemple;

import org.exemple.model.Cliente;
import org.exemple.util.ArraySequencial;
import org.exemple.util.TypeAccont;
import org.exemple.util.TypePerson;

import java.util.Objects;
import java.util.Scanner;

public class Lab {

    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        ArraySequencial<Cliente> sequencial = new ArraySequencial<Cliente>();
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

                    System.out.println(sequencial.getSize());

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
                        sequencial.insere(cliente);
                    }
                    else {
                        cliente.setAccont(TypeAccont.CONTA_POUPACA);
                        sequencial.insere(cliente);
                    }


                    break;
                case 2:

                    System.out.println("qual cliente você deseja consultar: ");
                    int pos = leitor.nextInt();

                   Cliente cliente1 = sequencial.elementAt(pos);

                    System.out.println("Nome: " + cliente1.getNome());
                    System.out.println("CPF: " + cliente1.getCpf());
                    System.out.println("Telefone: " + cliente1.getTelefone());
                    System.out.println("Tipo de pessoa: " + cliente1.getPerson());
                    System.out.println("Tipo de conta: " + cliente1.getAccont());

                    break;

                case 3:



                    break;

                case 4:
                    System.out.println("qual cliente você deseja atualizar: ");
                    int pos1 = leitor.nextInt();



                    break;

                case 5:
                    on = false;
                    break;
            }
        }


    }

}
