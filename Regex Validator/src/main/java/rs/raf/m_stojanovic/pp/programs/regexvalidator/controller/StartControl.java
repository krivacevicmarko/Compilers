package rs.raf.m_stojanovic.pp.programs.regexvalidator.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ListView;
import rs.raf.m_stojanovic.pp.programs.regexvalidator.model.RegexSource;
import rs.raf.m_stojanovic.pp.programs.regexvalidator.model.UsableRegexSource;
import rs.raf.m_stojanovic.pp.programs.regexvalidator.model.base.Server;
import rs.raf.m_stojanovic.pp.programs.regexvalidator.view.ChooseRegexSourceView;
import rs.raf.m_stojanovic.pp.programs.regexvalidator.view.MainView;

public class StartControl implements EventHandler<ActionEvent> {

    private final ChooseRegexSourceView chooseRegexSourceView;

    private final ListView<RegexSource> regexSourceListView;

    public StartControl(ChooseRegexSourceView chooseRegexSourceView, ListView<RegexSource> regexSourceListView) {
        this.chooseRegexSourceView = chooseRegexSourceView;
        this.regexSourceListView = regexSourceListView;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        int index = this.regexSourceListView.getSelectionModel().getSelectedIndex();
        RegexSource regexSource = this.regexSourceListView.getSelectionModel().getSelectedItem();
        if (regexSource != null) {
            UsableRegexSource usableRegexSource = Server.getServer().convertToUsableRegexSource(regexSource);
            this.regexSourceListView.getItems().set(index, usableRegexSource);
            MainView mainView = new MainView(usableRegexSource);
            mainView.show();
            this.chooseRegexSourceView.close();
        }
    }
}
