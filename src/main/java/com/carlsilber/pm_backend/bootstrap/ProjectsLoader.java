package com.carlsilber.pm_backend.bootstrap;

import com.carlsilber.pm_backend.entity.Backlog;
import com.carlsilber.pm_backend.entity.Project;
import com.carlsilber.pm_backend.entity.ProjectTask;
import com.carlsilber.pm_backend.repositories.BacklogRepository;
import com.carlsilber.pm_backend.repositories.ProjectRepository;

import com.carlsilber.pm_backend.repositories.ProjectTaskRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Profile({"prod", "dev"})
public class ProjectsLoader implements CommandLineRunner {

  private final Logger logger = LoggerFactory.getLogger(ProjectsLoader.class);

  private ProjectRepository projectRepository;

  private ProjectTaskRepository projectTaskRepository;

  private BacklogRepository backlogRepository;

  public ProjectsLoader(ProjectRepository projectRepository,
      ProjectTaskRepository projectTaskRepository,
      BacklogRepository backlogRepository) {
    this.projectRepository = projectRepository;
    this.projectTaskRepository = projectTaskRepository;
    this.backlogRepository = backlogRepository;
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

    Backlog backlog1 = new Backlog();
    backlog1.setProject(project1);
    project1.setBacklog(backlog1);
    backlog1.setProjectIdentifier(project1.getProjectIdentifier());

    projectRepository.save(project1);

    logger.info("project1 loaded");

    //ProjectTask 1 to Project 1

    // Project 2
    Project project2 = new Project();
    project2.setProjectName("Project 2");
    project2.setProjectIdentifier("ID002");
    project2.setDescription("Project description");
    project2.setStart_date(null);
    project2.setEnd_date(null);

    Backlog backlog2 = new Backlog();
    backlog2.setProject(project2);
    project2.setBacklog(backlog2);
    backlog2.setProjectIdentifier(project2.getProjectIdentifier());

    projectRepository.save(project2);

    logger.info("project2 loaded");

    // ProjectTask 1 to Project 1
    ProjectTask projectTask1 = new ProjectTask();
    projectTask1.setProjectSequence("ID001-1");
    projectTask1.setSummary("Test");
    projectTask1.setStatus("TO_DO");
    projectTask1.setPriority(3);
    projectTask1.setProjectIdentifier("ID001");
    projectTask1.setBacklog(backlog1);
    projectTaskRepository.save(projectTask1);

    backlog1.setPTSequence(backlog1.getPTSequence() + 1);

    // ProjectTask 2 to Project 1
    ProjectTask projectTask2 = new ProjectTask();
    projectTask2.setProjectSequence("ID001-2");
    projectTask2.setSummary("Test2");
    projectTask2.setStatus("TO_DO");
    projectTask2.setPriority(3);
    projectTask2.setProjectIdentifier("ID001");
    projectTask2.setBacklog(backlog1);
    projectTaskRepository.save(projectTask2);

    backlog1.setPTSequence(backlog1.getPTSequence() + 1);
    backlogRepository.save(backlog1);

  }

}

