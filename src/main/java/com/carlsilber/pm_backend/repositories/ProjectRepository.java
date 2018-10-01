package com.carlsilber.pm_backend.repositories;

import com.carlsilber.pm_backend.entity.Project;
import org.springframework.data.repository.CrudRepository;

public interface ProjectRepository extends CrudRepository<Project, Long> {

  @Override
  Iterable<Project> findAllById(Iterable<Long> iterable);

}
