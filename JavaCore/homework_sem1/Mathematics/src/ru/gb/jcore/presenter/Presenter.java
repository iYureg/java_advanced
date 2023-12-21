package ru.gb.jcore.presenter;


import ru.gb.jcore.model.CalcModel;
import ru.gb.jcore.model.Model;
import ru.gb.jcore.view.View;

public class Presenter <T extends CalcModel>{
    View view;
    Model model;

    public Presenter(T model, View view){
        this.model = model;
        this.view = view;
    }

    public void calculate(){
        int a = view.getValue("input a: ");
        int b = view.getValue("input b: ");
        model.setX(a);
        model.setY(b);
        int result = model.result();
        view.print(result, "Sum: ");
    }
}
