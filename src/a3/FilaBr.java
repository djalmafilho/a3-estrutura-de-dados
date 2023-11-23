package a3;

public class FilaBr {

    private NodeNome front, rear;
    private int length;

    public FilaBr() {
        front = rear = null;
        length = 0;
    }

    public void incluiFinal(String elem) {
        NodeNome aux = new NodeNome();
        aux.setInfo(elem);
        aux.setNext(null);
        aux.setPrev(null);
        if (front == null) {
            rear = front = aux;
            length = 1;
        } else {
            rear.setNext(aux);
            aux.setPrev(rear);
            rear = aux;
            length++;
        }
    }
    public void incluiMeio( NodeNome amigo, String elem){
        NodeNome mane = amigo.getNext();
        NodeNome malandro = new NodeNome(elem);
        malandro.setNext(amigo.getNext());
        mane.setPrev(malandro);
        amigo.setNext(malandro);
        malandro.setPrev(amigo);
        length++;
    
}
    public NodeNome busca(String nome){
        NodeNome aux =  front;
        while(aux.getNext()!=null){
            String termo = aux.getInfo();
            if (termo.equals(nome)){
                return aux;
            }
            aux=aux.getNext();
        }
    return null;
    }
    
    public void desiste(NodeNome desiste){
        NodeNome prev = desiste.getPrev();
        NodeNome next = desiste.getNext();
        prev.setNext(next);
        next.setPrev(prev);
        length--;
    }
    
    public void atendeFila(){
        NodeNome aux = rear.getNext();
        front=rear= aux;
        length--;
    }
    
}
