public class Book
{
    private String isbn;
    private String media;
    private String format;
    private String title;
    private String author;
    private String publisher;

    public Book
            (
            String isbn,
            String media,
            String format,
            String title,
            String author,
            String publisher
    )
    {
        this.isbn = isbn;
        this.media = media;
        this.format = format;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
    }
}
