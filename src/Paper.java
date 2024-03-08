public class Paper {
    private String title;
    private int year;
    private String journal;
    private int citation;

    public Paper(String title, int year, String journal, int citation) {
        // Robust?
        this.title = title;
        this.year = year;
        this.journal = journal;
        this.citation = citation;
    }

    public int increaseCitation(int n) {
        if (n <= 0)
            throw new IllegalArgumentException("Please give a positive number!");

        this.citation += n;
        return this.citation;
    }

    public int decreaseCitation(int n) {
        if (this.citation < n)
            throw new IllegalArgumentException("Too large decreasing number!");

        if (n <= 0)
            throw new IllegalArgumentException("Please give a positive number!");

        this.citation -= n;
        return this.citation;
    }

    public String getTitle() {
        return title;
    }

    public int getCitation() {
        return citation;
    }
}
