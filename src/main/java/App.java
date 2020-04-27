import java.util.ArrayList;

import static spark.Spark.*;

public class App {
    String name;
    int age;
    String sex;
    boolean intact;
    ArrayList<String> breeds;

    public App(String name, int age, String sex, boolean intact, ArrayList<String> breeds) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.intact = intact;
        this.breeds = breeds;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getSex() {
        return sex;
    }

    public App(String name) {
        this.name = name;
    }

    public boolean isIntact() {
        return intact;
    }

    public ArrayList<String> getBreeds() {
        return breeds;
    }
}
