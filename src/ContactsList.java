import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ContactsList {
    public static void main(String[] args) throws IOException {

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


        Path filePath = Paths.get("data", "contacts.txt");

        Files.write(filePath, contacts);

        List<String> contactsListFromFile = Files.readAllLines(filePath);


        for (int i = 0; i < contactsListFromFile.size(); i += 1) {
            System.out.println((i + 1) + ": " + contactsListFromFile.get(i));
        }

        Files.write(
                Paths.get("data", "contacts.txt"),
                Arrays.asList("test"),
                StandardOpenOption.APPEND
        );


        List<String> newContactsList = new ArrayList<>();

        List<String> lines = Files.readAllLines(filePath);
        for (String line : lines) {
            if (line.equals("Olivia Spencer - 305-559-1412")) {
                newContactsList.add("Angela Bassett - 555-555-5555");
                continue;
            }
            newContactsList.add(line);
        }
        Files.write(filePath, newContactsList);
    }

}
