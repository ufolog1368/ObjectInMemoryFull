package by.jis4.komarov.bean;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TVTest {
    TV tv;

    @Before
    public void setUp(){
        tv = new TV(3, 20, "LG", true);
    }

    @Test
    public void switchChanellUp() {
        tv.switchChanellUp();

        int expected = 4;
        int actual = tv.getChannel();
        assertEquals(expected, actual);
    }

    @Test
    public void switchChanellDown() {
        tv.switchChanellDown();

        int expected = 2;
        int actual = tv.getChannel();
        assertEquals(expected, actual);
    }

    @Test
    public void increaseVolume() {
        tv.increaseVolume();

        int expected = 21;
        int actual = tv.getVolume();
        assertEquals(expected, actual);
    }

    @Test
    public void decreaseVolume() {
        tv.decreaseVolume();

        int expected = 19;
        int actual = tv.getVolume();
        assertEquals(expected, actual);
    }

    @Test
    public void turnOnTv() {
        tv.turnOnTv();

        boolean expected = true;
        boolean actual = tv.isTurnTV();
        assertEquals(expected, actual);
    }

    @Test
    public void turnOffTv() {
        tv.turnOffTv();

        boolean expected = false;
        boolean actual = tv.isTurnTV();
        assertEquals(expected, actual);
    }

    @Test
    public void getChannel() {
        tv.setChannel(5);

        int expected = 5;
        int actual = tv.getChannel();
        assertEquals(expected, actual);
    }

    @Test
    public void getVolume() {
        tv.setVolume(54);

        int expected = 54;
        int actual = tv.getVolume();
        assertEquals(expected, actual);
    }

    @Test
    public void getBrand() {
        tv.setBrand("Zombicase");

        String expected = "Zombicase";
        String actual = tv.getBrand();
        assertEquals(expected, actual);
    }

    @Test
    public void isTurnTV() {
        tv.setTurnTV(true);

        boolean expected = true;
        boolean actual = tv.isTurnTV();
        assertEquals(expected, actual);
    }

    @Test
    public void testEquals() {
        var tv2 = new TV(3, 20, "LG", true);

        boolean expected = true;
        boolean actual = tv.equals(tv2);
        assertEquals(expected, actual);


    }

    @Test
    public void testHashCode() {

        long expected = 1108582;
        long actual = tv.hashCode();
        assertEquals(expected, actual);


    }

    @Test
    public void testToString() {

     String expected = "TV{channel=3, volume=20, brand='LG', turnTV=true}";
     String actual = tv.toString();
     assertEquals(expected, actual);
    }
}