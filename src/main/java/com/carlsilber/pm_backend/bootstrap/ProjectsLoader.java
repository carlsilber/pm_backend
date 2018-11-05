package com.carlsilber.pm_backend.bootstrap;

import com.carlsilber.pm_backend.entity.Project;
import com.carlsilber.pm_backend.repositories.ProjectRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
public class ProjectsLoader implements CommandLineRunner {

  private final Logger logger = LoggerFactory.getLogger(ProjectsLoader.class);

  private ProjectRepository projectRepository;


  public ProjectsLoader(ProjectRepository projectRepository) {
    this.projectRepository = projectRepository;
  }

  @Override
  @Order(1)
  public void run(String... args) throws Exception {

    long count = projectRepository.count();

    if (count == 0) {
      loadData();
    }
  }

  private void loadData() {

    // Project 1
    Project project1 = new Project();
    project1.setProjectName("Project 1");
    project1.setProjectIdentifier("ID001");
    project1.setDescription("Project description");
    project1.setStart_date(null);
    project1.setEnd_date(null);
    projectRepository.save(project1);

    logger.info("project1 loaded");

    // Project 2
    Project project2 = new Project();
    project2.setProjectName("Project 2");
    project2.setProjectIdentifier("ID002");
    project2.setDescription("Project description");
    project2.setStart_date(null);
    project2.setEnd_date(null);
    projectRepository.save(project2);

    logger.info("project2 loaded");
  }
}

