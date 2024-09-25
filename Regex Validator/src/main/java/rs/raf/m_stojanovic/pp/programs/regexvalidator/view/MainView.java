package rs.raf.m_stojanovic.pp.programs.regexvalidator.view;

import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import rs.raf.m_stojanovic.pp.programs.regexvalidator.controller.CheckRegexControl;
import rs.raf.m_stojanovic.pp.programs.regexvalidator.model.UsableRegexSource;
import rs.raf.m_stojanovic.pp.programs.regexvalidator.model.utility.FileUtils;
import rs.raf.m_stojanovic.pp.programs.regexvalidator.view.layouts.AddableListViewBox;
import rs.raf.m_stojanovic.pp.programs.regexvalidator.view.lists.PredicatedListView;

import java.util.Arrays;
import java.util.stream.Collectors;

public class MainView extends Stage {

    private final UsableRegexSource regexSource;

    private final BorderPane root = new BorderPane();

    private final PredicatedListView plvGood, plvBad;

    private final TextField tfRegexInput = new TextField(),
                            tfAddGood = new TextField(),
                            tfAddBad = new TextField();

    private final Button btCheck = new Button("Check regex"),
                        btSave = new Button("Save changes");

    public MainView(UsableRegexSource regexSource) {
        this.regexSource = regexSource;
        this.plvGood = new PredicatedListView(this.tfRegexInput,
                FXCollections.observableArrayList(this.regexSource.getGoods()));
        this.plvBad = new PredicatedListView(this.tfRegexInput,
                FXCollections.observableArrayList(this.regexSource.getBads()));
        this.btCheck.setOnAction(new CheckRegexControl(this.plvGood, this.plvBad));
        this.btSave.setOnAction(e -> FileUtils.update(MainView.this.regexSource));
        super.setTitle(this.regexSource.getTitle());
        this.root.setCenter(this.centralBox());
        this.root.setLeft(new AddableListViewBox(this.regexSource, true, this.plvGood, this.tfAddGood));
        this.root.setRight(new AddableListViewBox(this.regexSource, false, this.plvBad, this.tfAddBad));
        this.root.setTop(this.vbox(
                Arrays.stream(this.regexSource.getComment().split("\n"))
                        .map(Label::new)
                        .toArray(Label[]::new)));
        this.root.setBottom(this.hbox(this.btSave));
        super.setScene(new Scene(this.root));
    }

    private HBox hbox(Node... nodes) {
        HBox hbox = new HBox(10, nodes);
        hbox.setAlignment(Pos.CENTER);
        hbox.setPadding(new Insets(10));
        return hbox;
    }

    private VBox vbox(Node... nodes) {
        VBox vbox = new VBox(10, nodes);
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(10));
        return vbox;
    }

    private VBox centralBox() {
        VBox vbox = new VBox(10, this.tfRegexInput, this.btCheck);
        vbox.setPadding(new Insets(10));
        vbox.setAlignment(Pos.CENTER);
        return vbox;
    }

}
