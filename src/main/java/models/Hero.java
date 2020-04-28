package models;

import java.util.ArrayList;

public class Hero {
    private String name;
    private int age;
    private String specialPowers;
    private String weakness;
    private static ArrayList<Hero> heroes = new ArrayList();
    private int id;
    private String heroSquad;

    public Hero(String name, int age, String specialPowers, String weakness, String heroSquad){
        this.name = name;
        this.age = age;
        this.specialPowers = specialPowers;
        this.weakness = weakness;
        this.heroes.add(this);
        this.id = heroes.size();
        this.heroSquad = heroSquad;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSpecialPowers() {
        return specialPowers;
    }

    public void setSpecialPowers(String specialPowers) {
        this.specialPowers = specialPowers;
    }

    public String getWeakness() {
        return weakness;
    }

    public void setWeakness(String weakness) {
        this.weakness = weakness;
    }

    public static ArrayList<Hero> getHeroes() {
        return heroes;
    }

    public static Hero findById(int id){
        return heroes.get(id -1);
    }

    public String getSquad(){
        return heroSquad;
    }

    public int getId() {
        return id;
    }
}
