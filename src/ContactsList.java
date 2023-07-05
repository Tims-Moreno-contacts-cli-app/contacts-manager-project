import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

public class ContactsList {
    private static Scanner sc = new Scanner(System.in);


    public static void showContactList(Path datafile) throws IOException {
        List<String> lines = Files.readAllLines(datafile);
        for (int i = 0; i < lines.size(); i += 1) {
            System.out.println((i + 1) + ": " + lines.get(i));
        }
    }


    public static void AddContact() throws IOException {
        System.out.println("Enter First and Last Name. ");
        String nameInput = sc.nextLine();
        System.out.println("Enter phone number.");
        String numberInput = sc.nextLine();
        String contactInfo = nameInput + " - " + numberInput;
        System.out.println("Arrays.asList(contactInfo) = " + Arrays.asList(contactInfo));
        Files.write(
                Paths.get("data", "contacts.txt"),
                Arrays.asList(contactInfo),
                StandardOpenOption.APPEND
        );
    }


    public static void searchContact(Scanner scanner) {

    }


    public static void deleteContact(Scanner sc) {
        System.out.print("Enter the name to delete : ");
        String name = sc.nextLine();


    }


    public static void exitList () {

}


    // THROWS IOException:
    public static void runApp() throws IOException {
        String directory = "data";
        String filename = "contacts.txt";

        Path dataDirectory = Paths.get(directory);
        Path dataFile = Paths.get(directory, filename);

        if (Files.notExists(dataDirectory)) {
            Files.createDirectories(dataDirectory);
        }

        if (!Files.exists(dataFile)) {
            Files.createFile(dataFile);
        }

        List<String> contacts = Arrays.asList(
                "Jerrod Cooper - 754-244-7389",
                "Elizabeth Taylor - 816-544-6492",
                "Harry Potter - 302-190-7349",
                "Olivia Spencer - 305-559-1412",
                "Jerry Springer - 757-468-1112",
                "Idris Elba - 212-444-2323",
                "Beyonce Knowles - 281-503-7262",
                "Michael Jones - 281-330-8004",
                "Soulja Boi - 678-999-8212",
                "Little Wayne - 504-981-2617"
        );
        Files.write(dataFile, contacts);

        System.out.println("Choose from the following menu:");
        System.out.println(" Press 1: View Contacts \n Press 2: Add Contact \n Press 3: Search Contacts \n Press 4: Delete Contact \n Press 5: Exit");
        int userAnswer = sc.nextInt();

        if (userAnswer == 1) {
            showContactList(dataFile);
        } else if (userAnswer == 2) {
            AddContact();
//        } else if (userAnswer == 3) {
//            searchContact();
        } else if (userAnswer == 4) {
            deleteContact(sc);
        } else if (userAnswer == 5) {
            exitList();
        }


    }


        public static void main (String[]args) throws IOException {
            runApp();


        }

    }

//List<String> list = new ArrayList<>();
//
//list.add("A");
//        list.add("B");
//        list.add("C");
//        list.add("C");
//        list.add("B");
//        list.add("A");
//
//        System.out.println(list);
//
//        String removedStr = list.remove(1);
//        System.out.println(list);
//        System.out.println(removedStr);