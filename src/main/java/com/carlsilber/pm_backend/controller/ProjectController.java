package com.carlsilber.pm_backend.controller;

import com.carlsilber.pm_backend.entity.Project;
import com.carlsilber.pm_backend.services.ProjectService;
import com.carlsilber.pm_backend.services.ValidationErrorService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/project")
public class ProjectController {

  @Autowired
  private ProjectService projectService;

  @Autowired
  private ValidationErrorService validationErrorService;

  @PostMapping("")
  public ResponseEntity<?> createNewProject(@Valid @RequestBody Project project,
      BindingResult result) {

    ResponseEntity<?> errorMap = validationErrorService.MapValidationService(result);

    if (errorMap != null) {
      return errorMap;
    }

    Project project1 = projectService.saveOrUpdateProject(project);

    return new ResponseEntity<Project>(project, HttpStatus.CREATED);
  }

}
