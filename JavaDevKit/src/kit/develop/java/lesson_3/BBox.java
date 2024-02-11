package kit.develop.java.lesson_3;

public class BBox <V extends Number>{
    private V value;
    public V getValue(){
        return value;
    }
    public void setValue(V value){
        this.value = value;
    }

    public static <T extends Number> void setIfNull(BBox<T> box, T t){
        if(box.getValue() == null){
            box.setValue(t);
        }
    }

    public static void main(String[] args) {
        BBox<Integer> integerBBox = new BBox<>();
//        BBox<String> stringBBox = new BBox<String>();

        setIfNull(integerBBox, 4);
//        setIfNull(stringBBox, "hello");

        System.out.println(integerBBox.getValue());
    }
}
