/**
 *  Třída App - Hlavní třída projektu, 
 *  která představuje jednoduchou aplikaci na ukládání významu slov.
 *@author     Doležálek Jan, Kalenský Štěpán, Šorf Filip
 *@version    1.0      
 *@created    LS 2017/2018
 */


package logic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class App {

    private Paragraph paragraph;
    private WordsList wordsList;


/**
 * Metoda, která načítá zdrojový soubor pro odstavec a vytváří odstavec v aplikaci.
 * Vytváří také pravý sloupec s významy slova.
 */

    public App() {

        String sourceText = readFile("sourceFile.txt");
        paragraph = new Paragraph(sourceText);

        HashMap<String, Word> stringWordHashMap = paragraph.getParagraphStringWordMap();

        wordsList = new WordsList(stringWordHashMap);


    }
    /**
     * Metoda, která čte text z načteného souboru.
     * 
     * @param filename - název souboru včetně cesty k němu
     * @return vrátí načtený text
     */
    private String readFile(String filename) {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(filename));
            String line;
            while ((line = br.readLine()) != null) {
                if (sb.length() > 0) {
                    sb.append("\n");
                }
                sb.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        return sb.toString();
    }

/**
 * Metoda vrací třídu paragraf. 
 * @return paragraf - třída paragraf 
 */
    public Paragraph getParagraph() {
        return paragraph;
    }


/**
 * Metoda vrací třídu list s významy
 * @return list s významy - třída wordsList
 */
    public WordsList getWordsList() {
        return wordsList;
    }

}
