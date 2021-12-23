package task4.cages;

import java.util.ArrayList;
import java.util.List;

public abstract class Cage<T> {

    private final List<T> animals;
    private int capacity;

    public Cage(int capacity) {
        this.animals = new ArrayList<>();
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getSize(){
        return capacity - animals.size();
    }

    public void addAnimal(T animal){
        if(getSize() > 0){
            animals.add(animal);
        }
        else throw new IllegalArgumentException();
    }
    public void removeAnimal(T animal){
        if(animals.contains(animal)){
            animals.remove(animal);
        }
        else throw new IllegalArgumentException();
    }
}
