package main;

import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;
import logic.App;

import java.util.*;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import logic.Word;
import logic.WordsList;

import java.awt.*;
import java.util.List;

public class Controller extends GridPane implements Observer {

    private App app;
    @FXML
    private TextArea paragraphArea;
    @FXML
    private TextField validateInput;
    @FXML
    private TextField newValueInput;
    @FXML
    private Button addValue;
    @FXML
    private ListView meaningsListView;

    private WordsList wordsList;

    public void init(App app) {

        this.app = app;
        wordsList = app.getWordsList();

        paragraphArea.setText(app.getParagraph().getParagraphText());

        wordsList.addObserver(this);

        newValueInput.setDisable(true);
        addValue.setDisable(true);

    }

    //todo highlight text in paragraphArea
    @FXML
    private void validate() {
        meaningsListView.getItems().clear();

        if (wordsList.getWord(validateInput.getText()) != null) {

            newValueInput.setDisable(false);
            addValue.setDisable(false);

            ArrayList<String> meanings = wordsList.getWordMeanings(validateInput.getText());

              for (String meaning : meanings) {
                  meaningsListView.getItems().add(meaning);
              }

        } else {
            System.out.println("nope");
        }
    }

    @FXML
    private void addMeaning(){
        String meaning = newValueInput.getText();
        String word = validateInput.getText();

        wordsList.addMeaningToWord(word, meaning);

        newValueInput.clear();
    }

    @FXML
    private void wordSelected(){
        System.out.println(paragraphArea.getSelectedText());
    }



    @Override
    public void update(Observable o, Object arg) {
        meaningsListView.getItems().clear();
        ArrayList<String> meanings = wordsList.getWordMeanings(validateInput.getText());
        for (String meaning : meanings) {
            meaningsListView.getItems().add(meaning);
        }
    }
}
