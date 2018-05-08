package backend;

import java.util.ArrayList;

/**
 * @author Tommie Lindberg (c15tlg@cs.umu.se)
 * @version 20/11/2017.
 */
public class Channel {
    private String name;
    private String imageURL;
    private String imageTemplateURL;
    private String color;
    private String siteURL;
    private String liveAudioAAC;
    private String statkey;
    private String scheduleURL;
    private ArrayList<Program> schedule;
    private String channeltype;
    private String tagline;

    public Channel(){
      /*  this.name = name;
        this.imageURL = imageURL;
        this.imageTemplateURL =
        this.color = color;
        this.siteURL = siteURL;
        this.liveAudioAAC = liveAudioAAC;
        this.statkey = statkey;
        this.scheduleURL = scheduleURL;
        this.schedule=schedule;
        this.channeltype = channeltype;
        this.tagline = tagline;*/
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setImageURL(String imageURL){
        this.imageURL = imageURL;
    }
    public String getImageURL(){
        return imageURL;
    }
    public void setImageTemplateURL(String imageTemplateURL){
        this.imageTemplateURL = imageTemplateURL;
    }
    public String getImageTemplateURL(){
        return imageTemplateURL;
    }
    public void setColor(String color){
        this.color = color;
    }
    public String getColor(){
        return color;
    }
    public void setSiteUrl( String siteUrl){
        this.siteURL = siteUrl;
    }
    public String getSiteUrl(){
        return siteURL;
    }
    public void setLiveAudioAAC(String liveAudioAAC){
        this.liveAudioAAC = liveAudioAAC;
    }
    public String getLiveAudioAAC(){
        return liveAudioAAC;
    }
    public void setStatkey(String statkey){
        this.statkey = statkey;
    }
    public String getStatkey(){
        return statkey;
    }
    public void setScheduleURL(String scheduleURL){
        this.scheduleURL = scheduleURL;
    }
    public String getScheduleURL(){
        return scheduleURL;
    }
    public void setSchedule(ArrayList<Program> schedule){
        this.schedule=schedule;
    }
    public ArrayList<Program> getSchedule(){
        return schedule;
    }
    public void setChanneltype(String channeltype){
        this.channeltype = channeltype;
    }
    public String getChanneltype(){
        return channeltype;
    }
    public void setTagline(String tagline){
        this.tagline=tagline;
    }
    public String getTagline (){
        return tagline;
    }



}
