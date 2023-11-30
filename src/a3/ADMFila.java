package a3;

import java.util.ArrayList;
import java.util.Collections;

public class ADMFila {

    private FilaBr filaBr;

    public ADMFila() {
    }

    // checa se tem um ou mais amigos e insere na melhor fila
    public void chegou(String nome, ListaGrupos listaGrupos) {
        FilaBr current = filaBr;
        ArrayList<Integer> opcoes = new ArrayList<>();
        // encontra melhor posi;~ao dentro das filas
        try {
            ArrayList<String> conhecidos = listaGrupos.conhecidos(nome);
            do {
                int opcao = current.getLength();
                int posicao = current.posicaoAmigo(conhecidos);
                if (posicao < 0) {
                    current.incluiFinal(nome);
                    return;
                }
                else if(posicao<opcao){
                    opcao = posicao;
                }
                opcoes.add(opcao);
                current = current.getNextFila();
            } while (current != null);
            // resgata a melhor opcao para inserir
            int index = opcoes.indexOf(Collections.min(opcoes));
            current = this.filaBr;
            for (int i = 0; i < index; i++) {
                current = current.getNextFila();

            }
            // encotra qual o amigo em melhor posi;'ao na mesma fila'
            NodeNome melhorAmigo = current.melhorAmigo(conhecidos);
            
            if (melhorAmigo != null) {
                current.incluiMeio(melhorAmigo, nome);
                return;
            }
            current.incluiFinal(nome);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());

            FilaBr menorfila = this.filaBr;
            current = this.filaBr;
            do {
                menorfila = current.getLength() < menorfila.getLength() ? current : menorfila;
                current = current.getNextFila();
            } while (current != null);
            menorfila.incluiFinal(nome);

        }finally{
            this.imprime();
            System.out.println();
        }
    }

    public void criaFila(String ID) {
        if (filaBr == null)
            filaBr = new FilaBr(ID);
        else
            filaBr.criaFila(ID);
    }

    public void atendeFila(String ID) {
        FilaBr current = this.filaBr;
        do {
            if (current.getID().equals(ID)) {
                current.atendeFila();
            }
            current = current.getNextFila();
        } while (current != null);

    }

    public void desiste(String nome) {
        FilaBr current = this.filaBr;
        do {
            NodeNome desistente = current.busca(nome);
            if (desistente != null) {
                current.desiste(desistente);
            }
            current = current.getNextFila();
        } while (current != null);

    }

    public void imprime() {
        FilaBr current = this.filaBr;
        do {
            current.imprime();
            current = current.getNextFila();
        } while (current != null);
    }

}
