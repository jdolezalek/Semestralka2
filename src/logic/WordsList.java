/**
 *  Třída WordsList - reprezentuje slova a jejich významy.
 *@author     Doležálek Jan, Kalenský Štěpán, Šorf Filip
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
/**
 * Metoda vytváří mapu slov a významů. Přidává i významy ke slovům z JSONu.
 * @param stringWordsMap - mapa slov a významů
 */
    public WordsList(HashMap<String, Word> stringWordsMap) {
        this.stringWordsMap = stringWordsMap;

        //přidává významy ke slovům do stringWordsMap z JSONu, pakliže některé existují.
        this.setWordsFromJSON();

    }
/**
 * Metoda, která přidává významy slov z JSONu do StringWordMapy.
 */
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
/**
 * Metoda vrací mapu slov a významů
 * @return stringWordsmap - mapa slov a významů.
 */
    public HashMap<String, Word> getStringWordsMap() {
        return this.stringWordsMap;
    }
/**
 * Metoda přidává význam ke slovu.
 * @param word - slovo vyskytující se v textu.
 * @param meaning - význam slova
 */
    public void addMeaningToWord(String word, String meaning) {
        stringWordsMap.get(word).addMeaningToWord(meaning);

        notifyController();
    }
/**
 * Metoda vrací slovo nebo null.
 * @param word - slovo z textu
 * @return word; null - vrátí buď slovo z mapy nebo null
 */
    public Word getWord(String word) {
        return stringWordsMap.getOrDefault(word, null);

    }
/**¨
 * Metoda nastaví index významu ke slovu v listu.
 * @param word - slovo z textu
 * @param meaning - význam
 */
    public void setPrimaryMeaningIndex(String word, int meaning) {
        if (this.stringWordsMap.get(word) != null) {
            this.stringWordsMap.get(word).setPrimaryMeaningIndex(meaning);
        }
    }
/**
 * Metoda nastaví význam slovu.
 * @param word - slovo z textu
 * @param meaning - význam
 */
    public void setPrimaryMeaning(String word, String meaning) {
        if (this.stringWordsMap.get(word) != null) {
            this.stringWordsMap.get(word).setPrimaryMeaning(meaning);
        }
    }
/**
 * Metoda vrací list významů přiřazených ke slovu.
 * @param word - slovo z textu
 * @return ArrayList - list významů přiřazených ke slovu.
 */
    public ArrayList<String> getWordMeanings(String word) {
        if (this.stringWordsMap.get(word) != null) {
            return this.stringWordsMap.get(word).getMeanings();
        } else {
            return new ArrayList<>();
        }
    }
/**
 * Metoda upozorňující Controller.
 */
    private void notifyController() {
        this.setChanged();
        this.notifyObservers();
    }


}
