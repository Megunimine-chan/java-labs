package task4.cages;

import java.util.ArrayList;
import java.util.List;

public class Zoo {

    public List<Cage> cages = new ArrayList<>();

    public int getCountOfAnimals() {
        return cages.stream().mapToInt(i -> i.getCapacity()-i.getSize()).sum();
    }

    public void addCage(Cage cage) {
        cages.add(cage);
    }
}

