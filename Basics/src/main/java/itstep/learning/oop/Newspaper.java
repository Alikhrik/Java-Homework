package itstep.learning.oop;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Newspaper extends Literature {
    private Date date;

    public static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return String.format("Newspaper: %s (%s)",
                super.getTitle(), dateFormat.format(this.date));
    }

    public Newspaper(String date, String title) throws ParseException {
        this.date = dateFormat.parse(date);
        super.setTitle(title);
    }
}
