package controller;

import org.junit.jupiter.api.Test;
import java.util.Locale;
import java.util.ResourceBundle;
import static org.junit.jupiter.api.Assertions.*;
public class BMIControllerTest{
    @Test
    public void testEnglishBundle() {
        Locale myLocale = new Locale("en", "US");
        ResourceBundle rb = ResourceBundle.getBundle("Messages1", myLocale);
        assertEquals("Height (m)", rb.getString("lblHeight.text"));
    }
}