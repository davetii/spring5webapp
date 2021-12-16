package guru.springframework.spring5webapp.repo;

import guru.springframework.spring5webapp.domain.Publisher;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface PublisherRepo extends CrudRepository<Publisher, Long> {

}
