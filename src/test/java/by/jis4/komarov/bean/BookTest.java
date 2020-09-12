package by.jis4.komarov.bean;


import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class BookTest {

    Book book;

    @Before
    public void setUp(){
        book = new Book();
    }

    @Test
    public void testGetAutor() {
        book.setAutor("Тармашев С.С.");

        String expected = "Тармашев С.С.";
        String actual = book.getAutor();
       assertEquals(expected,actual);
    }

    @Test
    public void testTestGetName() {
        book.setName("Древний.Катастрофа");

        String expected = "Древний.Катастрофа";
        String actual = book.getName();
        assertEquals(expected,actual);

    }

    @Test
    public void testGetCountPage() {
        book.setCountPage(384);

        int expected = 384;
        int actual = book.getCountPage();
        assertEquals(expected,actual);
    }

    @Test
    public void testTestEquals() {
        var book1 =new Book();
        var book2 =new Book();
        book1.setAutor("Тармашев С.С.");
        book1.setName("Древний.Катастрофа");
        book1.setCountPage(384);

        book2.setAutor("Тармашев С.С.");
        book2.setName("Древний.Катастрофа");
        book2.setCountPage(384);

        boolean expected = true;
        boolean actual = book1.equals(book2) ;
        assertEquals(expected,actual);


    }

    @Test
    public void testTestHashCode() {
        book.setAutor("Тармашев С.С.");
        book.setName("Древний.Катастрофа");
        book.setCountPage(384);

        long expected = -1769048014;
        long actual = book.hashCode();
        assertEquals(expected, actual);

    }

    @Test
    public void testTestToString() {
        book.setAutor("Тармашев С.С.");
        book.setName("Древний.Катастрофа");
        book.setCountPage(384);

        String expected = "Book{autor='Тармашев С.С.', name='Древний.Катастрофа', countPage=384}";
        String actual = book.toString();
        assertEquals(expected, actual);
    }
}