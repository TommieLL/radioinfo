package test;

import backend.Channel;
import backend.ChannelSetUp;
import javazoom.jl.player.Player;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

/**
 * @author Tommie Lindberg (c15tlg@cs.umu.se)
 * @version 20/11/2017.
 */
public class dom_test {

    public static void main(String[] args) {
        // Parse_dom dom = new Parse_dom();
        //NodeList channels = dom.parse("http://api.sr.se/api/v2/channels");
        //ArrayList mylist = dom.grabElement(channels);
        //if (mylist.isEmpty()){
        //   System.out.println("hej");
        //}
        ChannelSetUp up = null;
        try {
            up = new ChannelSetUp();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
        ArrayList<Channel> ch = up.getChannelList();


        //for(int i = ch.size(); i == ch.size(); i++){
        Channel cs = ch.get(02);
        System.out.println(cs.getName());
        System.out.println(cs.getImageTemplateURL());
        System.out.println(cs.getScheduleURL() + "&pagination=false");
        System.out.println(cs.getTagline());
        System.out.println(cs.getLiveAudioAAC());


        for (int i = 0; i < cs.getSchedule().size(); i++) {
            System.out.println(cs.getSchedule().get(i).getStartTime() + " Datum: " + cs.getSchedule().get(i).getStartDate());
            System.out.println(cs.getSchedule().get(i).getTitle());
            System.out.println(cs.getSchedule().get(i).getDescription());
            System.out.println(cs.getSchedule().get(i).getEndTime() + " Datum: " + cs.getSchedule().get(i).getEndDate());
            System.out.println("\n\n");


        }
        // För musik
        try{

            Player pl = new Player(new URL(cs.getLiveAudioAAC()).openStream());
            pl.play();
            pl.close();
        }catch(Exception e){
            System.out.println(e);
        }


    }
}
