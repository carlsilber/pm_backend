package com.carlsilber.pm_backend.repositories;

import com.carlsilber.pm_backend.entity.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {

  Project findByProjectIdentifier(String projectId);

  @Override
  Iterable<Project> findAll();
}
