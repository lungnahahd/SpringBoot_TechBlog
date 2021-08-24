package Lungnaha.MyFirstSpring.Domain;

// HTML에서 받을 데이터 Form(형식)을 정의하는 파일
public class GetDataForm {
    private String day;
    private  String story;
    private String date;

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

    public String getDate(){
        return date;
    }

    public void setDate(String date){
        this.date = date;
    }

}
