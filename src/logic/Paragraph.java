package logic;

import java.util.HashMap;

public class Paragraph {

    private String paragraphText;
    private HashMap<String, Word> paragraphStringWordMap;


    public Paragraph(String text) {

        this.paragraphText = text;
        this.parseTextToWordObjects(text);

    }


    public void parseTextToWordObjects(String text) {
        HashMap<String, Word> hashMap = new HashMap<>();

        String[] words = text.split("\\s+");

        for (String word : words) {
            String trimmed;
            trimmed = word.replaceAll("[\\.,\\,]", "");
            hashMap.put(trimmed, new Word(trimmed));

        }
        this.paragraphStringWordMap = hashMap;

    }

    public String getParagraphText() {
        return paragraphText;
    }

    public HashMap<String, Word> getParagraphStringWordMap() {
        return paragraphStringWordMap;
    }

}
