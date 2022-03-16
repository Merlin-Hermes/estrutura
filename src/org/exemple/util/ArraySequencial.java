package org.exemple.util;

import org.exemple.model.Cliente;

public class ArraySequencial<T> {

    //Atributos da classe
    private final int tamanho = 50;
    private T[] array = null;
    private int posicaoAtual = 0;

    public ArraySequencial() {
        this.array = (T[]) new Object[tamanho];
    }


    public T elementAt(int posicao)throws ArrayIndexOutOfBoundsException{

        if (posicao >= posicaoAtual || posicao < 0) {
            throw new ArrayIndexOutOfBoundsException("Deu krepa");
        }

        return array[posicao];
    }

    public int getSize(){
        return posicaoAtual;
    }

    public T removeElement(int posicao) throws ArrayIndexOutOfBoundsException{

        if (posicao >= posicaoAtual || posicao < 0) {
            throw new ArrayIndexOutOfBoundsException("Deu krepa");
        }

        T copy = array[posicao];

        for (int posInicial = posicao; posInicial < posicaoAtual - 1; posInicial++) {
            array[posInicial] = array[posInicial + 1];
        }
        posicaoAtual--;
        return copy;
    }


    public void atualizar(T novo, int posicao)throws ArrayIndexOutOfBoundsException{

        if (posicao < 0 || posicao >= posicaoAtual) {
            throw new ArrayIndexOutOfBoundsException("Deu krepa");
        }

        if (posicaoAtual == array.length)
        {
            realocaMemoria();
        }
        for (int pos = posicaoAtual; pos > posicao; pos-- ) {
            array[pos] = array[pos - 1];
        }
        array[posicao]  = novo;
        posicaoAtual++;
    }

    public void insere(T novo)
    {
        if (posicaoAtual == array.length)
        {
            realocaMemoria();
        }
        array[posicaoAtual] = novo;
        posicaoAtual++;
    }

    private void realocaMemoria() {

        System.out.println("Realocando....");
        T[] novo = (T[]) new Object[array.length + tamanho];

        for (int posicao = 0; posicao < array.length; posicao++)
        {
            novo[posicao] = array[posicao];
        }

        array = novo;
    }
}
