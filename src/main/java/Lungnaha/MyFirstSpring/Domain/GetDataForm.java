package Lungnaha.MyFirstSpring.Domain;

import org.apache.tomcat.jni.Local;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

// HTML에서 받을 데이터 Form(형식)을 정의하는 파일
public class GetDataForm {
    private String day;
    private  String story;
    private Date date;

    public String getDay(){
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getStory() {
        return story;
    }

    public void setStory(String story) {
        this.story = story;
    }

    public Date getDate(){
        return date;
    }

    public void setDate(Date date){
        this.date = date;
    }

}
