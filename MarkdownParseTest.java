//import tools for tests
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.*;

public class MarkdownParseTest {
    //create a test
    @Test
    //create a testing method
    public void addition() {
        //test if the actual output is equal to the expected ine
        assertEquals(2, 1 + 1);
    }

    @Test
    public void testFile() {
        Path fileName = Path.of("test-file.md");
        String content = Files.readString(fileName);
        ArrayList<String> actualLinks = MarkdownParse.getLinks(content);
        ArrayList<String> links = new ArrayList<>();
        String link1 = "https://something.com";
        String link2 = "some-thing.html";
        links.add(link1);
        links.add(link2);
        assertEquals(links, actualLinks);
    }
    
}
