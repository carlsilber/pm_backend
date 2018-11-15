package com.carlsilber.pm_backend.repositories;

import com.carlsilber.pm_backend.entity.Backlog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BacklogRepository extends CrudRepository<Backlog, Long> {

  Backlog findByProjectIdentifier(String Identifier);

}
