/**
 *  T��da Word -
 *@author     Dole��lek Jan, Kalensk� �t�p�n, �orf Filip
 *@version    1.0      
 *@created    LS 2017/2018
 */

package logic;


import java.util.ArrayList;

public class Word {

    private String wordString;
    private ArrayList<String> meanings;

    //int nemuze byt null -> defaultne je 0!! pro porovnavani indexu v listView by tak byla oznacena 0 polozka v seznamu i kdyz byt nebyla nasetovana hodnota primaryMeaning
    private int primaryMeaningIndex = 9999;

    private String primaryMeaning = "";


    public Word(String word) {
        this.wordString = word;
        this.meanings = new ArrayList<>();
    }

    public void addMeaningToWord(String meaning) {
       if (!this.meanings.contains(meaning)) {
           this.meanings.add(meaning);
       }
    }

    public ArrayList<String> getMeanings() {
        return meanings;
    }

    public void setPrimaryMeaningIndex(int primaryMeaningIndex) {
        this.primaryMeaningIndex = primaryMeaningIndex;
    }

    public void setPrimaryMeaning(String primaryMeaning) {
        this.primaryMeaning = primaryMeaning;
    }

    public int getPrimaryMeaningIndex() {
        return primaryMeaningIndex;
    }

    public String getPrimaryMeaning() {
        return primaryMeaning;
    }



}
