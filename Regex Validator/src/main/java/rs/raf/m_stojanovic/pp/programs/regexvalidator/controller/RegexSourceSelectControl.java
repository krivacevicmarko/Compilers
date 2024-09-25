package rs.raf.m_stojanovic.pp.programs.regexvalidator.controller;

import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import rs.raf.m_stojanovic.pp.programs.regexvalidator.model.NamedRegexSource;
import rs.raf.m_stojanovic.pp.programs.regexvalidator.model.RegexSource;
import rs.raf.m_stojanovic.pp.programs.regexvalidator.model.base.Server;

import java.util.Objects;

public class RegexSourceSelectControl implements EventHandler<MouseEvent> {

    private final ListView<RegexSource> regexSourceListView;

    private final Label label;

    public RegexSourceSelectControl(ListView<RegexSource> regexSourceListView, Label label) {
        this.regexSourceListView = regexSourceListView;
        this.label = label;
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        int index = this.regexSourceListView.getSelectionModel().getSelectedIndex();
        RegexSource regexSource = this.regexSourceListView.getSelectionModel().getSelectedItem();
        if (regexSource != null) {
            NamedRegexSource namedRegexSource = Server.getServer().convertToNamedRegexSource(regexSource);
            this.label.setText(Objects.requireNonNull(namedRegexSource).getTitle());
            this.regexSourceListView.getItems().set(index, namedRegexSource);
        } else {
            this.label.setText("No regex source selected");
        }
    }
}
