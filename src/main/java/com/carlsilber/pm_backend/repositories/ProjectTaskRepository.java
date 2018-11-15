package com.carlsilber.pm_backend.repositories;

import com.carlsilber.pm_backend.entity.ProjectTask;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectTaskRepository extends CrudRepository<ProjectTask, Long>{

}
