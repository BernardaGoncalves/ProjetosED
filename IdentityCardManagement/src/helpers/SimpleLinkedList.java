package helpers;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SimpleLinkedList <TObject> {
    private Node<TObject> first;
    private int size;

    public SimpleLinkedList() {
        first = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public void addFirst(TObject tObject) {
        var newNode = new Node<>(tObject);

        newNode.setNext(first);
        first = newNode;
        size++;
    }

    public void addLast(TObject tObject) {
        var newNode = new Node<>(tObject, null);

        if (isEmpty()) {
            first = newNode;
        } else {
            Node<TObject> current = first;
            while (current.getNext() != null) {
                current = current.getNext();
            }

            current.setNext(newNode);
        }

        size++;
    }

    public TObject getFirst() {
        if (isEmpty()) return null;
        return first.getValue();
    }

    public List<TObject> getAll() {
        Node<TObject> current = first;
        List<TObject> cards = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            cards.add(current.getValue());

            if(current.getNext() == null) break;

            current = current.getNext();
        }

        return cards;
    }


    public TObject getNext() {
        Node<TObject> current = first;
        return current.getNext().getValue();
    }

    public TObject getLast() {
        if (isEmpty()) return null;

        Node<TObject> current = first;

        while (current.getNext() != null)
            current = current.getNext();

        return current.getValue();
    }

    public void removeFirst() {
        if (isEmpty()) {
            throw new IllegalStateException("Cannot remove from an empty list.");
        }

        first = first.getNext();
        size--;
    }

    public void removeLast() {
        if (isEmpty()) {
            throw new IllegalStateException("Cannot remove from an empty list.");
        }

        if (size == 1) {
            first = null;
        } else {
            Node<TObject> current = first;

            while (current.getNext().getNext() != null) {
                current = current.getNext();
            }

            current.setNext(null);
        }

        size--;
    }

    @Override
    public String toString() {
        var str = new StringBuilder();
        Node<TObject> current = first;

        while (current != null) {
            str.append(current.getValue().toString());

            current = current.getNext();

            if (current != null)
                str.append("\n");
        }

        return str.toString();
    }
}
