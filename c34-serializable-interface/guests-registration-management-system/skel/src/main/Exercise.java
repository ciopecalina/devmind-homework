package main;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Exercise {
    private void showCommands() {
        System.out.println("help         - Afiseaza aceasta lista de comenzi");
        System.out.println("add          - Adauga o noua persoana (inscriere)");
        System.out.println("check        - Verifica daca o persoana este inscrisa la eveniment");
        System.out.println("remove       - Sterge o persoana existenta din lista");
        System.out.println("update       - Actualizeaza detaliile unei persoane");
        System.out.println("guests       - Lista de persoane care participa la eveniment");
        System.out.println("waitlist     - Persoanele din lista de asteptare");
        System.out.println("available    - Numarul de locuri libere");
        System.out.println("guests_no    - Numarul de persoane care participa la eveniment");
        System.out.println("waitlist_no  - Numarul de persoane din lista de asteptare");
        System.out.println("subscribe_no - Numarul total de persoane inscrise");
        System.out.println("search       - Cauta toti invitatii conform sirului de caractere introdus");
        System.out.println("save         - Salveaza lista cu invitati");
        System.out.println("restore      - Completeaza lista cu informatii salvate anterior");
        System.out.println("reset        - Sterge informatiile salvate despre invitati");
        System.out.println("quit         - Inchide aplicatia");
    }

    private void addNewGuest(Scanner sc, GuestsList list) {
        String lastName = sc.nextLine();
        String firstName = sc.nextLine();
        String email = sc.nextLine();
        String phoneNumber = sc.nextLine();
        list.add(new Guest(lastName, firstName, email, phoneNumber));
    }

    private void checkGuest(Scanner sc, GuestsList list) {
        int opt;
        while (true) {
            opt = sc.nextInt();
            sc.nextLine();

            if (opt < 1 || opt > 3) System.out.println("Va rugam introduceti un numar intreg, intre 1 si 3.");
            else break;
        }

        Guest foundGuest = null;

        switch (opt) {
            case 1 -> {
                String lastName = sc.nextLine();
                String firstName = sc.nextLine();
                foundGuest = list.search(firstName, lastName);
            }
            case 2, 3 -> {
                String match = sc.nextLine();
                foundGuest = list.search(opt, match);
            }
        }

        if (foundGuest == null) System.out.println("Not found");
        else System.out.println(foundGuest);
    }

    private void removeGuest(Scanner sc, GuestsList list) {
        int opt;
        while (true) {
            opt = sc.nextInt();
            sc.nextLine();

            if (opt < 1 || opt > 3) System.out.println("Va rugam introduceti un numar intreg, intre 1 si 3.");
            else break;
        }

        boolean removed = false;

        switch (opt) {
            case 1 -> {
                String lastName = sc.nextLine();
                String firstName = sc.nextLine();
                removed = list.remove(firstName, lastName);
            }
            case 2 -> {
                String email = sc.nextLine();
                removed = list.remove(opt, email);
            }
            case 3 -> {
                String phoneNumber = sc.nextLine();
                removed = list.remove(opt, phoneNumber);
            }
        }
    }

    private void updateGuest(Scanner sc, GuestsList list) {
        int opt;
        while (true) {
            opt = sc.nextInt();
            sc.nextLine();

            if (opt < 1 || opt > 3) System.out.println("Va rugam introduceti un numar intreg, intre 1 si 3.");
            else break;
        }

        Guest foundGuest = null;

        switch (opt) {
            case 1 -> {
                String lastName = sc.nextLine();

                String firstName = sc.nextLine();

                foundGuest = list.search(firstName, lastName);
            }
            case 2 -> {
                String email = sc.nextLine();
                foundGuest = list.search(opt, email);
            }
            case 3 -> {
                String phoneNumber = sc.nextLine();
                foundGuest = list.search(opt, phoneNumber);
            }
        }

        // If we have no results, exit
        if (foundGuest == null) {
            System.out.println("Eroare: Persoana nu este inscrisa la eveniment.");
            return;
        }

        while (true) {
            opt = sc.nextInt();
            sc.nextLine();

            if (opt < 1 || opt > 4) System.out.println("Va rugam introduceti un numar intreg, intre 1 si 4.");
            else break;
        }

        switch (opt) {
            case 1 -> {
                foundGuest.setLastName(sc.nextLine());
            }
            case 2 -> {
                foundGuest.setFirstName(sc.nextLine());
            }
            case 3 -> {
                foundGuest.setEmail(sc.nextLine());
            }
            case 4 -> {
                foundGuest.setPhoneNumber(sc.nextLine());
            }
        }
    }

    private void searchList(Scanner sc, GuestsList list) {
        String match = sc.nextLine();
        List<Guest> results = list.partialSearch(match);
        for (Guest g : results)
            System.out.println(g.toString());
        if (results.size() == 0)
            System.out.println("Nothing found");
    }

    // TO DO:
    private static void saveList(GuestsList list) throws IOException {
        list.writeToBinaryFile();

    }

    // TO DO:
    private static void restoreList(GuestsList list) throws IOException {
        list.readFromBinaryFile();
    }

    // TO DO:
    private static void resetList(GuestsList list) {
        list.resetList();
    }

    public void solve(Scanner scanner) throws IOException {
        int size = scanner.nextInt();
        scanner.nextLine();

        GuestsList list = new GuestsList(size);
        restoreList(list);

        boolean running = true;
        while (running) {

            String command = scanner.nextLine();

            switch (command) {
                case "help" -> showCommands();
                case "add" -> addNewGuest(scanner, list);
                case "check" -> checkGuest(scanner, list);
                case "remove" -> removeGuest(scanner, list);
                case "update" -> updateGuest(scanner, list);
                case "guests" -> list.showGuestsList();
                case "waitlist" -> list.showWaitingList();
                case "available" -> System.out.println("Numarul de locuri ramase: " + list.numberOfAvailableSpots());
                case "guests_no" -> System.out.println("Numarul de participanti: " + list.numberOfGuests());
                case "waitlist_no" ->
                        System.out.println("Dimensiunea listei de asteptare: " + list.numberOfPeopleWaiting());
                case "subscribe_no" -> System.out.println("Numarul total de persoane: " + list.numberOfPeopleTotal());
                case "search" -> searchList(scanner, list);
                case "quit" -> {

                    System.out.println("Aplicatia se inchide...");
                    saveList(list);
                    scanner.close();
                    running = false;
                }
                default -> {
                    System.out.println("Comanda introdusa nu este valida.");
                    System.out.println("Incercati inca o data.");
                    saveList(list);
                }
            }
        }
    }
}
