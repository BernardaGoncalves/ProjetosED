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
        boolean hasPrevious = false;
        IdentityCard current = _cards.getFirst();

        for (int i = 0; i < _cards.size(); i++) {
            if (current.getId() == id) {
                if (hasPrevious)  {
                    _cards.removeLast();
                } else {
                    _cards.removeFirst();
                }

                return true;
            }

            if (_cards.size() > 1) {
                current = _cards.getNext();
                hasPrevious = true;
            }
        }

        return false;
    }

    public static void removeOld(int minute) {
        for (var card : _cards.getAll()) {
            if(card.getCreated().getMinute() < minute) {
                remove(card.getId());
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
        for (var card : _cards.getAll()) {
            if(card.getId() == id) {
                if(remove(card.getId()))
                {
                    card.setCanceled(true);
                    _cards.addLast(card);
                    return true;
                }
            }
        }

        return false;
    }
}