package rs.raf.m_stojanovic.pp.programs.regexvalidator.view;

import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import rs.raf.m_stojanovic.pp.programs.regexvalidator.controller.RegexSourceSelectControl;
import rs.raf.m_stojanovic.pp.programs.regexvalidator.controller.StartControl;
import rs.raf.m_stojanovic.pp.programs.regexvalidator.model.RegexSource;
import rs.raf.m_stojanovic.pp.programs.regexvalidator.model.base.Server;

public class ChooseRegexSourceView extends Stage {

    public static ChooseRegexSourceView chooseRegexSourceView;

    public static ChooseRegexSourceView getChooseRegexSourceView() {
        if (chooseRegexSourceView == null) {
            synchronized (ChooseRegexSourceView.class) {
                if (chooseRegexSourceView == null)
                    chooseRegexSourceView = new ChooseRegexSourceView();
            }
        }
        return chooseRegexSourceView;
    }

    private final VBox root = new VBox(10);

    private final ListView<RegexSource> lvRegexSources = new ListView<>(
            FXCollections.observableArrayList(Server.getServer().getRegexSources()));

    private final Label lbRegexSourceTitle = new Label("No regex source selected");

    private final Button btGo = new Button("Start");

    private ChooseRegexSourceView() {
        super.setTitle("Choose source");
        this.lvRegexSources.setOnMouseClicked(
                new RegexSourceSelectControl(this.lvRegexSources, this.lbRegexSourceTitle));
        this.btGo.setOnAction(new StartControl(this, this.lvRegexSources));
        this.root.getChildren().addAll(this.lvRegexSources, this.lbRegexSourceTitle, this.btGo);
        this.root.setAlignment(Pos.CENTER);
        this.root.setPadding(new Insets(10));
        super.setScene(new Scene(this.root));
    }

}
