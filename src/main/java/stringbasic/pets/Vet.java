package stringbasic.pets;

import java.util.ArrayList;
import java.util.List;

public class Vet {

    public List<Pet> petList = new ArrayList<>();

    public void add(Pet newPet) {
        for (Pet pet : petList) {
            if (areEguals(pet,newPet)) {
                return;
            }
        }
        petList.add(newPet);
    }

    public List<Pet> getPets() {
        return petList;
    }

    public boolean areEguals(Pet pet1, Pet pet2) {
        return pet1.getRegistrationNumber().equals(pet2.getRegistrationNumber());
    }
}
