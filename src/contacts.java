import java.util.ArrayList;
public class contacts {
    private String name;
    private ArrayList<Integer> phoneNumber;


    public contacts(String name) {
        this.name = name;
        this.phoneNumber = new ArrayList<>();
    }



    public String getName() {
        return name;
    }

    public void addNumber(int grade) {
        phoneNumber.add(grade);
    }
}
