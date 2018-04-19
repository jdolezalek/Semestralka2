package main;


import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;

import logic.App;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import logic.Word;
import logic.WordsList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

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
            if (meanings.size() > 0) {
                for (String meaning : meanings) {
                    meaningsListView.getItems().add(meaning);
                }

                highlightPrimaryMeaningInListView(trimmed);
            }
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
    private void export() {

        JSONParser parser = new JSONParser();

        HashMap<String, Word> wordHashMap = wordsList.getStringWordsMap();
        for (String word : wordHashMap.keySet()) {
            ArrayList<String> meaningsArrayList = wordsList.getWordMeanings(word);
            if (meaningsArrayList.size() > 0) {

                try {
                    Object obj = parser.parse(new FileReader("data.json"));
                    JSONObject jsonObject = (JSONObject) obj;
                    JSONObject words = (JSONObject) jsonObject.get("words");

                    //if word is already in json file
                    if (words.containsKey(word)) {
                        JSONArray meanings = (JSONArray) words.get(word);
                        for (String meaning : meaningsArrayList) {
                            //if word in json file already contains that meaning
                            if (!meanings.contains(meaning)) {
                                meanings.add(meaning);
                            }
                        }
                    } else {
                        JSONArray meanings = new JSONArray();
                        for (String meaning : meaningsArrayList) {
                            meanings.add(meaning);
                        }
                        words.put(word, meanings);
                    }

                    //save into json file
                    try (FileWriter file = new FileWriter("data.json")) {
                        file.write(jsonObject.toJSONString());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
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

    private void highlightPrimaryMeaningInListView(String wordString) {
        Word word = wordsList.getWord(wordString);
        int primaryMeaningIndex = word.getPrimaryMeaningIndex();
        if (primaryMeaningIndex != 9999) {
            meaningsListView.getSelectionModel().select(primaryMeaningIndex);
        }
    }

}
