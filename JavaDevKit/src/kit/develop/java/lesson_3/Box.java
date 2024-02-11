package kit.develop.java.lesson_3;

/**
 * Демо класс коробка,
 * демонстрирующий возможные проблемы с типами данных
 */
public class Box {
    private Object obj;
    public Box(Object obj){
        this.obj = obj;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public void getInfo(){
        System.out.printf("Box (%s): %s\n", obj.getClass().getSimpleName(), obj.toString());
    }

    public static void main(String[] args) {
        Box b1 = new Box(20);
        Box b2 = new Box(30);
//        System.out.println(b1.getObj() + b2.getObj());   // Operator '+' cannot be applied to 'java.lang.Object', 'java.lang.Object'
        System.out.println((Integer) b1.getObj() + (Integer) b2.getObj());

        Box b3 = new Box("Hello, ");
        Box b4 = new Box("World!");
        System.out.println((String) b3.getObj() + (String) b4.getObj());


        //___________________________________

        Box iBox1 = new Box(10);
        Box iBox2 = new Box(20);

//        iBox2.setObj("string"); // Java: What can do wrong here? You can do it!
        if(iBox1.getObj() instanceof Integer && iBox2.getObj() instanceof Integer){
            int sum = (Integer) iBox1.getObj() + (Integer) iBox2.getObj();
            System.out.println("sum = " + sum);
        } else {
            System.out.println("The content of the boxes differ by type");
        }

    }
}
