package logic;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


/*******************************************************************************
 * Testovací třída sloužíci ke komplexnímu otestování třídy ... 
 *
 * @author    https://github.com/jdolezalek/Semestralka2
 * @version   1.00.000
 */

public class WordTest {

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
     * testuje, zda se přidaný význam objevuje v listu
     */
    
    @Test
    public void testAddMeaningToWord()
    {
    	String slovo = "test";
    	String meaning = "význam";
    	Word word = new Word(slovo);
    	word.addMeaningToWord(meaning);
    	assertEquals(true,word.getMeanings().contains(meaning));
    	
    	
    }
}
