//import tools for tests
import static org.junit.Assert.*; 
import org.junit.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class MarkdownParseTest {
    //create a test
    @Test
    //create a testing method
    public void addition() {
        //test if the actual output is equal to the expected ine
        assertEquals(2, 1 + 1);
    }

    @Test
    public void testFile() throws IOException{
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

    @Test
    public void snippet1Test() throws IOException{
        Path fileName = Path.of("Snippet1.md");
        String content = Files.readString(fileName);
        ArrayList<String> actualLinks = MarkdownParse.getLinks(content);
        ArrayList<String> links = new ArrayList<>();
        String link1 = "`google.com";
        String link2 = "google.com";
        String link3 = "ucsd.edu";
        links.add(link1);
        links.add(link2);
        links.add(link3);
        assertEquals(links, actualLinks);
    }

    @Test
    public void snippet2Test() throws IOException{
        Path fileName = Path.of("Snippet2.md");
        String content = Files.readString(fileName);
        ArrayList<String> actualLinks = MarkdownParse.getLinks(content);
        ArrayList<String> links = new ArrayList<>();
        String link1 = "a.com";
        String link2 = "a.com(())";
        String link3 = "example.com";
        links.add(link1);
        links.add(link2);
        links.add(link3);
        assertEquals(links, actualLinks);
    }

    @Test
    public void snippet3Test() throws IOException{
        Path fileName = Path.of("Snippet3.md");
        String content = Files.readString(fileName);
        ArrayList<String> actualLinks = MarkdownParse.getLinks(content);
        ArrayList<String> links = new ArrayList<>();
        links.add("https://sites.google.com/eng.ucsd.edu/cse-15l-spring-2022/schedule");
        assertEquals(links, actualLinks);
    }
    

}
