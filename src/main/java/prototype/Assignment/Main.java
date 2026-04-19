package prototype.Assignment;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RecommendationRegistry registry = new RecommendationRegistry();

        Recommendation fantasy = new Recommendation("Fantasy Lovers");
        fantasy.addBook(new Book("The Hobbit", "J.R.R. Tolkien", "Fantasy", 1937));
        fantasy.addBook(new Book("Harry Potter", "J.K. Rowling", "Fantasy", 1997));

        registry.addPrototype("fantasy", fantasy);

        while (true) {
            System.out.println("\n1. View templates");
            System.out.println("2. Clone recommendation");
            System.out.println("3. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                registry.listPrototypes();
            }

            else if (choice == 2) {
                System.out.print("Enter template name: ");
                String key = scanner.nextLine();

                Recommendation rec = registry.getClone(key);

                if (rec == null) {
                    System.out.println("Template not found.");
                    continue;
                }

                System.out.print("New audience: ");
                rec.setTargetAudience(scanner.nextLine());

                while (true) {
                    System.out.println("\nModify recommendation:");
                    System.out.println("1. Add book");
                    System.out.println("2. Remove book");
                    System.out.println("3. View list");
                    System.out.println("4. Save & exit");

                    int modChoice = scanner.nextInt();
                    scanner.nextLine();

                    if (modChoice == 1) {
                        System.out.print("Title: ");
                        String title = scanner.nextLine();

                        System.out.print("Author: ");
                        String author = scanner.nextLine();

                        System.out.print("Genre: ");
                        String genre = scanner.nextLine();

                        System.out.print("Year: ");
                        int year = scanner.nextInt();
                        scanner.nextLine();

                        rec.addBook(new Book(title, author, genre, year));
                    }

                    else if (modChoice == 2) {
                        rec.display();
                        System.out.print("Index to remove: ");
                        int idx = scanner.nextInt();
                        scanner.nextLine();
                        rec.removeBook(idx - 1);
                    }

                    else if (modChoice == 3) {
                        rec.display();
                    }

                    else if (modChoice == 4) {
                        System.out.print("Save as template name: ");
                        String newKey = scanner.nextLine();
                        registry.addPrototype(newKey, rec);
                        break;
                    }
                }
            }

            else if (choice == 3) {
                break;
            }
        }

        scanner.close();
    }
}