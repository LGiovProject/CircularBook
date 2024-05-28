package com.ispw.circularbook.engineering.bean;

import javafx.scene.layout.Pane;

public class ElementBean {

    private Pane pane;
    private int id;

    public ElementBean(Pane pane, int id) {
        this.pane = pane;
        this.id = id;
    }

    public ElementBean(int id) {
        this.id = id;
    }

    public Pane getPane() {
        return pane;
    }

    public void setPane(Pane pane) {
        this.pane = pane;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
