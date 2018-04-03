package logic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;


public class WordsList extends Observable {

    private HashMap<String, Word> stringWordsMap;


    public WordsList(HashMap<String, Word> stringWordsMap) {
        this.stringWordsMap = stringWordsMap;
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

    public void setPrimaryMeaning(String word, int meaning){
        if (this.stringWordsMap.get(word) != null) {
            this.stringWordsMap.get(word).setPrimaryMeaningIndex(meaning);
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
