package logic;


import java.util.ArrayList;

public class Word {

    private String wordString;
    private ArrayList<String> meanings;

    public Word(String word) {
        this.wordString = word;
        this.meanings = new ArrayList<>();
    }

    public void addMeaningToWord(String meaning) {
        this.meanings.add(meaning);
    }

    public ArrayList<String> getMeanings() {
        return meanings;
    }



}
