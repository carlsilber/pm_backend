package com.carlsilber.pm_backend.controller;

import com.carlsilber.pm_backend.entity.Project;
import com.carlsilber.pm_backend.services.ProjectService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/project")
public class ProjectController {

  @Autowired
  private ProjectService projectService;

  @PostMapping("")
  public ResponseEntity<?> createNewProject(@Valid @RequestBody Project project, BindingResult result){

    if(result.hasErrors()){
      // return new ResponseEntity<String>("Invalid Project object", HttpStatus.BAD_REQUEST);
      // return new ResponseEntity<List<FieldError>>(result.getFieldErrors(), HttpStatus.BAD_REQUEST);

      Map<String, String> errorMap =new HashMap<>();

      for (FieldError error: result.getFieldErrors()){
        errorMap.put(error.getField(), error.getDefaultMessage());
      }

      return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);



    }

    Project project1 = projectService.saveOrUpdateProject(project);

    return new ResponseEntity<Project>(project, HttpStatus.CREATED);
  }

}
