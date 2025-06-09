import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import static org.junit.Assert.*;

import java.beans.Transient;
import java.time.*;
import java.util.HashMap;
import java.util.Map;

@RunWith(JUnit4.class)
public class TimeConverterTest_Junit {

    
    //BlackBoxTest
    @Test 
    public void testBetweenSameTimeZones(){
        assertEquals("Same time zone", LocalTime.parse("09:10") , TimeConverter.convertTime("malaysia", "china", "09:10"));
    }

    @Test
    public void testBetweenTwoTimeZones(){
        assertEquals("Different time zone", LocalTime.parse("20:10"), TimeConverter.convertTime("japan", "usa", "09:10"));
    }

    @Test
    public void testCNameAllLowerCase(){
        assertEquals("CName all lower case", LocalTime.parse("20:10"), TimeConverter.convertTime("japan", "usa", "09:10"));
    }

    @Test
    public void testCNameAllUpperCase(){
        assertEquals("CName all upper case", LocalTime.parse("20:10"), TimeConverter.convertTime("JAPAN", "USA", "09:10"));
    }

    @Test
    public void testCNamemixingCase(){
        assertEquals("CName mixing case", LocalTime.parse("20:10"), TimeConverter.convertTime("JaPAN", "UsA", "09:10"));
    }
}
