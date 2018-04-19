# Strojové učení významu slov ( 2. semestrální úloha)
## Tým rytířů programátorského stolu
### Doležálek Jan, Kalenský Štěpán, Šorf Filip
<br/>
<br/>

## Zadání

### Strojové učení významu slov ( 2-3 řešitelé)
Aplikace je frontend pro trénování významů slov v textech. Uživatel čte text v rozsahu jednoho odstavce a vybírá správné významy jednotlivých slov. Aplikace zaznamenává volby uživatele, tak aby bylo možné je zpětně přiřadit ke správným slovům.

## Úkoly týmu
|     Jméno     |                Návrh řešení úkol                    |                  Implementace úkol             |
| :-----------: |:---------------------------------------------------:| :---------------------------------------------:|
| Doležálek Jan | logika aplikace ; class diagram ; struktura souborů |                  class Word                    |
|Kalenský Štěpán|  use case diagram ; slovní popis use case diagramu  |                class Paragraph                 |
|   Šorf Filip  |   návrh uživatelského rozhraní ; týmové konvence    | class Wordslist ; class App ; class Controller |
|       Tým     |                                                     |                integrace ; class Main          |

## Use case diagram


## Popis případů užití

#### Zadání odstavce

#### Ověřit výskyt Stringu

#### Vypsat významy do listu

#### Přidání významu ke slovu

#### Zvýraznění významu

#### Přiřadit význam k textu

#### Zvýraznění slova

#### Exportovat data


## Class diagram

## Struktura souborů
Složka se vstupním souborem txt uložena na filesystému
V aplikaci interní JSON pro ukládání všech významů slov vložených uživateli
Export textu s uživatelem vybranými významy k daným slovům se exportuje ve formátu JSON do uživatelem vybrané složky na filesystému

## Návrh UI

#### Prvotní návrh

#### Provedení

## Konvence

Konvence pro psaní a odevzdávání programů v Javě
1. Pojmenovávání tříd, proměnných, metod, ...

1.1 Pro identifikátory (tříd, metod, proměnných, ...) používejte jména popisující jejich význam. Vyhýbejte se zkratkám. Jména by neměla být krátká (minimálně 3 znaky) ani příliš dlouhá (do 16 znaků).

1.2 Jména tříd začínají velkým písmenem. Pokud se použije více slov, všechna začínají velkým písmenem. Pro označení třídy se obvykle používá podstatné jména v jednotném čísle, které bývá doplněno o přívlastky (např. třídy Student, SeznamStudentu).

1.3 Jména metod, proměnných, formálních parametrů metod začínají malým písmenem. Pokud jméno obsahuje více slov, druhé a další začínají velkým písmenem.

1.4 Názvy konstant se píší celé velkými písmeny, v případě více slov se jednotlivá slova oddělují znakem podtržení, např. MAXIMALNI_POCET.
2. Formátování

2.1 Na jednom řádku by měl být jeden příkaz, deklarace jedné proměnné.

2.2 Obsah bloku odsaďte vždy o 3 či 4 mezery. V rámci jednoho bloku by měly být všechny příkazy odsazeny stejně.

2.2 Otevírací závorka bloku je obvykle na konci řádku, uzavírací samostatná na řádku. Např.

     public static void main(String[] args) {
         int scitanec1 = 5;
         int scitanec2 = 2;
         System.out.println("Soucet je: " + (scitanec1 + scitanec2));
     }

     while (''podmínka'') {
 	''příkazy''
     }

     if (''podmínka'') {
 	''příkazy''
     }
     else {
 	''příkazy''
     }

2.3 V řídících strukturách vždy používejte složené závorky pro bloky a to i v případě, že v bloku je pouze jeden příkaz.

2.4 Používejte mezeru před otevírací závorkou a okolo operátorů.
3. Dokumentace, komentáře

3.1 Na začátku každé třídy uveďte:

- stručný popis třídy,
- autora či autory,
- označení verze (pořadové číslo či datum poslední změny).

Příklad:

 /**
 *  Třída SeznamAkci - obsahuje seznam přípustných příkazů adventury.
 *  Používá se pro rozpoznávání jednotlivých příkazů.
 *
 *  Tato třída je součástí jednoduché textové hry.
 *
 *@author     Michael Kolling, Lubos Pavlicek, Jarmila Pavlickova
 *@version    4.0
 *@created    září 2006
 */

3.2 Před každou metodou by měl být její popis doplněný o popis významu jednotlivých parametrů a návratových hodnot. Příklad:

 /**
 * Metoda hledá nejvyšší hodnotu (maximum) v poli celých čísel.
 *
 *@param pole Pole celých čísel, které se bude prohledávat
 *@return Vrací celé číslo s nejvyšší hodnotou
 */

3.3 Popisy tříd a metod by měly být ve formátu vhodném pro javadoc.

3.4 Vlastní kód doplňte o komentář pouze v nezbytných případech. Předpokládejte, že čtenář zdrojového textu zná Javu.

Pro kontrolu konvencí můžete použít program PMD.

*Zdroj : https://java.vse.cz/4it101/Konvence*


