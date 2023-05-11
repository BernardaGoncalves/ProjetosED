package helpers;

public class Node <TObject> {
    private TObject value;
    private Node<TObject> next;

    public Node(TObject value) {
        this.value = value;
        this.next = null;
    }

    public Node() {
        this(null);
    }

    public Node(TObject value, Node<TObject> next) {
        this.value = value;
        this.next = next;
    }

    public TObject getValue() {
        return value;
    }

    public Node<TObject> getNext() {
        return next;
    }

    public void setValue(TObject value) {
        this.value = value;
    }

    public void setNext(Node<TObject> next) {
        this.next = next;
    }
}
