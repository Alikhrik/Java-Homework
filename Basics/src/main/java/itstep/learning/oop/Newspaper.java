package itstep.learning.oop;

import java.time.LocalDate;

public class Newspaper extends Literature {
    private Date publication_date;

    public Date getPublication_date() {
        return publication_date;
    }

    public void setPublication_date(Date publication_date) {
        this.publication_date = publication_date;
    }

    @Override
    public String toString() {
        return super.getTitle() +
                " " + publication_date;
    }

    public Newspaper(Date publication_date, String title) {
        this.publication_date = publication_date;
        super.setTitle(title);
    }
}
