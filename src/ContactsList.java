import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

public class ContactsList {
//    OUR SCANNER
    private static Scanner sc = new Scanner(System.in);

//USED TO DISPLAY THE LIST OF CONTACTS FROM OUR FILE. IT READS EVERY LINE FROM THE FILE AND PRINTS EACH LINE.
    public static void showContactList(Path datafile) throws IOException {
        int nameWidth = 20;
        int phoneWidth = 15;
        List<String> lines = Files.readAllLines(datafile);
        System.out.println("------------------------------------");
        System.out.printf("%-" + nameWidth + "s | %-" + phoneWidth + "s%n", "Contact Name", "Phone Number");
        System.out.println("------------------------------------");
        for (String contacts : lines) {
            String[] parts = contacts.split("\\|");
            String name = parts[0].trim();
            String phoneNumber = parts[1].trim();

            System.out.printf("%-" + nameWidth + "s | %-" + phoneWidth + "s%n", name, phoneNumber);
        }
    }

//ALLOWS A CONTACT TO BE ADDED,
// THROWS IOException:
    public static void AddContact() throws IOException {
        System.out.println("Enter First and Last Name. ");
        String nameInput = sc.nextLine();
        System.out.println("Enter phone number.");
        String numberInput = sc.nextLine();
        String contactInfo = nameInput + " | " + numberInput;
        System.out.println("Arrays.asList(contactInfo) = " + Arrays.asList(contactInfo));
        Files.write(
                Paths.get("data", "contacts.txt"),
                Arrays.asList(contactInfo),
                StandardOpenOption.APPEND
        );
    }


    public static void searchContact(Scanner sc) throws IOException {
        System.out.println("Enter name: ");
          String search = ContactsList.sc.next();
        Path datafile = Paths.get("data", "contacts.txt");
        List<String> lines = Files.readAllLines(datafile);
        List<String> searchResults = new ArrayList<>();
        for (String line : lines){
            if (line.toLowerCase().contains(search.toLowerCase())){
                searchResults.add(line);
            }
        }

        if(searchResults.isEmpty()){
            System.out.println("Contact not found");
        } else {
            System.out.println("Search results:");
            for(String result: searchResults){
                System.out.println(result);
            }
        }
    }


    public static void deleteContact(Scanner sc) {
        System.out.print("Enter the name to delete : ");
//        sc.nextLine();
        String name = sc.nextLine();
        List<String> lines = null;
        try {
            lines = Files.readAllLines(Paths.get("data", "contacts.txt"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        List<String> newList = new ArrayList<>();

        for (String line : lines) {
            if (line.contains(name)) {
                continue;
            }
            newList.add(line);
        }

        try {
            Files.write(Paths.get("data", "contacts.txt"), newList);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    public static void exitList (int status) {
        Runtime.getRuntime().exit(status);
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

        if (Files.readAllLines(dataFile).size() == 0) {
            List<String> contacts = Arrays.asList(
                    "Jerrod Cooper | 754-244-7389",
                    "Elizabeth Taylor | 816-544-6492",
                    "Harry Potter | 302-190-7349",
                    "Olivia Spencer | 305-559-1412",
                    "Jerry Springer | 757-468-1112",
                    "Idris Elba | 212-444-2323",
                    "Beyonce Knowles | 281-503-7262",
                    "Michael Jones | 281-330-8004",
                    "Soulja Boi | 678-999-8212",
                    "Little Wayne | 504-981-2617"
            );
            Files.write(dataFile, contacts);
        }
        do {
            System.out.println("Choose from the following menu:");
            System.out.println(" Press 1: View Contacts \n Press 2: Add Contact \n Press 3: Search Contacts \n Press 4: Delete Contact \n Press 5: Exit");
            int userAnswer = sc.nextInt();
            sc.nextLine();
                if (userAnswer == 1) {
                    showContactList(dataFile);
                } else if (userAnswer == 2) {
                    AddContact();
                } else if (userAnswer == 3) {
                    searchContact(sc);
                } else if (userAnswer == 4) {
                    deleteContact(sc);

                } else if (userAnswer == 5) {
                    exitList(0);
                    break;
            }
        } while (true) ;
    }



        public static void main (String[]args) throws IOException {
            runApp();


        }

    }

