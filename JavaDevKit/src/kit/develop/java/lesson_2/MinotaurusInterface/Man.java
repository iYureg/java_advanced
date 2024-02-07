package kit.develop.java.lesson_2.MinotaurusInterface;

public class Man implements Human{
    @Override
    public void walk(){
        System.out.println("Walk on two feet");
    }

    @Override
    public void talk(){
        System.out.println("Talks meaningful words");
    }
}
