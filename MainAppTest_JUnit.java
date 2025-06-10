import java.util.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;
import java.time.LocalTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class MainAppTest_JUnit {
    @Test 
    public void choice1(){
        ByteArrayOutputStream capOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(capOut));

        //Test data
        //1
        //japan
        //usa
        //09:10(HH:MM)
        //3
        System.setIn(new ByteArrayInputStream("1\njapan\nusa\n09:10\n3".getBytes()));
        MainApp.main(new String[]{});
        String output = capOut.toString();

        assertTrue("japan to usa time convert, 09:10", output.contains("Converted time in usa: 20:10"));
    }

    @Test 
    public void choice2(){
        ByteArrayOutputStream capOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(capOut));

        //Test data
        //2
        //japan
        //3
        System.setIn(new ByteArrayInputStream("2\njapan\n3".getBytes()));
        MainApp.main(new String[]{});
        String output = capOut.toString();

        assertTrue("japan season check", output.contains("Current season in japan: Spring"));
    }

    @Test
    public void choice3(){
        ByteArrayOutputStream capOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(capOut));

        //Test data
        //3
        System.setIn(new ByteArrayInputStream("3".getBytes()));
        MainApp.main(new String[]{});
        String output = capOut.toString();
        assertTrue("Exit application", output.contains("Goodbye!"));
    }

    @Test
    public void choiceGreaterThan3() {
        ByteArrayOutputStream capOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(capOut));

        //Test data
        //4
        System.setIn(new ByteArrayInputStream("4".getBytes()));
        MainApp.main(new String[]{});
        String output = capOut.toString();

        assertTrue("Bigger value choice", output.contains("Invalid input, please try again!"));
    }

    @Test
    public void choiceLesserThan1() {
        ByteArrayOutputStream capOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(capOut));

        //Test data
        //0
        System.setIn(new ByteArrayInputStream("0".getBytes()));
        MainApp.main(new String[]{});
        String output = capOut.toString();

        assertTrue("Lesser value choice", output.contains("Invalid input, please try again!"));
    }

    @Test
    public void choiceInvalidInput() {
        ByteArrayOutputStream capOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(capOut));

        //Test data
        //a
        System.setIn(new ByteArrayInputStream("a".getBytes()));
        MainApp.main(new String[]{});
        String output = capOut.toString();

        assertTrue("Invalid input", output.contains("Invalid input, please enter a number."));
    }

    @Test
    public void choiceInvalidInputcase2() {
        ByteArrayOutputStream capOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(capOut));

        //Test data
        //@
        System.setIn(new ByteArrayInputStream("@".getBytes()));
        MainApp.main(new String[]{});
        String output = capOut.toString();

        assertTrue("Invalid input case 2", output.contains("Invalid input, please enter a number."));
    }
}
