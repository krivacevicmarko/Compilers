package rs.raf.m_stojanovic.pp.programs.regexvalidator.view.lists;

import javafx.collections.ObservableList;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.util.Callback;

import java.util.function.Predicate;

public class PredicatedListView extends ListView<String> {

    private Predicate<String> predicate = s -> false;

    private final TextField textField;

    public PredicatedListView(TextField textField, ObservableList<String> items) {
        super(items);
        this.textField = textField;
        super.setCellFactory(new Callback<>() {
            @Override
            public ListCell<String> call(ListView<String> param) {
                return new ListCell<>() {
                    @Override
                    protected void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        if (item == null || empty) {
                            super.setGraphic(null);
                            super.setText(null);
                            super.setStyle(null);
                            return;
                        }
                        super.setText(item);
                        PredicatedListView.this.predicate
                                = s -> s.matches(PredicatedListView.this.textField.getText());
                        if (PredicatedListView.this.predicate.test(item))
                            super.setStyle("-fx-control-inner-background: green;");
                        else
                            super.setStyle("-fx-control-inner-background: red;");
                    }
                };
            }
        });
    }
}
