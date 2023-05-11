package helpers;

import models.IdentityCard;

import java.util.Arrays;

public class ICService {
    private static final SimpleLinkedList<IdentityCard> _cards = new SimpleLinkedList<>();

    public static void add(IdentityCard card) {
        _cards.addLast(card);
    }

    public static IdentityCard find(long id) {
        var cards = _cards.getAll();
        return cards.stream().filter(card -> card.getId() == id).findFirst().orElse(null);
    }

    public static boolean remove(long id) {
        Node<IdentityCard> current = _cards.getFirst();
        Node<IdentityCard> previous = null;

        while (current != null) {
            if (current.getValue().getId() == id) {
                if (previous == null) {
                    _cards.removeFirst();
                } else {
                    previous.setNext(current.getNext());
                }

                return true;
            }

            previous = current;
            current = current.getNext();
        }

        return false;
    }

    public static void removeOld(int minute) {
        Node<IdentityCard> current = _cards.getFirst();
        Node<IdentityCard> previous = null;

        while (current != null) {
            if (current.getValue().getCreated().getMinute() < minute) {
                if (previous == null) {
                    _cards.removeFirst();
                    current = _cards.getFirst();
                } else {
                    previous.setNext(current.getNext());
                    current = previous.getNext();
                }
            } else {
                previous = current;
                current = current.getNext();
            }
        }
    }

    public static int count() {
        return _cards.size();
    }

    public static String view() {
        return _cards.toString();
    }

    public static boolean cancel(long id) {
        Node<IdentityCard> current = _cards.getFirst();

        for (var card : _cards.getAll()) {
            if(card.getId() == id) {
                card.setCanceled(false);
                current.setValue(card);

            }
        }

        return false;
    }
}