package backend;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.w3c.dom.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

/**
 * "http://api.sr.se/api/v2/channels?liveaudiotemplateid=1&audioquality=hi&pagination=false"
 * @author Tommie Lindberg (c15tlg@cs.umu.se)
 * @version 20/11/2017.
 */
public class Parse_dom {
   private DocumentBuilderFactory factory;
   private DocumentBuilder builder;
   private NodeList nodeList;

 public Parse_dom() throws ParserConfigurationException {
     this.factory = DocumentBuilderFactory.newInstance();
     this.builder = factory.newDocumentBuilder();

 }

 public NodeList parse(String xml, String tagname) throws IOException, SAXException {

     Document doc = parseXML(xml);
     nodeList = doc.getElementsByTagName(tagname);

     return nodeList;
 }
    private Document parseXML(String xml) throws IOException, SAXException {
        URL url= new URL(xml);
        URLConnection connection = url.openConnection();

        Document doc = builder.parse(connection.getInputStream());

        return doc;
    }

 public ArrayList<Channel> grabElement(NodeList channelsList, Parse_dom parser) throws ParserConfigurationException, IOException, SAXException {
     ArrayList listOfChannels = new ArrayList();
     for(int i = 0; i < channelsList.getLength(); i++){
         Node n = channelsList.item(i);
         if(n.getNodeType()==Node.ELEMENT_NODE) {
             Element channel = (Element) n;
             Channel ch = new Channel();
             ch.setName(channel.getAttribute("name"));
             //System.out.println("Kanal :" + ch.getName());

             NodeList childList = channel.getChildNodes();
             for(int j = 0; j < childList.getLength(); j++){
                 Node cn = childList.item(j);

                 if(cn.getNodeType() == Node.ELEMENT_NODE){
                     Element e = (Element) cn;
                     if(e.getTagName() == "image") {
                         ch.setImageURL( e.getTextContent());
                         //System.out.println("image " + ch.getImageURL());
                     }
                     if(e.getTagName() == "imagetemplate"){
                         ch.setImageTemplateURL(e.getTextContent());
                         //System.out.println("template " + ch.getImageTemplateURL());
                     }

                     if(e.getTagName() == "color"){
                         ch.setColor(e.getTextContent());
                         //System.out.println("color " + ch.getColor());
                     }
                     if(e.getTagName()=="tagline"){
                         ch.setTagline(e.getTextContent());
                     }
                     if(e.getTagName() == "siteurl"){
                         ch.setSiteUrl(e.getTextContent());
                         //System.out.println("siteurl " + ch.getSiteUrl());
                     }
                     if(e.getTagName() == "liveaudio"){
                         NodeList sn = e.getChildNodes();
                         for(int y = 0; y < sn.getLength(); y++){
                             Node m = sn.item(y);
                             if(m.getNodeType() == Node.ELEMENT_NODE){
                                 Element et = (Element) m;
                                 if(et.getTagName() == "url"){
                                     ch.setLiveAudioAAC(et.getTextContent());
                                     //System.out.println("live audio " + ch.getLiveAudioAAC());
                                 }
                                 if(et.getTagName() == "statkey"){
                                     ch.setStatkey(et.getTextContent());
                                     //System.out.println("statkey " + ch.getStatkey());
                                 }
                             }
                         }

                     }

                     if(e.getTagName() == "scheduleurl"){
                         ch.setScheduleURL(e.getTextContent());
                         NodeList schedule = parser.parse(e.getTextContent(),"scheduledepisode");
                         ch.setSchedule(parser.grabSchedule(schedule));

                         //System.out.println("schema " + ch.getScheduleURL());
                     }
                     if(e.getTagName() == "channeltype"){
                         ch.setChanneltype(e.getTextContent());
                         //System.out.println("typ av kanal " + ch.getChanneltype());
                     }
                 }
             }


             listOfChannels.add(ch);
         }
     }

     return listOfChannels;
 }

    public ArrayList<Program> grabSchedule(NodeList programs) {
     ArrayList programSchedule = new ArrayList();
     for(int i = 0; i < programs.getLength(); i++){
         Node n = programs.item(i);
         if(n.getNodeType()==Node.ELEMENT_NODE){
             Element program = (Element) n;
             Program pg = new Program();
             NodeList pgList = program.getChildNodes();

             for(int j = 0; j < pgList.getLength(); j++){
                 Node npg = pgList.item(j);

                 if(npg.getNodeType()==Node.ELEMENT_NODE){
                     Element e = (Element) npg;

                     if(e.getTagName()== "title"){
                         pg.setTitle(e.getTextContent());
                     }
                     if(e.getTagName()=="description"){
                         pg.setDescription(e.getTextContent());
                     }
                     if(e.getTagName()=="starttimeutc"){
                         pg.setStartTime(e.getTextContent());
                     }
                     if(e.getTagName()=="endtimeutc"){
                         pg.setEndTime(e.getTextContent());
                     }
                     if(e.getTagName()=="imageurltemplate"){
                         pg.setImage(e.getTextContent());
                     }
                 }
             }
             programSchedule.add(pg);
         }
     }
     return programSchedule;
    }
}
