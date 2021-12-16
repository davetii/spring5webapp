package guru.springframework.spring5webapp;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repo.AuthorRepo;
import guru.springframework.spring5webapp.repo.BookRepo;
import guru.springframework.spring5webapp.repo.PublisherRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BookStrapData implements CommandLineRunner {

    private final AuthorRepo authorRepo;
    private final BookRepo bookRepo;
    private final PublisherRepo publisherRepo;

    public BookStrapData(AuthorRepo authorRepo, BookRepo bookRepo, PublisherRepo publisherRepo) {
        this.authorRepo = authorRepo;
        this.bookRepo = bookRepo;
        this.publisherRepo = publisherRepo;
    }

    @Override
    public void run(String... args) throws Exception {

        Author stephenKing = new Author("Stephen", "King");
        Book theDarkTower = new Book("The Dark Towner", "123");
        stephenKing.getBooks().add(theDarkTower);
        theDarkTower.getAuthors().add(stephenKing);

        authorRepo.save(stephenKing);
        bookRepo.save(theDarkTower);

        Author brandonSanderson = new Author("Brandon", "Sanders");
        Book theWayOfKings = new Book("The Way of Kings", "124");
        brandonSanderson.getBooks().add(theWayOfKings);
        theWayOfKings.getAuthors().add(brandonSanderson);

        authorRepo.save(brandonSanderson);
        bookRepo.save(theWayOfKings);

        Publisher publisher1 = new Publisher("pub1", "1234 nowhere", "harry", "MI", "48045");
        publisherRepo.save(publisher1);

        System.out.println("authors: " + authorRepo.count());
        System.out.println("books: " + bookRepo.count());
        System.out.println("publishers: " + publisherRepo.count());


    }
}
