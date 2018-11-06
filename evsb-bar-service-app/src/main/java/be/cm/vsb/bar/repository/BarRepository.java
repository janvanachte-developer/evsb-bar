package be.cm.vsb.bar.repository;

import be.cm.vsb.bar.Bar;
//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource()
public interface BarRepository extends BarRepositoryUpdateStatus, MongoRepository<Bar, String> {

    @RestResource(exported = false)
    @Override
    <S extends Bar> List<S> saveAll(Iterable<S> iterable);
}
