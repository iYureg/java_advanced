package kit.develop.java.seminar_5_multithreading.example_2;


public class Friend {
    private String name;

    public Friend(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }
    public synchronized void bow(Friend friend){
        System.out.println(name + ": " + friend.getName() + " поклонился мне");
        friend.bowBack(this);
    }

    public void bowBack(Friend friend){
        System.out.println(name + ": кланиемся в ответ " + friend.getName());
    }
}
