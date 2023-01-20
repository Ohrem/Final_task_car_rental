package my.ohrem.restdb.repository;

import my.ohrem.restdb.entity.RestEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestRepository extends CrudRepository<RestEntity, Long> {

}