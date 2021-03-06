package com.carlsilber.pm_backend.exceptions;

public class ProjectNotFoundExceptionResponse {

  private String projectIdentifier;

  public ProjectNotFoundExceptionResponse(String projectIdentifier) {
    this.projectIdentifier = projectIdentifier;
  }

  public String getProjectIdentifier() {
    return projectIdentifier;
  }

  public void setProjectIdentifier(String projectIdentifier) {
    this.projectIdentifier = projectIdentifier;
  }
}
