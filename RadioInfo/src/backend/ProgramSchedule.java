package backend;

import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

// BEHÖVS EJ! KÖRS I PARSER_DOM.JAVA

/**
 * @author Tommie Lindberg (c15tlg@cs.umu.se)
 * @version 07/04/2018.
 */
public class ProgramSchedule {
    private ArrayList<Program> programSchedule;
    private Parse_dom parser;

    public ProgramSchedule(String programsUrl) throws ParserConfigurationException, IOException, SAXException {
        this.programSchedule = new ArrayList<Program>();
        this.parser = new Parse_dom();
        NodeList programs = parser.parse(programsUrl,"scheduledepisode");
        programSchedule = parser.grabSchedule(programs);

    }

}
