 /**
 *  Třída App -
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


    public App() {

        String sourceText = readFile("sourceFile.txt");
        paragraph = new Paragraph(sourceText);

        HashMap<String, Word> stringWordHashMap = paragraph.getParagraphStringWordMap();

        wordsList = new WordsList(stringWordHashMap);


    }

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

    public Paragraph getParagraph() {
        return paragraph;
    }


    public WordsList getWordsList() {
        return wordsList;
    }

}
