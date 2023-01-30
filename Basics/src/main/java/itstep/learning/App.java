package itstep.learning;

import itstep.learning.oop.Book;
import itstep.learning.oop.Journal;
import itstep.learning.oop.Library;
import itstep.learning.oop.Newspaper;
import itstep.learning.oop.Date;

/**
 * Hello world!
 *
 */
public class App  {
    public static void main( String[] args ) {
        Library library = new Library() ;

        library.add( new Book( "Knuth", "Art of programming" ) ) ;  // Полиморфизм -
        library.add( new Book( "Shevchenko", "Kobzar" ) ) ;         // разные реализации
        library.add( new Journal( 10, "ArgC & ArgV" ) ) ;           // (Book, Journal)
        library.add( new Journal( 5, "Nature" ) ) ;                 // Одного интерфейса (Literature)
        library.add( new Newspaper( new Date(2022, 6, 26), "The New York Times"));
        library.add( new Newspaper( new Date( 2023, 1, 10), "The Daily News"));

        library.printFunds() ;
    }
}
