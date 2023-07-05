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
    for(int i = 0; i < lines.size(); i += 1) {
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


// THROWS IOException:
public static void runApp () throws IOException{
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
    System.out.println(" Press 1, to view contacts \n Press 2, to add contact\n Press 3, to search contacts");
    int userAnswer = sc.nextInt();

    if(userAnswer == 1){
        showContactList(dataFile);
    } else if (userAnswer == 2) {
        AddContact();
    }



}










//private static void ReplaceContact() throws IOException {
//    List<String> lines = Files.readAllLines(newContactstList);
//    List<String> newContactsList = new ArrayList<>();
//    for (String line : lines) {
//        if (line.equals("Olivia Spencer - 305-559-1412")) {
//            newContactsList.add("Angela Bassett - 555-555-5555");
//            continue;
//        }
//        newContactsList.add(line);
//    }
//    Files.write(Paths.get("data", "contacts.txt"), newContactsList);
//
//    for(int i = 0; i < newContactsList.size(); i += 1) {
//        System.out.println((i + 1) + ": " + newContactsList.get(i));
//    }
//}





    public static void main(String[] args) throws IOException {
        runApp();


// May not need becuzwe are doing it on lines   Path dataDirectory = Paths.get(directory);
//        Path dataFile = Paths.get(directory, filename);
//        Path contactsPath = Paths.get("data", "contacts.txt");


//        Files.write(
//                Paths.get("data", "contacts.txt"),
//                Arrays.asList("test"),
//                StandardOpenOption.APPEND
//        );
//      Potentiallt deleteing later bcuz we have the add =contact method already.
//        List<String> lines = Files.readAllLines(dataFile);
//        List<String> newContactsList = new ArrayList<>();
//        for (String line : lines) {
//            if (line.equals("Olivia Spencer - 305-559-1412")) {
//                newContactsList.add("Angela Bassett - 555-555-5555");
//                continue;
//            }
//            newContactsList.add(line);
//        }
//        Files.write(Paths.get("data", "contacts.txt"), newContactsList);
//            ReplaceContact();
//        for(int i = 0; i < newContactsList.size(); i += 1) {
//            System.out.println((i + 1) + ": " + newContactsList.get(i));
//        }


    }

}
