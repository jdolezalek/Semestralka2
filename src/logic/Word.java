/**
 *  Třída Word - reprezentuje slovo jako jednotlivý článek, se kterým se dále pracuje a
 * ke kterému se přiřazují významy.
 *@author     Doležálek Jan, Kalenský Štěpán, Šorf Filip
 *@version    1.0      
 *@created    LS 2017/2018
 */

package logic;


import java.util.ArrayList;

public class Word {

    private String wordString;
    private ArrayList<String> meanings;

    //int nemůže být null -> defaultně je 0!! pro porovnávání indexu v listView by tak byla označena nultá položka v seznamu ,
    //i když by nebyla nasetována hodnota primaryMeaning.
    private int primaryMeaningIndex = 9999;
    private String primaryMeaning = "";

/**
 * Metoda, která pracuje se slovem z textu a vytváří k němu list přiřazených významů.
 * @param word - slovo z textu
 */
    public Word(String word) {
        this.wordString = word;
        this.meanings = new ArrayList<>();
    }
/**
 * Metoda, která přidá význam ke slovu z textu, pokud už není přidán.
 * @param meaning -  význam připraven k přiřazení slovu
 */
    public void addMeaningToWord(String meaning) {
       if (!this.meanings.contains(meaning)) {
           this.meanings.add(meaning);
       }
    }
/**
 * Metoda vrací list významů slova.
 * @return meanings - významy slova.
 */
    public ArrayList<String> getMeanings() {
        return meanings;
    }
/**
 * Metoda nastaví index významům v listu.
 * @param primaryMeaningIndex - index významu v listu
 */
    public void setPrimaryMeaningIndex(int primaryMeaningIndex) {
        this.primaryMeaningIndex = primaryMeaningIndex;
    }
/**
 * Metoda nastaví význam. 
 * @param primaryMeaning - význam slova.
 */
    public void setPrimaryMeaning(String primaryMeaning) {
        this.primaryMeaning = primaryMeaning;
    }
/**
 * Metoda vrací index významů v listu.
 * @return primaryMeaningIndex - index významu v listu.
 */
    public int getPrimaryMeaningIndex() {
        return primaryMeaningIndex;
    }
/**
 * Metda vrací význam.
 * @return primaryMeaning - význam slova.
 */
    public String getPrimaryMeaning() {
        return primaryMeaning;
    }



}
