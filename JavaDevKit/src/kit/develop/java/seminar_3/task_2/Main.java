package kit.develop.java.seminar_3.task_2;

public class Main {
    public static void main(String[] args) {
        MyArray<Integer> myArray = new MyArray<>();
        myArray.add(1)
                .add(3)
                .add(3)
                .add(93);
        System.out.println();

        System.out.println(myArray);

        myArray.forEach(n -> System.out.print(n + " "));

        System.out.println();
        for (Integer n : myArray) System.out.print(n + " ");
    }
}
