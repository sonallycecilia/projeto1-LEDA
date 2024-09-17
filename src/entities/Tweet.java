package entities;

public class Tweet {
    //basics
    private int target;
    private long id;
    private String date;
    private String flag;
    private String user;
    private String text;

    //required
    private String formated_date;
    private String[] mentioned_person;
    private int mentioned_person_count;

    public Tweet(int target, long id, String date, String flag, String user, String text){
        this.target = target;
        this.id = id;
        this.date = date;
        this.flag = flag;
        this.user = user;
        this.text = text;
    }
    
    //setters
    public void setText(String text) {
        this.text = text;
    }
    public void setTarget(int target) {
        this.target = target;
    }
    public void setUser(String user) {
        this.user = user;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public void setFormated_date(String formated_date) {
        this.formated_date = formated_date;
    }
    public void setMentioned_person(String[] mentioned_person) {
        this.mentioned_person = mentioned_person;
    }
    public void setMentioned_person_count(int mentioned_person_count) {
        this.mentioned_person_count = mentioned_person_count;
    }
    public void setId(long id) {
        this.id = id;
    }
    public void setFlag(String flag) {
        this.flag = flag;
    }

    //getters
    public String getText() {
        return text;
    }
    public int getTarget() {
        return target;
    }
    public String getUser() {
        return user;
    }
    public String getDate() {
        return date;
    }
    public String getFormated_date() {
        return formated_date;
    }
    public String[] getMentioned_person() {
        return mentioned_person;
    }
    public int getMentioned_person_count() {
        return mentioned_person_count;
    }
    public long getId() {
        return id;
    }
    public String getFlag() {
        return flag;
    }

    //métodos


}
