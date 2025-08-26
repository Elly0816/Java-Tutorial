import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String type, title;
        List<MovieTuple> movies = new ArrayList<MovieTuple>();
        while (true) {

            type = readLine(sc,
                    "Press 'q' or enter a number to get stop%nEnter the type of movie you want to watch:\nThe options are: Comedy, Science Fiction, and Adventure ");
            if (shouldQuit(false, type))
                break;

            title = readLine(sc, "Enter the title of the movie you want to watch: ");
            if (shouldQuit(true, title))
                break;

            if (type.isBlank()) {
                type = "none";
            }
            movies.add(new MovieTuple(type, title));

        }

        sc.close();
        for (int i = 0; i < movies.size(); i++) {
            System.out.printf("%n");
            MovieTuple movie = movies.get(i);
            Movie userMovie = Movie.getMovie(movie.type(), movie.title());
            userMovie.watchMovie();
        }
    }

    private static String readLine(Scanner sc, String prompt) {
        System.out.printf(prompt);
        String input = sc.nextLine();
        return input == null ? "" : input.trim();
    }

    private static boolean shouldQuit(boolean isTitle, String input) {
        if (isTitle && input.isBlank())
            return true;
        if (!isTitle && input.isBlank())
            return false;

        String trimmed = input.trim();
        if (trimmed.equalsIgnoreCase("q") || trimmed.matches("^[0-9]+$")) {
            return true;
        }

        return false;

    }
}