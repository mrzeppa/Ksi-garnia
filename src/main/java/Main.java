import org.dom4j.DocumentException;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void menu(){
        System.out.println("" +
                "1 - dodaj ksiazke\n" +
                "2 - sortuj ksiazki\n" +
                "3 - edytuj ksiazke\n" +
                "4 - wyswietl ksiazki\n" +
                "5 - usun ksiazke");
    }

    public static void main(String[] args) throws DocumentException, IOException {
        BookCRUD bc = new BookCRUD();
        String autorId, ilosc, nazwaKsiazki, cena,
                currency, liczbaStron, wydawnictwo, rokWydania,
                bookId ;
        Scanner scanner = new Scanner(System.in);

        int a;
        boolean q = false;
        menu();
        while(!q){
            a = scanner.nextInt();
            scanner.nextLine();
            switch(a){
                case 1:
                    System.out.println("Nazwa ksiazki:");
                    nazwaKsiazki = scanner.next();
                    System.out.println("Ilosc:");
                    ilosc = scanner.next();
                    System.out.println("Id autora:");
                    autorId = scanner.next();
                    System.out.println("Wydawnictwo: ");
                    wydawnictwo = scanner.next();
                    System.out.println("Ilosc stron:");
                    liczbaStron = scanner.next();
                    System.out.println("Rok wydania:");
                    rokWydania = scanner.next();
                    System.out.println("Waluta:");
                    currency = scanner.next();
                    System.out.println("Cena");
                    cena = scanner.next();
                    bc.createBook(autorId,ilosc, nazwaKsiazki,cena,currency,liczbaStron,wydawnictwo,rokWydania);
                    System.out.println("DODANO");
                    menu();
                    break;
                case 2:
                    bc.sort();
                    menu();
                    break;
                case 3:
                    System.out.println("Podaj ID ksiazki:");
                    bookId = scanner.next();
                    System.out.println("Podaj nowa nazwe ksiazki:");
                    nazwaKsiazki = scanner.next();
                    bc.updateName(bookId, nazwaKsiazki);
                    menu();
                    break;
                case 4:
                    bc.read();
                    menu();
                    break;
                case 5:
                    System.out.println("Podaj ID ksiazki:");
                    bookId = scanner.next();
                    bc.delete(bookId);
                    menu();
                    break;
                default:
                    menu();
                    break;



            }
        }

    }
}
