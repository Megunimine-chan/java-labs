package task4.tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import task4.cages.*;
import task4.animals.*;

import java.util.List;
import java.util.stream.Stream;

public class ZOOTests {
    Zoo zoo;

    Cage<Lion> lionCage;
    Cage<Hoofed> hoofedCage;
    Cage<Bird> eagleCage;

    Lion lion1;
    Lion lion2;
    Zebra zebra;
    Giraffe giraffe1;
    Giraffe giraffe2;
    Eagle eagle;

    @Before
    public void SetUp(){
        lion1 = new Lion();
        lion2 = new Lion();
        zebra = new Zebra();
        giraffe1 = new Giraffe();
        giraffe2 = new Giraffe();
        eagle = new Eagle();

        lionCage = new LionCage(2);
        hoofedCage = new HoofedCage(2);
        eagleCage = new BirdCage(2);

        zoo = new Zoo();
    }

    @Test
    public void SizeCounterTest(){
        lionCage.addAnimal(lion1);
        Assert.assertEquals(lionCage.getSize(), 1);
    }

    @Test
    public void RemoveAnimalTest(){
        lionCage.addAnimal(lion1);
        lionCage.removeAnimal(lion1);
        Assert.assertEquals(lionCage.getSize(), 2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void RemoveUnaddedAnimalTest(){
        lionCage.removeAnimal(lion1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addMoreThanCapacity(){
        hoofedCage.addAnimal(giraffe1);
        hoofedCage.addAnimal(giraffe2);
        hoofedCage.addAnimal(zebra);
    }

    @Test
    public void ZooCounterTest(){
        lionCage.addAnimal(lion1);
        lionCage.addAnimal(lion2);
        eagleCage.addAnimal(eagle);
        zoo.addCage(lionCage);
        zoo.addCage(eagleCage);
        Assert.assertEquals(zoo.getCountOfAnimals(),3);
    }

    @Test
    public void EmptyZooTest(){
        Assert.assertEquals(zoo.getCountOfAnimals(),0);
    }
}


