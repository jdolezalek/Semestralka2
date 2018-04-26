/**
 *  T��da WordsList -
 *@author     Dole��lek Jan, Kalensk� �t�p�n, �orf Filip
 *@version    1.0      
 *@created    LS 2017/2018
 */

package logic;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;


public class WordsList extends Observable {

    private HashMap<String, Word> stringWordsMap;


    public WordsList(HashMap<String, Word> stringWordsMap) {
        this.stringWordsMap = stringWordsMap;

        //add word meanings into stringWordsMap from json, if any exists
        this.setWordsFromJSON();

    }

    private void setWordsFromJSON() {

        JSONParser parser = new JSONParser();

        try {
            Object obj = parser.parse(new FileReader("data.json"));
            JSONObject jsonObject = (JSONObject) obj;
            JSONObject words = (JSONObject) jsonObject.get("words");

            for (Object word : words.keySet()) {

                if (stringWordsMap.containsKey(word)) {

                    JSONArray meanings = (JSONArray) words.get(word);

                    for (Object meaning : meanings) {

                        stringWordsMap.get(word).addMeaningToWord(meaning.toString());

                    }
                }

            }


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public HashMap<String, Word> getStringWordsMap() {
        return this.stringWordsMap;
    }

    public void addMeaningToWord(String word, String meaning) {
        stringWordsMap.get(word).addMeaningToWord(meaning);

        notifyController();
    }

    public Word getWord(String word) {
        return stringWordsMap.getOrDefault(word, null);

    }

    public void setPrimaryMeaningIndex(String word, int meaning) {
        if (this.stringWordsMap.get(word) != null) {
            this.stringWordsMap.get(word).setPrimaryMeaningIndex(meaning);
        }
    }

    public void setPrimaryMeaning(String word, String meaning) {
        if (this.stringWordsMap.get(word) != null) {
            this.stringWordsMap.get(word).setPrimaryMeaning(meaning);
        }
    }

    public ArrayList<String> getWordMeanings(String word) {
        if (this.stringWordsMap.get(word) != null) {
            return this.stringWordsMap.get(word).getMeanings();
        } else {
            return new ArrayList<>();
        }
    }

    private void notifyController() {
        this.setChanged();
        this.notifyObservers();
    }


}
