public class NextMain {

    public static void main(String[] args) {
        // Adventure movie = (Adventure) Movie.getMovie("A", "Lord of the rings");
        // movie.watchMovie();

        // Object comedy = (Comedy) Movie.getMovie("c", "Funny Movie");
        // Comedy myComedy = (Comedy) comedy;
        // myComedy.watchMovie();

        // var airplane = Movie.getMovie("A", "Airplane");
        // airplane.watchMovie();

        // var newComedy = new Comedy("Airplane");
        // newComedy.watchComedy();

        // Movie unknownObject = Movie.getMovie("C", "Laughter");
        // Movie unknownObject = Movie.getMovie("A", "Journey");
        // Movie unknownObject = Movie.getMovie("S", "Interstellar");
        String[] options = { null, "C", "A", "S" };
        String[] movies = { "A man's life", "We just met", "Finding Elisa", "Visitors" };

        for (int i = 0; i < options.length; i++) {

            Movie unknownObject = Movie.getMovie(options[i], movies[i]);

            if (unknownObject instanceof ScienceFiction scifi) {
                // ((ScienceFiction) unknownObject).watchSciFi();
                scifi.watchSciFi();
            } else if (unknownObject instanceof Comedy comedy) {
                // ((Comedy) unknownObject).watchComedy();
                comedy.watchComedy();
            } else if (unknownObject instanceof Adventure adv) {
                // ((Adventure) unknownObject).watchAdventure();
                adv.watchAdventure();
            } else {
                // ((Movie) unknownObject).watchMovie();
                unknownObject.watchMovie();
                ;
            }
        }

    }
}