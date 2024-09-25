package rs.raf.m_stojanovic.pp.programs.regexvalidator;

import javafx.application.Application;
import javafx.stage.Stage;
import rs.raf.m_stojanovic.pp.programs.regexvalidator.model.utility.FileUtils;
import rs.raf.m_stojanovic.pp.programs.regexvalidator.view.ChooseRegexSourceView;

public class App extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FileUtils.listAll();
        ChooseRegexSourceView.getChooseRegexSourceView().show();
    }
}
