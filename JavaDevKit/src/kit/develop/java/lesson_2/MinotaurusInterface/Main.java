package kit.develop.java.lesson_2.MinotaurusInterface;

public class Main {
    private static class Minotaurus implements Human, Bull{
        @Override
        public void walk() {
            System.out.println("Walks on two legs");
        }

        @Override
        public void talk() {
            System.out.println("Asks you a riddle");
        }
    }

    public static void main(String[] args) {
        Man man1 = new Man(); // class Man
        Ox ox1 = new Ox(); // class Ox
        Human man2 = new Man(); // interface Human
        Bull ox2 = new Ox(); // interface Bull
        Bull minos1 = new Minotaurus();
        Human minos2 = new Minotaurus();
        Minotaurus minos3 = new Minotaurus();

        Bull[] bulls = {ox1, minos1, minos3};
        Human[] humans = {man1, minos2, minos3};
        Minotaurus[] minotauruses = {minos3, (Minotaurus) minos2, (Minotaurus) minos1};
    }
}
