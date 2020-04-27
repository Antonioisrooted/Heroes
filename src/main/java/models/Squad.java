package models;
import java.util.ArrayList;
import java.util.List;
public class Squad {
    private int id;
    private String name;
    private int currentSize;
    private int maxSize;
    private String motive;
    private ArrayList<Hero> heroes = new ArrayList<>();
    private static ArrayList<Squad> squadInstance = new ArrayList<>();


    public Squad(String name, int maxSize, String motive) {
        this.id = squadInstance.size();
        this.name = name;
        this.currentSize = 0;
        this.maxSize = maxSize;
        this.motive = motive;
        this.squadInstance.add(this);
    }

    public int getId() { return id; }

    public String getName() {
        return name;
    }
    public int getMaxSize() {
        return maxSize;
    }
    public String getMotive() { return motive; }

    public int getCurrentSize() { return currentSize; }

    public ArrayList<Hero> getHeroes() { return heroes; }

    public static ArrayList<Squad> getSquadInstance() {
        return Squad.squadInstance;
    }
    public static Squad findById(int id) {return squadInstance.get(id);}

    public static void clearAll() {
        squadInstance.clear();
    }

    public void addHero(Hero newHero) {
        if (currentSize < maxSize) {
            heroes.add(newHero);
            currentSize ++;
        }
        else {
            getHeroes();
        }
    }
}
