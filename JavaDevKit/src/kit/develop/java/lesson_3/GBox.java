package kit.develop.java.lesson_3;

public class GBox<T>{
    private T value;

    public GBox(T value){
        this.value = value;
    }

    public T getValue(){
        return value;
    }

    public void setValue(T value){
        this.value = value;
    }

    public void showType(){
        System.out.printf("Type is %s, with value %s\n", value.getClass().getName(), getValue());
    }

    public static void main(String[] args) {
        GBox<String> stringGBox1 = new GBox<>("Hello!");
        stringGBox1.showType();
        GBox<Integer> integerGBox1 = new GBox<>(12);
        integerGBox1.showType();

        /// Raw type (сырой тип)
        GBox<Integer> intBox = new GBox<>(1);
        GBox box = intBox; // Raw use of parameterized class 'GBox'

        GBox box2 = new GBox(1);
        GBox<Integer> intBox2 = box2; // Unchecked assignment: 'kit.develop.java.lesson_3.GBox' to 'kit.develop.java.lesson_3.GBox<java.lang.Integer>'

        box.setValue(4); // Unchecked call to 'setValue(T)' as a member of raw type 'kit.develop.java.lesson_3.GBox'

        // generic method
        System.out.println("=".repeat(20) + " generic method " + "=".repeat(20));
        GBox<Integer> box3 = new GBox<>(null);
        setIfNull(box3, 13);
        System.out.println(box3.getValue());

        GBox<Integer> box4 = new GBox<>(1);
        setIfNull(box4, 13);
        System.out.println(box4.getValue());
    }

    private static <T> void setIfNull(GBox<T> box, T t){
        if (box.getValue() == null){
            box.setValue(t);
        }
    }
}
