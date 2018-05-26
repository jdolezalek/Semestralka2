package logic;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.HashMap;


/*******************************************************************************
 * Testovací třída sloužíci ke komplexnímu otestování třídy ... 
 *
 * @author    https://github.com/jdolezalek/Semestralka2
 * @version   1.00.000
 */

public class WordsListTest {

	//== KONSTRUKTORY A TOVÁRNÍ METODY =========================================
    //-- Testovací třída vystačí s prázdným implicitním konstruktorem ----------

    /***************************************************************************
     * Inicializace předcházející spuštění každého testu a připravující tzv.
     * přípravek (fixture), což je sada objektů, s nimiž budou testy pracovat.
     */
    @Before
    public void setUp()
    {
    }

    /***************************************************************************
     * Úklid po testu - tato metoda se spustí po vykonání každého testu.
     */
    @After
    public void tearDown()
    {
    }

    //== VLASTNÍ TESTY =========================================================
     /**
     * testuje, zda stringWordsMap neni prazdna pokud přidáme slovo 
     * 
     */
	
    @Test
    public void testWordsList()
    {
    	String content = "slovo";
    	Word word = new Word(content);
    	HashMap stringWordsMap= new HashMap<String, Word> ();
    	WordsList wordsList = new WordsList(stringWordsMap);
    	stringWordsMap.put(word,content);
    	assertEquals(false,wordsList.getStringWordsMap().isEmpty());
    }
    
    
}
