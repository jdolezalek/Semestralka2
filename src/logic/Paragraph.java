/**
 *  Třída Paragraph - reprezentuje v aplikaci odstavec, ve kterém je zobrazen načtený text.
 *  Zároveň rozpracovává text do jednotlivých stringů tak, aby se s těmi slovy dalo pracovat jednotlivě.
 *@author     Doležálek Jan, Kalenský Štěpán, Šorf Filip
 *@version    1.0      
 *@created    LS 2017/2018
 */
package logic;

import java.util.HashMap;

public class Paragraph {

    private String paragraphText;
    private HashMap<String, Word> paragraphStringWordMap;

/**
 * Metoda pro uživatele zobrazuje načtený text
 *  a pomocí jiné metody rozseká jednotlivá slova na jednotlivé stringy.
 * @param text - text z načteného souboru
 */
    public Paragraph(String text) {

        this.paragraphText = text;
        this.parseTextToWordObjects(text);

    }
/**
 * Metoda, která rozseká daný text na jednotlivé stringy, tím že z nich vytváří HashMapu.
 * @param text - text z načteného souboru
 */

    public void parseTextToWordObjects(String text) {
        HashMap<String, Word> hashMap = new HashMap<>();

        String[] words = text.split("\\s+");

        for (String word : words) {
            String trimmed;
            trimmed = word.replaceAll("[\\.\\,\\=\\!\\?\\/\\_\0-9]","");//("[\\.,\\,]", "");
            hashMap.put(trimmed, new Word(trimmed));
            while (hashMap.containsKey("")) {
				hashMap.remove("");
			}
        }
        this.paragraphStringWordMap = hashMap;

    }
/**
 * Metoda vrací text v paragrafu.
 * @return paragraphText - text v paragrafu
 */
    public String getParagraphText() {
        return paragraphText;
    }
/**
 * Metoda vrací hashMapu jednotlivých stringů
 * @return paragraphStringWordMap - hashMapa slov jako jednotlivých stringů
 */
    public HashMap<String, Word> getParagraphStringWordMap() {
        return paragraphStringWordMap;
    }

}
