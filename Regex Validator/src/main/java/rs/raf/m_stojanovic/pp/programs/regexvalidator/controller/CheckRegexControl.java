package rs.raf.m_stojanovic.pp.programs.regexvalidator.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ListView;

public class  CheckRegexControl implements EventHandler<ActionEvent> {

    private final ListView<String> goodListView, badListView;

    public CheckRegexControl(ListView<String> goodListView, ListView<String> badListView) {
        this.goodListView = goodListView;
        this.badListView = badListView;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        this.goodListView.refresh();
        this.badListView.refresh();
    }
}
