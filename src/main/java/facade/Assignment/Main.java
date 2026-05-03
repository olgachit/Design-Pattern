package facade.Assignment;

public class Main {
    public static void main(String[] args) {
        ApiFacade api = new ApiFacade();

        try {
            /*
            String joke = api.getAttributeValueFromJson(
                    "https://api.chucknorris.io/jokes/random",
                    "value"
            );

            System.out.println(joke);
             */
            System.out.println("Enter name to guess age:");
            String name = new java.util.Scanner(System.in).nextLine();

            String age = api.getAttributeValueFromJson(
                    "https://api.agify.io?name=" + name,
                    "age"
            );

            System.out.println("Estimated age for " + name + ": " + age);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
