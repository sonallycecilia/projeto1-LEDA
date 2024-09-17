package entities;

import java.sql.Date;

public class Tweet {
    private String text;
    private String target;
    private String user;
    private String flag;
    private String formated_date;
    private String mentioned_person;
    private Date date;
    private int mentioned_person_count;
    private int id;
    
    //setters
    public void setText(String text) {
        this.text = text;
    }
    public void setTarget(String target) {
        this.target = target;
    }
    public void setUser(String user) {
        this.user = user;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public void setFormated_date(String formated_date) {
        this.formated_date = formated_date;
    }
    public void setMentioned_person(String mentioned_person) {
        this.mentioned_person = mentioned_person;
    }
    public void setMentioned_person_count(int mentioned_person_count) {
        this.mentioned_person_count = mentioned_person_count;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setFlag(String flag) {
        this.flag = flag;
    }

    //getters
    public String getText() {
        return text;
    }
    public String getTarget() {
        return target;
    }
    public String getUser() {
        return user;
    }
    public Date getDate() {
        return date;
    }
    public String getFormated_date() {
        return formated_date;
    }
    public String getMentioned_person() {
        return mentioned_person;
    }
    public int getMentioned_person_count() {
        return mentioned_person_count;
    }
    public int getId() {
        return id;
    }
    public String getFlag() {
        return flag;
    }

    //métodos


}
