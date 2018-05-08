package backend;

import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author Tommie Lindberg (c15tlg@cs.umu.se)
 * @version 28/03/2018.
 */
public class ChannelSetUp {
    private ArrayList<Channel> channelList;
    private Parse_dom parser;

    public ChannelSetUp() throws ParserConfigurationException, IOException, SAXException {
        parser = new Parse_dom();
        NodeList channels = parser.parse("http://api.sr.se/api/v2/channels?pagination=false", "channel");
        channelList = parser.grabElement(channels, parser);
    }
    public ArrayList<Channel> getChannelList() {
        return channelList;
    }
}
