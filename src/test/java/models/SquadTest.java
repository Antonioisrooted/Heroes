package models;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class SquadTest {

    @Test
    public void squadIsInstantiatedCorrectly(){
        Squad squad = createNewSquad();
        assertTrue(squad instanceof Squad);
    }
    @Test
    public void getNameReturnsCorrectNameForTheSquad(){
        Squad squad = createNewSquad();
        String expected = "Avengers";
        assertEquals(expected, squad.getName());
    }
    @Test
    public void setNameSetsSquadNameCorrectly(){
        Squad squad = createNewSquad();
        squad.setName("Ninjas");
        assertNotEquals("Avengers",squad.getName());
    }
    @Test
    public void getDedicatedToFightReturnCorrectResults(){
        Squad squad = createNewSquad();
        String expected = "sexism";
        assertEquals(expected, squad.getDedicatedToFight());
    }
    @Test
    public void setDedicatedToFightSetValueCorrectly(){
        Squad squad = createNewSquad();
        squad.setDedicatedToFight("computer illiteracy");
        assertEquals("computer illiteracy",squad.getDedicatedToFight());
    }
    @Test
    public void getMaxSizeReturnsCorrectSize(){
        Squad squad = createNewSquad();
        assertEquals(5, squad.getMaxSize());
    }
    @Test
    public void setMaxSizeSetsCorrectSize(){
        Squad squad = createNewSquad();
        squad.setMaxSize(10);
        assertEquals(10, squad.getMaxSize());
    }
    @Test
    public void getHeroesReturnAllHeroesInTheSquad(){
        Squad squad = createNewSquad();
        ArrayList<Hero> heroes = new ArrayList<>();
        Hero hero = new Hero("Batman",40,"knowledge","sunlight","Avengers");
        heroes.add(hero);
//        squad.setHeroes(heroes);
//        assertEquals(1, squad.getHeroes().size());
    }

    //helper method
    public Squad createNewSquad(){
        return new Squad("Avengers","sexism",5);
    }
}