package logic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;


public class WordsList extends Observable{

    private HashMap<String, Word> stringWordsMap;


    public WordsList(HashMap<String, Word> stringWordsMap) {
        this.stringWordsMap = stringWordsMap;
    }

    public HashMap<String, Word> getStringWordsMap(){
        return this.stringWordsMap;
    }

   public void addMeaningToWord(String word, String meaning) {
      stringWordsMap.get(word).addMeaningToWord(meaning);

      this.setChanged();
      this.notifyObservers();
   }

   public Word getWord(String word) {
        return stringWordsMap.getOrDefault(word, null);

   }

   public ArrayList<String> getWordMeanings(String word) {
        return this.stringWordsMap.get(word).getMeanings();
   }



}
