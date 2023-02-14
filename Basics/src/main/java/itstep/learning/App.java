package itstep.learning;

import com.google.inject.Guice;
import itstep.learning.db.DbDemo;
import itstep.learning.files.*;
import itstep.learning.ioc.AppModule;
import itstep.learning.ioc.Starter;
import itstep.learning.oop.*;
import itstep.learning.threads.CookDirector;
import itstep.learning.threads.Discriminant;
import itstep.learning.threads.FastBreakfastCook;
import itstep.learning.threads.ICookOfBreakfast;

import java.io.File;
import java.text.ParseException;
import java.util.Scanner;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        new Discriminant().calculate(2,3, 1);
    }

    public static void threads_hw1(String[] args) {
        FastBreakfastCook cook = new FastBreakfastCook();
        CookDirector director = new CookDirector(cook);
        director.MakeFastBreakfast();

        System.out.println(cook.getResult().toString());
    }

    public static void ioc_cw_and_hw1(String[] args) {
        Guice
                .createInjector(new AppModule())
                .getInstance(Starter.class)
                .run();
    }

    public static void db_hw1(String[] args) {
        Scanner in = new Scanner(System.in);

        DbDemo db = new DbDemo();
        db.Connection();
        System.out.println("---------- All Rows ----------");
        db.showAllRows();
        System.out.print("\nEnter string for search: ");
        String in_string = in.nextLine();
        System.out.println("---------- Rows By String ----------");
        db.selectRowsByString(in_string);
        System.out.print("\nEnter int for search: ");
        int in_number = in.nextInt();
        System.out.println("---------- Rows By Int ----------");
        db.selectRowsByInt(in_number);
    }

    public static void files_hw1(String[] args) { // files homework 1
        RandFileGenN1 generator = new RandFileGenN1();
        generator.GenFile();
        File file = generator.getFile();

        LongestLineFinder finder = new LongestLineFinder();
        finder.Find(file);
        CreatedResult result = finder.GetResult();

        System.out.println(result);
    }

    public static void files_cw1(String[] args) {
        new IoDemo().run();
        new DirDemo().run();
    }

    public static void oop(String[] args) {
        Library library = new Library();

        library.add(new Book("Knuth", "Art of programming"));  // Полиморфизм -
        library.add(new Book("Shevchenko", "Kobzar"));         // разные реализации
        library.add(new Journal(10, "ArgC & ArgV"));           // (Book, Journal)
        library.add(new Journal(5, "Nature"));                 // Одного интерфейса (Literature)
        try {
            library.add(new Newspaper("26.06.2022", "The New York Times"));
            library.add(new Newspaper("10.01.2023", "The Daily News"));
            library.add(new Comics("Marvel", 1, "13.09.2022"));
            library.add(new Hologram("Gold apple", "31.01.2023"));
        } catch (ParseException e) {
            System.out.println("Date parse exception");
        }
        library.add(new AudioBook("Kobzar. Shevchenko", "SuperSound Studio"));

        System.out.println("----------Funds----------");
        library.printFunds();
        System.out.println("\n---------Played---------");
        library.playAll();
        System.out.println("\n--------Presented--------");
        library.toPresentAll();
    }
}
