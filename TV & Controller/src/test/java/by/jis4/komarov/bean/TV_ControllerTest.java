package by.jis4.komarov.bean;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TV_ControllerTest {
    TV_Controller tv_controller;

    @Before
    public void setUp(){
        tv_controller = new TV_Controller(3, 20, "LG", true);
    }

    @Test
    public void isToPlugToTVVolumeDown() {
        tv_controller.decreaseVolume();

        int expected = 19;
        int actual = tv_controller.getVolume();
        assertEquals(expected, actual);
    }

    @Test
    public void isToPlugToTVTrue() {
        tv_controller.setToPlugToTV(tv_controller.turnOnTv());

        boolean expected = true;
        boolean actual = tv_controller.isToPlugToTV();
        assertEquals(expected, actual);
    }

    @Test
    public void isToPlugToTVFalse() {
        tv_controller.setToPlugToTV(tv_controller.turnOffTv());

        boolean expected = false;
        boolean actual = tv_controller.isToPlugToTV();
        assertEquals(expected, actual);
    }

    @Test
    public void testToString() {
        System.out.println("tv_controller.toString() = " + tv_controller.toString());

    }
}