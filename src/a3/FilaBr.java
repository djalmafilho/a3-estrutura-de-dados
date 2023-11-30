package a3;

import java.util.ArrayList;

public class FilaBr {

    private String ID;
    private FilaBr nextFila = null;
    private NodeNome front/* , rear */;
    private int length;

    public FilaBr(String ID) {
        this.ID = ID;
        front = null;
        length = 0;
    }

    public int getLength() {
        return length;
    }

    public String getID() {
        return ID;
    }

    public void criaFila(String ID) {
        if (nextFila == null)
            nextFila = new FilaBr(ID);
        else
            nextFila.criaFila(ID);
    }

    public FilaBr getNextFila() {
        return nextFila;
    }

    public void incluiFinal(String elem) {
        System.out.print(" fim ");
        NodeNome novo = new NodeNome();
        novo.setInfo(elem);
        NodeNome aux = front;
        if (front == null) {
            front = novo;
            length++;
            System.out.println(elem + " " + ID + " " + length + " ");
            return;
        }
        do {
            if (aux.getNext() == null) {
                aux.setNext(novo);
                length++;
                System.out.println(elem + " " + ID + " " + length + " ");
                return;
            }
            aux = aux.getNext();
        } while (aux != null);
    }

    public void incluiMeio(NodeNome amigo, String elem) {
        System.out.print(" meio ");
        if (amigo.getNext() != null) {
            NodeNome mane = amigo.getNext();
            NodeNome malandro = new NodeNome(elem);
            malandro.setNext(amigo.getNext());
            mane.setPrev(malandro);
            amigo.setNext(malandro);
            malandro.setPrev(amigo);
            length++;
            System.out.println(elem + " " + ID + " " + length + " ");
        } else {
            NodeNome malandro = new NodeNome(elem);
            amigo.setNext(malandro);
            malandro.setPrev(amigo);
            length++;
        }

    }

    public NodeNome busca(String nome) {
        NodeNome aux = front;
        do {
            String termo = aux.getInfo();
            if (termo.equals(nome)) {
                return aux;
            }
            aux = aux.getNext();
        } while (aux != null);
        return null;
    }

    public void desiste(NodeNome desiste) {
        if (desiste.getPrev() == null) {
            front = null;
            length--;
            return;
        } else {

            if (desiste.getNext() != null) {
                NodeNome prev = desiste.getPrev();
                prev.setNext(null);
                length--;
            } else {
                NodeNome prev = desiste.getPrev();
                NodeNome next = desiste.getNext();
                prev.setNext(next);
                next.setPrev(prev);
                length--;
            }
        }

    }

    public void atendeFila() {
        NodeNome aux = front;
        if (aux.getNext() == null) {
            return;
        } else {
            front = front.getNext();
            length--;
        }

    }

    public int posicaoAmigo(ArrayList<String> amigos) {
        if (front == null)
            return -1;
        int posicaoAmigo = this.length;
        NodeNome pessoaFila = this.front;
        do {
            for (int i = 0; i < amigos.size(); i++) {
                if (pessoaFila.getInfo().equals(amigos.get(i))) {
                    posicaoAmigo = i;
                }

            }
            pessoaFila = pessoaFila.getNext();
        } while (pessoaFila != null);

        return posicaoAmigo +1;
    }

    public NodeNome melhorAmigo(ArrayList<String> amigos) {
        NodeNome amigo = null;
        NodeNome pessoaFila = this.front;
        do {
            for (int i = 0; i < amigos.size(); i++) {
                if (pessoaFila.getInfo().equals(amigos.get(i))) {
                    amigo = pessoaFila;
                }

            }
            pessoaFila = pessoaFila.getNext();
        } while (pessoaFila != null);

        return amigo;
    }

    public void imprime() {
        NodeNome current = this.front;
        System.out.print("#" + ID + " [ ");
        while (current != null) {
            System.out.print(current.getInfo() + ", ");
            current = current.getNext();
        }
        System.out.println(" ]");
    }

}
