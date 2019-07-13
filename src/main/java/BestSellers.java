import java.text.SimpleDateFormat;
import java.util.Date;

public class BestSellers
{

    public String publisher;
    public String dagger;
    public String book_review_link;
    public String author;
    public String primary_isbn10;
    public String price;
    public String primary_isbn13;
    public String sunday_review_link;
        // private String date;
    public String first_chapter_link;
    public String contributor;
    public String title;
    public String age_group;
    public String weeks_on_list;

        public BestSellers
                (
                        String publisher,
                        String dagger,
                        String book_review_link,
                        String author,
                        String primary_isbn10,
                        String price,
                        String primary_isbn13,
                        String sunday_review_link,
                        // Date date,
                        String first_chapter_link,
                        String contributor,
                        String title,
                        String age_group,
                        String weeks_on_list
                )
        {
            this.publisher = publisher;
            this.dagger = dagger;
            this.book_review_link = book_review_link;
            this.author = author;
            this.primary_isbn10 = primary_isbn10;
            this.price = price;
            this.primary_isbn13 = primary_isbn13;
            this.sunday_review_link = sunday_review_link;
            // this.date = date;
            this.first_chapter_link = first_chapter_link;
            this.contributor = contributor;
            this.title = title;
            this.age_group = age_group;
            this.weeks_on_list = weeks_on_list;
        }

}


