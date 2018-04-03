package main;

import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;
import logic.App;

import java.util.*;

import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import logic.Word;
import logic.WordsList;

public class Controller extends GridPane implements Observer {


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
    @FXML
    private javafx.scene.control.Label wordLabel;

    private WordsList wordsList;

    public void init(App app) {

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

            highlightPrimaryMeaningInListView(validateInput.getText());

            wordLabel.setText(validateInput.getText());



        } else {
            System.out.println("nope");
        }
    }

    @FXML
    private void addMeaning() {
        String meaning = newValueInput.getText();
        String word = wordLabel.getText();

        wordsList.addMeaningToWord(word, meaning);

        newValueInput.clear();
    }

    @FXML
    private void wordSelected() {
        if (paragraphArea.getSelectedText().length() > 0) {

            String selectedWord = paragraphArea.getSelectedText();
            String trimmed = selectedWord.trim();


            meaningsListView.getItems().clear();
            ArrayList<String> meanings = wordsList.getWordMeanings(trimmed);
            for (String meaning : meanings) {
                meaningsListView.getItems().add(meaning);
            }

            highlightPrimaryMeaningInListView(trimmed);

            wordLabel.setText(trimmed);

        }
    }

    @FXML
    private void setPrimaryMeaning() {
        System.out.println(meaningsListView.getSelectionModel().getSelectedItem());
        if (meaningsListView.getSelectionModel().getSelectedItem() != null) {

            Integer primaryMeaningIndex = meaningsListView.getSelectionModel().getSelectedIndex();

            String word = wordLabel.getText();

            wordsList.setPrimaryMeaning(word, primaryMeaningIndex);
        }
    }

    @FXML
    private void export(){
        System.out.println("eport");
    }


    @Override
    public void update(Observable o, Object arg) {
        meaningsListView.getItems().clear();
        ArrayList<String> meanings = wordsList.getWordMeanings(validateInput.getText());
        for (String meaning : meanings) {
            meaningsListView.getItems().add(meaning);
        }

        highlightPrimaryMeaningInListView(wordLabel.getText());

    }

    private void highlightPrimaryMeaningInListView(String wordString){
        Word word = wordsList.getWord(wordString);
        int primaryMeaningIndex = word.getPrimaryMeaningIndex();
        if (primaryMeaningIndex != 9999) {
            meaningsListView.getSelectionModel().select(primaryMeaningIndex);
        }
    }

}
