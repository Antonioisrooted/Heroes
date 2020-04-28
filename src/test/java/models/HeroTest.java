package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class HeroTest {

    @Test
    public void heroInstantiateCorrectly(){
        Hero hero = createNewHero();
        assertTrue(hero instanceof Hero);
    }
    @Test
    public void getNameReturnsCorrectName(){
        Hero hero = createNewHero();
        String expected = "Batman";
        assertEquals(expected, hero.getName());
    }
    @Test
    public void setNameSetsNameCorrectly(){
        Hero hero = createNewHero();
        hero.setName("Aquaman");
        assertEquals("Aquaman", hero.getName());
    }
    @Test
    public void getAgeReturnsCorrectAge(){
        Hero hero = createNewHero();
        int expected = 40;
        assertTrue(expected == hero.getAge());
    }
    @Test
    public void setAgeAddsRightAge(){
        Hero hero = createNewHero();
        hero.setAge(45);
        assertEquals(45,hero.getAge());
    }
    @Test
    public void getSpecialPowersReturnsCorrectSpecialPowers(){
        Hero hero = createNewHero();
        String expected = "knowledge";
        assertEquals(expected, hero.getSpecialPowers());
    }
    @Test
    public void setSpecialPowersWorksCorrectly(){
        Hero hero = createNewHero();
        hero.setSpecialPowers("magic");
        assertEquals("magic", hero.getSpecialPowers());
    }

    @Test
    public void getWeaknessReturnsCorrectWeakness(){
        Hero hero = createNewHero();
        String expected = "sunlight";
        assertEquals(expected, hero.getWeakness());

    }
    @Test
    public void setWeaknessWorksCorrectly(){
        Hero hero = createNewHero();
        hero.setWeakness("women");
        assertEquals("women",hero.getWeakness());
    }

    @Test
    public void findHeroByIdReturnCorrectHero(){
        Hero hero = createNewHero();
        assertEquals(1, Hero.findById(1).getId());
    }

    @Test
    public void heroPlacedToCorrectSquad(){
        Hero hero = createNewHero();
        assertEquals("Avengers", hero.getSquad());
    }


    //helper method
    public Hero createNewHero(){
        return new Hero("Batman",40,"knowledge","sunlight","Avengers");
    }

}