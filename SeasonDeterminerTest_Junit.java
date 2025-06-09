import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import static org.junit.Assert.*;
import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.*;
import java.time.Month;
import java.util.Map;

@RunWith(JUnit4.class)
//White Box testing
public class SeasonDeterminerTest_Junit {
    @Test
    public void testCheckSeason() {
        assertEquals("Northern", "Spring", SeasonDeterminer.checkSeason("usa"));
        assertEquals("Northern", "Spring", SeasonDeterminer.checkSeason("japan"));
        assertEquals("Northern", "Spring", SeasonDeterminer.checkSeason("india"));
        assertEquals("Southern", "Fall", SeasonDeterminer.checkSeason("australia"));
        assertEquals("Southern", "Fall", SeasonDeterminer.checkSeason("argentina"));
        assertEquals("Southern", "Fall", SeasonDeterminer.checkSeason("new zealand"));
    }
}