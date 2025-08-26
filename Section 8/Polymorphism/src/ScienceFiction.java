public class ScienceFiction extends Movie {

    public ScienceFiction(String title) {
        super(title);
    }

    @Override
    public void watchMovie() {
        super.watchMovie();
        System.out.printf(".. %s%n".repeat(3), "Bad aliens do bad stuff", "Space guys chase aliens", "Planet blows up");
    }

    public void watchSciFi() {
        System.out.println("Watching a Science Fiction");
    }

}