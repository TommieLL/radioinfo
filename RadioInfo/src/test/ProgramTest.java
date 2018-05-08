package test;

import backend.Program;
import org.junit.Test;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.Buffer;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

/**
 * @author Tommie Lindberg (c15tlg@cs.umu.se)
 * @version 07/04/2018.
 */
public class ProgramTest {
    Program pg = new Program();
    @Test
    public void testGetImage(){
        pg.setImage("https://static-cdn.sr.se/sida/images/2523/3144086_2048_1152.jpg");
        Class<BufferedImage> expected = BufferedImage.class;
        try {
            Image result = pg.getImage();
            assertEquals(expected,result.getClass());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testGetStartTime(){
        Integer expected = 20;
        pg.setStartTime("20");
        Object result = pg.getStartTime();
        assertTrue(expected.equals(result));
    }
    @Test
    public void testGetEndTime(){
        Integer expected = 30;
        pg.setEndTime("30");
        Object result = pg.getEndTime();
        assertTrue(expected.equals(result));

    }
}
