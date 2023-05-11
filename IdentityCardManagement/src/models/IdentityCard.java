package models;

import helpers.Node;

import java.time.LocalDateTime;
import java.util.Random;

public class IdentityCard extends Node<IdentityCard> {
    private long id;
    private String name;
    private LocalDateTime created;

    private boolean isSpecial;
    private boolean isCanceled;

    public IdentityCard() {
        id = new Random().nextLong(1000);
        created = LocalDateTime.now();
        isCanceled = false;
    }

    public IdentityCard(boolean isSpecial) {
        id = new Random().nextLong(1000);
        created = LocalDateTime.now();
        isCanceled = false;
        this.isSpecial = isSpecial;
    }

    public IdentityCard(String name, boolean isSpecial) {
        id = new Random().nextLong(1000);
        created = LocalDateTime.now();

        this.name = name;
        this.isSpecial = isSpecial;
        this.isCanceled = false;
    }

    public boolean isCanceled() {
        return isCanceled;
    }

    public void setCanceled(boolean canceled) {
        isCanceled = canceled;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public boolean isSpecial() {
        return isSpecial;
    }

    public void setSpecial(boolean special) {
        isSpecial = special;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        var type = isSpecial ? "[SPECIAL]" : "[REGULAR]";
        return String.format("%s %d - %s", type, id, name);
    }
}
