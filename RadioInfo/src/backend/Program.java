package backend;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.net.URL;

/**
 * @author Tommie Lindberg (c15tlg@cs.umu.se)
 * @version 07/04/2018.
 */
public class Program {
    private String title;
    private String description;
    private String startTime;
    private String endTime;
    private String image;
    private String startDate;
    private String endDate;

    public Program(){}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStartTime() {
        startTime = startTime.substring(0,startTime.length()-1);
        return startTime;
    }

    public void setStartTime(String startTime) {
        String[] parts = startTime.split("T");
        this.startDate=parts[0];
        this.startTime = parts[1];
    }

    public String getEndTime() {
        endTime = endTime.substring(0,endTime.length()-1);
        return endTime;
    }

    public void setEndTime(String endTime) {
        String[] parts = endTime.split("T");
        this.endDate=parts[0];
        this.endTime = parts[1];
    }

    public Image getImage() throws IOException {
        URL url = new URL(image);
        Image image1 = ImageIO.read(url);
        return image1;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getStartDate(){
        return startDate;
    }
    public String getEndDate(){
        return endDate;
    }
}
