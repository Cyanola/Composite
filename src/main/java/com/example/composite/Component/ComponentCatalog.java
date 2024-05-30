package com.example.composite.Component;

import com.example.composite.ComponentException;
import javafx.scene.Node;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.List;

public abstract class ComponentCatalog {
    protected List<ComponentCatalog> components = new ArrayList<>();
   // описание поля класса
  protected Character prefix;
 protected   String name;
  protected String artist;
 protected String genre;
   // параметры рисования
   protected double x;
   protected double y;
   protected double w;
   protected double h;
   protected String style;

    public abstract ComponentCatalog get(int index) throws ComponentException;
    public abstract int size() throws ComponentException;
   public abstract void add(ComponentCatalog componentCatalog) throws ComponentException;
    public abstract List<ComponentCatalog > all() throws ComponentException;

   public abstract void remove(ComponentCatalog componentCatalog) throws ComponentException;

   public abstract void draw(Pane pane, double x, double y);

   public abstract Node getPicture();

   public abstract void setX(double x) throws ComponentException;

   public abstract void setY(double y);

   public abstract void setW(double w);

   public abstract void setH(double h);

   public String getStyle() {
      return style;
   }

   public void setStyle(String style) {
      this.style = style;
   }

}
