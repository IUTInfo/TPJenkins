import fr.emiliengirolet.Book;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import static  org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.stream.Stream;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BookTest {

    @ParameterizedTest
    @MethodSource("titleProviders")
    public void testBookTitle(String title) {
        final String fakeAuthor = "Emilien Girolet";
        final Date fakePublishingDate = new Date();

        Book b = new Book(title, fakeAuthor, fakePublishingDate);
        assertEquals(title, b.getTitle());
    }

    @ParameterizedTest
    @ValueSource(strings = { "" })
    public void testBookTitleEmpty(String title) {
        final String fakeAuthor = "Emilien Girolet";
        final Date fakePublishingDate = new Date();

        assertThrows(IllegalArgumentException.class, () -> new Book(title, fakeAuthor, fakePublishingDate));
    }

    @ParameterizedTest
    @MethodSource("authorProviders")
    public void testBookAuthor(String author) {
        final String fakeTitle = "The Lord of the Rings";
        final Date fakePublishingDate = new Date();

        Book b = new Book(fakeTitle, author, fakePublishingDate);
        assertEquals(author, b.getAuthor());
    }

    @ParameterizedTest
    @ValueSource(strings = { "" })
    public void testBookAuthorEmpty(String author) {
        final String fakeTitle = "The Lord of the Rings";
        final Date fakePublishingDate = new Date();

        assertThrows(IllegalArgumentException.class, () -> new Book(fakeTitle, author, fakePublishingDate));
    }

    @ParameterizedTest
    @MethodSource("dateProviders")
    public void testBookDate(Date date) {
        final String fakeTitle = "The Lord of the Rings";
        final String fakeAuthor = "Tolkien";

        Book b = new Book(fakeTitle, fakeAuthor, date);
        assertEquals(date, b.getPublishing());
    }

    public Stream<Arguments> titleProviders() {
        return Stream.of(
                Arguments.of("Harry Potter"),
                Arguments.of("The Lord of the Rings"),
                Arguments.of("20k lieues sous les mers")
        );
    }

    public Stream<Arguments> authorProviders() {
        return Stream.of(
                Arguments.of("JK Rowling"),
                Arguments.of("Tolkien"),
                Arguments.of("Jules Vernes")
        );
    }

    public Stream<Arguments> dateProviders() {
        return Stream.of(
                Arguments.of(new GregorianCalendar(2023, Calendar.MARCH, 28).getTime()),
                Arguments.of(new GregorianCalendar(1973, Calendar.JANUARY, 31).getTime()),
                Arguments.of(new GregorianCalendar(2003, Calendar.MAY, 12).getTime())
        );
    }
}
