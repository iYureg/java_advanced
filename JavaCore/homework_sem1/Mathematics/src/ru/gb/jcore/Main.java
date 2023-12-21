package ru.gb.jcore;

import ru.gb.jcore.model.CalcModel;
import ru.gb.jcore.model.Sum;
import ru.gb.jcore.presenter.Presenter;
import ru.gb.jcore.view.View;

public class Main {
    public static void main(String[] args) {
        Presenter<CalcModel> p = new Presenter<>(new Sum(), new View());

        p.calculate();
    }
}