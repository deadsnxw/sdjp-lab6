/**
 * Abstract class representing a general Music Composition.
 */
public abstract class MusicComposition {
    protected String title;
    protected String artist;
    protected double duration; // Duration in minutes
    protected String genre;

    public MusicComposition(String title, String artist, double duration, String genre) {
        if (title == null || artist == null || duration <= 0 || genre == null) {
            throw new IllegalArgumentException("Invalid input for creating a music composition.");
        }
        this.title = title;
        this.artist = artist;
        this.duration = duration;
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public double getDuration() {
        return duration;
    }

    public String getGenre() {
        return genre;
    }

    @Override
    public String toString() {
        return String.format("Title: %s, Artist: %s, Duration: %.2f min, Genre: %s",
                title, artist, duration, genre);
    }
}
