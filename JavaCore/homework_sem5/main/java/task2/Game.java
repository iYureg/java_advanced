package task2;

import java.io.*;

public class Game {
    private int[] states;

    public Game(int[] arr) {
        states = arr;
    }

    /**
     * метод возвращает сумму состояний, используя побитовый сдвиг
     * @return int
     */
    public int saveToByte() {
        int moveLeft = 0;
        for (int i = 0; i < states.length; i++) {
            moveLeft = moveLeft << 2;
            moveLeft = moveLeft | states[i];
//            System.out.println(moveLeft);
        }
        return moveLeft;
    }

    /**
     * метод преобразует целое число в состояния, используя побитовый сдвиг
     * @param moveBack передаваемое в метод целое число
     */
    public void getStates(int moveBack) {
        for (int i = states.length - 1; i >= 0; i--) {
            int state = moveBack & 3;
            moveBack = moveBack >> 2;
            states[i] = state;
//            System.out.println(state);
        }
    }


    /**
     * Запись в файл
     * @param path куда записать
     * @throws IOException бросает выше
     */
    public void write(String path) throws IOException {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(path))) {
            dos.writeInt(saveToByte());
        }
    }


    /**
     * Чтение из файла
     * @param path откуда читать
     * @throws IOException бросает выше
     */
    public void read(String path) throws IOException {
        try (DataInputStream dis = new DataInputStream(new FileInputStream(path))) {
            int readInt = dis.readInt();
            getStates(readInt);
        }
    }

    /**
     * Вывод в консоль
     */
    public void print() {
        for (int i = 0; i < states.length; i++) {
            char show = '?';
            switch (states[i]) {
                case 0:
                    show = ' ';
                    break;
                case 1:
                    show = 'X';
                    break;
                case 2:
                    show = 'O';
                    break;
            }
            System.out.print(show + " ");
            if ((i + 1) % 3 == 0) {
                System.out.println();
            }
        }
    }
}
