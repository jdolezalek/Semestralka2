package logic;

import java.util.HashMap;

public class App {

    private Paragraph paragraph;
    private WordsList wordsList;


    public App() {

        paragraph = new Paragraph("Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Maecenas libero. Praesent id justo in neque elementum ultrices. Etiam quis quam. Nullam dapibus fermentum ipsum. Aliquam erat volutpat. Nullam justo enim, consectetuer nec, ullamcorper ac, vestibulum in, elit. Praesent id justo in neque elementum ultrices. Proin mattis lacinia justo. Aliquam in lorem sit amet leo accumsan lacinia. Sed convallis magna eu sem. Duis bibendum, lectus ut viverra rhoncus, dolor nunc faucibus libero, eget facilisis enim ipsum id lacus. Maecenas sollicitudin.");

        String text = paragraph.getParagraphText();
        paragraph.parseTextToWordObjects(text);
        HashMap<String, Word> stringWordHashMap = paragraph.getParagraphStringWordMap();

        wordsList = new WordsList(stringWordHashMap);



    }

    public Paragraph getParagraph() {
        return paragraph;
    }


    public WordsList getWordsList() {
        return wordsList;
    }

}
