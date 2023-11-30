/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package a3;

import java.util.ArrayList;

/**
 *
 * @author gatra
 */
public class ListaGrupos {

    NodeGrupos lista;

    public ListaGrupos() {

    }

    public void incluiGrupo(String[] elem) {
        NodeGrupos aux = new NodeGrupos();
        aux.setInfo(elem);
        aux.setNext(lista);
        lista = aux;

    }

    public void imprimeGrupos() {
        NodeGrupos aux = this.lista;
        System.out.println("Grupos:\n");
        while (aux != null) {
            String[] grupo = aux.getInfo();
            System.out.print("[ ");
            for (int i = 0; i < grupo.length; i++) {
                System.out.print(grupo[i] + " ");
            }
            System.out.println("]");
            aux = aux.getNext();
        }
    }

    public boolean existe(String elemento) {
        NodeGrupos aux = this.lista;
        while (aux != null) {
            String[] grupo = aux.getInfo();
            for (int i = 0; i < grupo.length; i++) {
                if (grupo[i].equals(elemento)) {
                    return true;
                }
            }
            aux = aux.getNext();
        }
        return false;
    }

    public int conhece(String elemento1, String elemento2) {
        if (!existe(elemento1) || !existe(elemento2)) {
            return -1;
        }

        else {
            NodeGrupos aux = this.lista;
            while (aux != null) {
                String[] grupo = aux.getInfo();
                boolean elem1 = false;
                boolean elem2 = false;
                for (int i = 0; i < grupo.length; i++) {
                    if (grupo[i].equals(elemento1)) {
                        elem1 = true;
                    }
                    if (grupo[i].equals(elemento2)) {
                        elem2 = true;
                    }
                }
                if (elem1 == true && elem2 == true) {
                    return 1;
                }
                aux = aux.getNext();
            }
            return 0;
        }
    }

    public ArrayList<String> conhecidos(String nome) throws Exception {
        ArrayList<String> conhecidos = new ArrayList<>();
        if (!existe(nome)) {
            throw new IllegalArgumentException("Pessoa n~ao esta em nenhum grupo");
        }

        NodeGrupos aux = this.lista;
        while (aux != null) {
            String grupo[] = aux.getInfo();
            for (String str : grupo) {
                if (this.conhece(nome, str) == 1) {
                    conhecidos.add(str);
                }
            }
            aux = aux.getNext();
        }
        return conhecidos;
    }
}
