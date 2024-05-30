package com.example.composite;

import com.example.composite.Component.ComponentCatalog;
import com.example.composite.Composite.Composite;
import com.example.composite.Element.ElementTrack;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
        public double x;
        public double y;
        public Pane pane;


        public ComponentCatalog componentCatalog = null;
        public ComponentCatalog componentCatalog1;
        public ComponentCatalog componentCatalog2;
        public ComponentCatalog componentCatalog3;


        public void ClFin(ActionEvent actionEvent) {
         //   pane.getChildren().clear();
            componentCatalog=componentCatalog2;

        }

        public void ClSt(ActionEvent actionEvent) {
           // pane.getChildren().clear();
            componentCatalog=componentCatalog1;
        }

        public void ClTr(ActionEvent actionEvent) {
         //   pane.getChildren().clear();
            componentCatalog=componentCatalog3;
        }

        public void Clean(ActionEvent actionEvent) {
            pane.getChildren().clear();

        }
double initialY, initialX;
        public void onClick(MouseEvent mouseEvent) throws ComponentException {
            //pane.getChildren().clear();
            if(mouseEvent.getButton()== MouseButton.SECONDARY) {
                x = mouseEvent.getX();
                y = mouseEvent.getY();
                if (componentCatalog == null) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText("Please select an item and style.");
                    alert.show();
                } else {


                    componentCatalog.setY(y);
                    componentCatalog.setX(x);

                    componentCatalog.draw(pane, x, y);


                }
            }
        }
int count=0;
        @Override
        public void initialize(URL location, ResourceBundle resources) {

            componentCatalog1 = new ElementTrack();

            ComponentCatalog temp = new Composite("Трек");
            ElementTrack elementTrack1 = new ElementTrack();
            ElementTrack elementTrack2 = new ElementTrack();
            try {
                temp.add(elementTrack1);
            } catch (ComponentException e) {
                throw new RuntimeException(e);
            }
            try {
                temp.add(elementTrack2);
            } catch (ComponentException e) {
                throw new RuntimeException(e);
            }
            componentCatalog2 = new Composite("Альбом "+count++);

            ComponentCatalog a1 = new ElementTrack();
            ArrayList<ComponentCatalog> temp1 = new ArrayList<>();
            ElementTrack elementTrack3 = new ElementTrack();
            ElementTrack elementTrack4 = new ElementTrack();
            temp1.add(elementTrack3);
            try {
                temp.add(elementTrack4);
            } catch (ComponentException e) {
                throw new RuntimeException(e);
            }

            ComponentCatalog b1 = new Composite( "Альбом "+count++);
     ComponentCatalog comps = new Composite("Плейлист");
            try {
                comps.add(a1);
            } catch (ComponentException e) {
                throw new RuntimeException(e);
            }
            try {
                comps.add(b1);
            } catch (ComponentException e) {
                throw new RuntimeException(e);
            }

            componentCatalog3 = new Composite("Плейлист "+count+1);

        }

        public void clColor(ActionEvent actionEvent) {
            if (componentCatalog == null) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText("Please select an item and style.");
                alert.show();
            } else {

                    componentCatalog.setStyle("-fx-background-color: transparent; -fx-text-fill: linear-gradient(to bottom right, #99001a, #3563a7);" +
                            "-fx-border-insets: 3; -fx-border-radius: 20; -fx-border-color: linear-gradient(to top left, steelblue, pink);");

            }
        }

        public void clWhite(ActionEvent actionEvent) {
            if (componentCatalog == null) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText("Please select an item and style.");
                alert.show();
            } else {
               componentCatalog.
             setStyle("-fx-background-color: white; -fx-text-fill: black; -fx-border-insets: 1; -fx-border-width: 2; -fx-border-style: solid;");
                }
            }

}