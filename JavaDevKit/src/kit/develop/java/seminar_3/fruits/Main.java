package kit.develop.java.seminar_3.fruits;

public class Main {
    public static void main(String[] args) {
        Box<Apple> appleBox = new Box<>();
        Box<Orange> orangeBox = new Box<>();
        Box<Fruit> fruitBox = new Box<>();

        fruitBox.add(new Orange());
        fruitBox.add(new Apple());

        appleBox.add(new Apple());
        appleBox.add(new Apple());
        appleBox.add(new Apple());

        orangeBox.add(new Orange());
        orangeBox.add(new Orange());

        System.out.println(appleBox.compareByWeight(orangeBox));
        appleBox.transferTo(fruitBox);
//        appleBox.transferTo(orangeBox);
//        orangeBox.transferTo(appleBox);
        orangeBox.transferTo(fruitBox);
        System.out.println(fruitBox);
    }
}
