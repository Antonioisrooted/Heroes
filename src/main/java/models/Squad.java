package models;


import java.util.ArrayList;

public class Squad {
    private String name;
    private String dedicatedToFight;
    private int maxSize;
    private static ArrayList<Squad>squads = new ArrayList<>();
    public Squad(String name, String dedicatedToFight, int maxSize) {
        this.name = name;
        this.dedicatedToFight = dedicatedToFight;
        this.maxSize = maxSize;
        squads.add(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDedicatedToFight() {
        return dedicatedToFight;
    }

    public void setDedicatedToFight(String dedicatedToFight) {
        this.dedicatedToFight = dedicatedToFight;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public static ArrayList<Squad> getSquads() {
        return squads;
    }

}
