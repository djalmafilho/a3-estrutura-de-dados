package a3;

public class NodeNome {
    private NodeNome prev;
    private NodeNome next;
    private String info;
    

    public NodeNome() {
        this.info = null;
        this.next = null;
        this.prev = null;
    }

    public NodeNome(String info) {
        this.info = info;
        next = null;
        prev = null;
    }

    public void setInfo(String grupo) {
        this.info = grupo;
    }

    public String getInfo() {
        return info;
    }

    public NodeNome getNext() {
        return next;
    }

    public void setNext(NodeNome node) {
        this.next = node;
    }

    public NodeNome getPrev() {
        return prev;
    }

    public void setPrev(NodeNome prev) {
        this.prev = prev;
    }

}

