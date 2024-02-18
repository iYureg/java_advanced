package kit.develop.java.seminar_4_collections.homework;

import lombok.Data;

import java.util.*;

@Data
public class Employee {
    private int uid;
    private String name;
    private List<Integer> phones;
    private int experience;

    public Employee(int uid, String name) {
        this.uid = uid;
        this.name = name;
        this.phones = new ArrayList<>();
        this.experience = 0;
    }

    public void addPhoneNumber(int num){
        phones.add(num);
    }

    @Override
    public String toString(){
        return String.format("UID: %d, Name: %s, Phones: %s, Experience: %d",
                this.getUid(),
                this.getName(),
                this.getPhones(),
                this.getExperience());
    }
}
