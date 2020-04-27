package models;

import java.util.ArrayList;

public class Hero {
    private int id;
    private String name;
    private int age;
    private String specialPower;
    private String weakness;
    private int squad;
    private static ArrayList<Hero> heroInstance = new ArrayList<>();

    public Hero(String name, int age, String specialPower, String weakness, int squad) {
        this.id = heroInstance.size();
        this.name = name;
        this.age = age;
        this.specialPower = specialPower;
        this.weakness = weakness;
        this.squad = squad;
        this.heroInstance.add(this);
    }

    public int getSquad() { return squad; }

    public int getId() { return id; }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getSpecialPower() {
        return specialPower;
    }

    public String getWeakness() {
        return weakness;
    }

    public static ArrayList<Hero> getHeroInstance() {
        return heroInstance;
    }

    public static Hero findById(int id) {
        return heroInstance.get(id-1);
    }
}
