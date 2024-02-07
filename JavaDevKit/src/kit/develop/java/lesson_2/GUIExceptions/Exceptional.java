package kit.develop.java.lesson_2.GUIExceptions;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Exceptional extends JFrame implements ActionListener , Thread.UncaughtExceptionHandler{
    private Exceptional(){
        Thread.setDefaultUncaughtExceptionHandler(this);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(1100, 200, 500, 300);
        JButton button = new JButton("Eat me!");
        button.addActionListener(this);
        add(button);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Exceptional();
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e){
        throw new ArrayIndexOutOfBoundsException("shit happens!");
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        JOptionPane.showMessageDialog(
                null, e.getMessage(), "Exception!", JOptionPane.ERROR_MESSAGE
        );
    }
}
