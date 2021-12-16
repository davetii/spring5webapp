package guru.springframework.spring5webapp;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repo.AuthorRepo;
import guru.springframework.spring5webapp.repo.BookRepo;
import guru.springframework.spring5webapp.repo.PublisherRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

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

        System.out.println("start bootstrap");

        Publisher pub1 = new Publisher();
        pub1.setName("Publisher 1");
        pub1.setCity("Harrison Township");

        publisherRepo.save(pub1);

        System.out.println("publisher count " + publisherRepo.count());

        Author stephenKing = new Author("Stephen", "King");
        Book theDarkTower = new Book("The Dark Towner", "123");
        theDarkTower.setPublisher(pub1);
        stephenKing.getBooks().add(theDarkTower);
        theDarkTower.getAuthors().add(stephenKing);
        pub1.getBooks().add(theDarkTower);


        authorRepo.save(stephenKing);
        bookRepo.save(theDarkTower);

        Author brandonSanderson = new Author("Brandon", "Sanders");
        Book theWayOfKings = new Book("The Way of Kings", "124");
        theWayOfKings.setPublisher(pub1);
        brandonSanderson.getBooks().add(theWayOfKings);
        theWayOfKings.getAuthors().add(brandonSanderson);
        pub1.getBooks().add(theWayOfKings);

        authorRepo.save(brandonSanderson);
        bookRepo.save(theWayOfKings);


        System.out.println("authors: " + authorRepo.count());
        System.out.println("books: " + bookRepo.count());
        System.out.println("publishers: " + publisherRepo.count());
        System.out.println("publishers object: " + pub1.getBooks().size());
        publisherRepo.save(pub1);

        List<Publisher> list = StreamSupport
                .stream(publisherRepo.findAll().spliterator(), false)
                .collect(Collectors.toList());
        System.out.println("publishers 2: " + list.size());
        //System.out.println(list.get(0)); thwarted by some stupid hibernate lazy loading error




    }
}
