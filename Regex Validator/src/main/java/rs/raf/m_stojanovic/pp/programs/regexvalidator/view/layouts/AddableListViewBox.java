package rs.raf.m_stojanovic.pp.programs.regexvalidator.view.layouts;

import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import rs.raf.m_stojanovic.pp.programs.regexvalidator.model.UsableRegexSource;

import java.util.function.Function;

public class AddableListViewBox extends VBox {

    private static final Function<Boolean, String> GOOD_BAD_TO_COLOR_MAPPER = p -> p ? "green" : "red";

    private final UsableRegexSource usableRegexSource;

    private final boolean good;

    private final ListView<String> listView;

    private final TextField textField;

    private final Button btAdd = new Button("Add new item");

    public AddableListViewBox(UsableRegexSource usableRegexSource, boolean good, ListView<String> listView, TextField textField) {
        super(10);
        this.usableRegexSource = usableRegexSource;
        this.good = good;
        this.listView = listView;
        this.textField = textField;
        this.btAdd.setOnAction(e -> {
            String item = AddableListViewBox.this.textField.getText();
            AddableListViewBox.this.listView.getItems().clear();
            if (AddableListViewBox.this.good) {
                AddableListViewBox.this.usableRegexSource.getGoods().add(item);
                AddableListViewBox.this.listView.setItems(FXCollections.observableArrayList(
                        AddableListViewBox.this.usableRegexSource.getGoods()));
            } else {
                AddableListViewBox.this.usableRegexSource.getBads().add(item);
                AddableListViewBox.this.listView.setItems(FXCollections.observableArrayList(
                        AddableListViewBox.this.usableRegexSource.getBads()));
            }
            AddableListViewBox.this.textField.setText("");
        });
        super.getChildren().addAll(new Label("Here are " + (good ? "good" : "bad") + " entries"),
                new Label("All entries in the list below should be colored "
                        + GOOD_BAD_TO_COLOR_MAPPER.apply(good)),
                this.listView, this.innerHBox());
        super.setAlignment(Pos.CENTER);
        super.setPadding(new Insets(10));
    }

    private HBox innerHBox() {
        HBox hbox = new HBox(10, this.textField, this.btAdd);
        hbox.setAlignment(Pos.CENTER);
        hbox.setPadding(new Insets(10));
        return hbox;
    }
}
