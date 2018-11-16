package com.carlsilber.pm_backend.controller;

import com.carlsilber.pm_backend.entity.ProjectTask;
import com.carlsilber.pm_backend.services.ProjectTaskService;
import com.carlsilber.pm_backend.services.ValidationErrorService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/backlog")
@CrossOrigin
public class BacklogController {
  @Autowired
  private ProjectTaskService projectTaskService;
  @Autowired
  private ValidationErrorService validationErrorService;

  @PostMapping("/{backlog_id}")
  public ResponseEntity<?> addPTtoBacklog(@Valid @RequestBody ProjectTask projectTask,
      BindingResult result, @PathVariable String backlog_id){
    ResponseEntity<?> erroMap = validationErrorService.MapValidationService(result);
    if (erroMap != null) return erroMap;
    ProjectTask projectTask1 = projectTaskService.addProjectTask(backlog_id, projectTask);
    return new ResponseEntity<ProjectTask>(projectTask1, HttpStatus.CREATED);
  }
}
