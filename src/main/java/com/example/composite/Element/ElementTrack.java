package com.example.composite.Element;

import com.example.composite.Component.ComponentCatalog;
import com.example.composite.ComponentException;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Pane;

import java.util.List;

public class ElementTrack extends ComponentCatalog {
    @Override
    public ComponentCatalog get(int index) throws ComponentException {
        return null;
    }

    @Override
    public int size() throws ComponentException {
        return 0;
    }

    @Override
    public void add(ComponentCatalog componentCatalog) throws ComponentException {
        throw new ComponentException();
    }

    @Override
    public List<ComponentCatalog> all() throws ComponentException {
        return null;
    }

    int count=0;


    public ElementTrack() {
        prefix = new Character('-');
        count++;
        name = new String("Трек "+count);
        artist=new String("Исполнитель "+ count);
        genre=new String("Жанр "+ count);
        x = 1.;
        y = 1;
        w = 20;
        h = 7;
        style="-fx-background-color: transparent; -fx-text-fill: linear-gradient(to bottom right, #99001a, #3563a7); " +
                "-fx-border-insets: 3; -fx-border-radius: 20; -fx-border-color: linear-gradient(to top left, steelblue, pink);";

    }

    @Override
    public void remove(ComponentCatalog componentCatalog) throws ComponentException {
        throw new ComponentException();
    }


    double initialX, initialY;
    @Override
    public void draw(Pane pane, double initialX, double initialY) {

            Label field = (Label) getPicture();
            field.setPrefSize((pane.getWidth() * w / 30.), (pane.getHeight() * h / 100.));
            field.setLayoutX(x);
            field.setLayoutY(y);
            field.setOnMouseDragged(event -> {
                if(event.getButton()== MouseButton.PRIMARY) {
                    double deltaX = event.getSceneX() - 2 * initialX;
                    double deltaY = event.getSceneY() - initialY;
                    field.setLayoutX(initialX + deltaX);
                    field.setLayoutY(initialY + deltaY);
                    field.relocate(field.getLayoutX(), field.getLayoutY());
                }
            });
        pane.getChildren().add(field);
    }

    @Override
    public Node getPicture() {
        String text = new String(prefix.toString());
        text += " " + name+"\t"+" " + artist+"\t"+" " + genre+"\t";
        Label field = new Label(text);
        field.setStyle(getStyle());
        return field;
    }

    public void setX(double x) {
        this.x = x;
    }

    @Override
    public void setY(double y) {
        this.y=y;
    }

    @Override
    public void setW(double w) {

    }

    @Override
    public void setH(double h) {

    }
}
