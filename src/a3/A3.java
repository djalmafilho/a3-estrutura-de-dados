
package a3;

import java.io.File;

public class A3 {
    public static void main(String[] args) {
        File file = new File("input03.txt");
        Parser parser = new Parser(file);
        ListaGrupos ListaGrupos = new ListaGrupos();
        ADMFila admFila = new ADMFila();

        while (parser.hasNext()) {
            String line = parser.nextLine();
            String tokens[] = line.split(" ");
            String comando = tokens[0];
            switch (comando) {
                case "grupo:" -> {
                    String[] grupo = new String[tokens.length - 1];
                    for (int i = 1; i < tokens.length; i++) {
                        grupo[i - 1] = tokens[i];
                    }
                    ListaGrupos.incluiGrupo(grupo);
                }
                case "existe:" -> {
                    boolean busca = ListaGrupos.existe(tokens[1]);
                    if (busca == true) {
                        System.out.println("[" + tokens[1] + "] existe!\n");
                    } else {
                        System.out.println("[" + tokens[1] + "] nao existe!\n");
                    }
                }
                case "conhece:" -> {
                    int busca = ListaGrupos.conhece(tokens[1], tokens[2]);
                    if (busca == 1) {
                        System.out.println("[" + tokens[1] + "] conhece [" + tokens[2] + "]\n");
                    } else if (busca == 0) {
                        System.out.println("[" + tokens[1] + "] nao conhece [" + tokens[2] + "]\n");
                    } else {
                        System.out.println("Algum desses elementos nao existe.");
                    }
                }
                case "criaFila:" -> {
                    admFila.criaFila(tokens[1]);
                }
                case "atendeFila:" -> {
                    admFila.atendeFila(tokens[1]);
                }
                case "chegou:" -> {
                    for (int i = 1; i < tokens.length; i++) {
                            admFila.chegou(tokens[i], ListaGrupos);
                    }
                }
                case "desiste:" -> {
                    admFila.desiste(tokens[1]);
                }
                case "imprime:" -> {
                    admFila.imprime();
                }

                default -> {
                }
            }
        }
    }
}
