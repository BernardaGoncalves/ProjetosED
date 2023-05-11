import helpers.ICService;
import models.IdentityCard;

import java.util.Scanner;

import static java.lang.System.exit;
import static java.lang.System.out;

public class Main {
    static boolean _isTopped = false;
    static Scanner _console = new Scanner(System.in);

    public static void main(String[] args) {
        out.println("\nIdentification Card Management System\n");

        while (!_isTopped) menu();

        out.println("See you soon...");
        exit(200);
    }

    private static void menu() {
        out.println("1 - Add Identification Card");
        out.println("2 - Add Special Identification Card");
        out.println("3 - Check Identification Card");
        out.println("4 - Cancel Identification Card");
        out.println("5 - Remove Identification Card");
        out.println("6 - Remove Old Identification Cards");
        out.println("7 - List Identification Cards");
        out.println("8 - Exit");
        out.print("> ");

        int option = _console.nextInt();
        _console.nextLine();

        switch (option) {
            case 1 -> addCard(false);
            case 2 -> addCard(true);
            case 3 -> checkCard();
            case 4 -> cancelCard();
            case 5 -> removeCard();
            case 6 -> removeOldCard();
            case 7 -> listCards();
            case 8 -> _isTopped = true;
        }

        out.println("\nPress <ENTER> to continue...\n");
        _console.nextLine();
    }

    private static void addCard(boolean special) {
        var card = new IdentityCard(special);

        out.print("\nInsert your full name: ");
        card.setName(_console.nextLine());

        ICService.add(card, special);

        out.println("\nCard added.");
        out.println(card);
    }

    private static void checkCard() {
        out.print("\nInsert identification card's ID: ");
        long cid = _console.nextLong();

        var card = ICService.find(cid);

        if(card == null) {
            out.println("Identification card not found.");
            return;
        }

        out.println();
        out.println(card);
    }

    private static void cancelCard() {
        out.print("\nInsert identification card's ID: ");
        long cid = _console.nextLong();

        if(ICService.cancel(cid)) {
            out.println("Identification card canceled.");
            return;
        }

        out.println("Identification card wasn't found.");
    }

    private static void removeCard() {
        out.print("\nInsert Identification Card's ID: ");
        long cid = _console.nextLong();

        if(ICService.remove(cid)) {
            out.println("Identification card removed.");
            return;
        }

        out.println("Identification card wasn't found.");
    }

    private static void removeOldCard() {
        out.print("\nInsert a minute: ");
        int minute = _console.nextInt();

        ICService.removeOld(minute);

        out.println("Old identification cards removed.");
    }

    private static void listCards() {
        out.printf("%nIdentification cards found (%d)%n%n", ICService.count());
        out.println(ICService.view());
    }
}