package com.example.composite.Composite;

import com.example.composite.Component.ComponentCatalog;
import com.example.composite.ComponentException;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.List;

public class Composite extends ComponentCatalog {

    public Composite(String name) {// может быть реализован и с другим набором параметров

        this.name=name;
    }

@Override
    public void add(ComponentCatalog componentCatalog) throws ComponentException {
        components.add(componentCatalog);
    }
@Override
    public void remove(ComponentCatalog componentCatalog) throws ComponentException {
        components.remove(componentCatalog);
    }
@Override
    public ComponentCatalog get(int index) {
        return components.get(index);
    }
@Override
    public int size() {
        return components.size();
    }
    @Override

    public List<ComponentCatalog> all() {
        return components;
    }

double initialX, initialY;
    @Override
    public void draw(Pane pane,double x, double y) {
        for (ComponentCatalog comp : all()) {
            comp.setStyle(style);
            comp.draw(pane, x, y);
        }
    }

    @Override
    public Node getPicture() {
        Label group = new Label();
        String s="";
        for (ComponentCatalog comp : all()) {
            // Assuming your ComponentCatalog has a way to get a Label representation
            Label label = (Label) comp.getPicture();
            if (label != null) {
               s += label.getText();
                group.setText(s);
            }
        }
        return group;
    }

    @Override
    public void setX(double x) throws ComponentException {

        for (ComponentCatalog comp : all()) comp.setX(x);
    }

    @Override
    public void setY(double y) {
        double newY = y;
        for (ComponentCatalog comp : all()) {
            comp.setY(newY);
            newY += 27;  // Шаг по y для каждого компонента
        }
    }

    @Override
    public void setW(double w) {
        for (ComponentCatalog comp : all()) {
            comp.setW(w);
        }
    }

    @Override
    public void setH(double h) {
        for (ComponentCatalog comp : all()) {
            comp.setH(h);
        }
    }
}
