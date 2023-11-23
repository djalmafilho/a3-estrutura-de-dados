package a3;


public class NodeGrupos {
    private NodeGrupos next;
    private String [] info;
    
    public NodeGrupos(){
        this.info=null;
        this.next=null;
    }
    public NodeGrupos(String [] info) {
        this.info = info;
        next = null;
    }

    public void setInfo (String[] grupo){
        this.info = grupo;
    }
    public String [] getInfo() {
        return info;
    }
    
    public NodeGrupos getNext() {
        return next;
    }

    public void setNext(NodeGrupos node) {
        this.next = node;
    }

    
}


