package helpers;

import models.IdentityCard;

public class ICService {
    private static final SimpleLinkedList<IdentityCard> _cards = new SimpleLinkedList<>();

    public static void add(IdentityCard card, boolean isSpecial) {
        if(isSpecial) {
            _cards.addFirst(card);
            return;
        }

        _cards.addLast(card);
    }

    public static IdentityCard find(long id) {
        return _cards.getAll().stream().filter(card -> card.getId() == id).findFirst().orElse(null);
    }

    public static boolean remove(long id) {
        IdentityCard current = _cards.getFirst();
        Node<IdentityCard> previous = null;

        for(int i = 0; i < _cards.size(); i++) {
            if (current.getId() == id) {
                if (previous == null) {
                    _cards.removeFirst();
                } else {
                    _cards.removeLast();
                }

                return true;
            }

            previous = current;
            current = _cards.getNext();
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
                _cards.addLast(card);

                remove(card.getId());
            }
        }

        return false;
    }
}