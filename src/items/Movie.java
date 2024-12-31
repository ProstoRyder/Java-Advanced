package items;

import annotations.JsonField;
import annotations.XmlField;

/**
 * Represents a Movie with attributes for title, director, and release year.
 * This class supports mapping of its fields for both JSON and XML serialization
 * using the {@link JsonField} and {@link XmlField} annotations.
 */
public class Movie {

    /**
     * The title of the movie.
     * Serialized as "title" in JSON and "Title" in XML.
     */
    @JsonField("title")
    @XmlField("Title")
    private String title;

    /**
     * The director of the movie.
     * Serialized as "director" in JSON and "Director" in XML.
     */
    @JsonField("director")
    @XmlField("Director")
    private String director;

    /**
     * The release year of the movie.
     * Serialized as "releaseYear" in JSON and "ReleaseYear" in XML.
     */
    @JsonField("releaseYear")
    @XmlField("ReleaseYear")
    private String releaseYear;

    /**
     * Constructs a new Movie instance with the specified title, director, and release year.
     *
     * @param title        the title of the movie (e.g., "Inception")
     * @param director    the director of the movie (e.g., "Christopher Nolan")
     * @param releaseYear the release year of the movie (e.g., "2010")
     */
    public Movie(String title, String director, String releaseYear) {
        this.title = title;
        this.director = director;
        this.releaseYear = releaseYear;
    }
}
