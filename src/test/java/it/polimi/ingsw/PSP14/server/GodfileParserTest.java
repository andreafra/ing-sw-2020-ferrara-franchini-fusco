package it.polimi.ingsw.PSP14.server;

import org.junit.jupiter.api.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class GodfileParserTest {
    @Test
    void shouldParseCorrectly() {
        assertDoesNotThrow(() -> {
            ArrayList<String> test = GodfileParser.getGodIdList("src/test/resources/godlist_valid_1.xml");
            ArrayList<String> expected = new ArrayList<String>();
            expected.add("Apollo");
            assertEquals(expected, test);
        });
    }

    @Test
    void shouldFailParse() {
        assertThrows(FileNotFoundException.class, () -> {
            ArrayList<String> test = GodfileParser.getGodIdList("src/test/resources/godlist_invalid_2_electric_boogaloo.xml");
        });
    }

    @Test
    void shouldFailParse2() {
        assertThrows(SAXException.class, () -> {
            ArrayList<String> test = GodfileParser.getGodIdList("src/test/resources/godlist_invalid_1.xml");
        });
    }
}