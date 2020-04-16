package com.example.demo.web;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Project;
import com.example.demo.service.MapValidationErrorService;
import com.example.demo.service.ProjectService;

@RestController
@RequestMapping("api/project")
public class ProjectController {
	@Autowired
	private ProjectService projectService;
	
	@Autowired
	MapValidationErrorService mapValidationErrorService;
	
	@PostMapping("")
	public ResponseEntity<?> saveProject(@Valid @RequestBody Project project,BindingResult result){
		ResponseEntity<?> errorMap=mapValidationErrorService.mapValidationError(result);
		if(errorMap!=null) {
			return errorMap;
		} 
		Project proj=projectService.saveAndUpdate(project);
		return new ResponseEntity<Project>(proj, HttpStatus.CREATED);
	}
	
	@GetMapping("/{projectId}")
	public ResponseEntity<?> getProjectById(@PathVariable String projectId){
		Project project = projectService.findProjectByIdentifier(projectId);
		return new ResponseEntity<Project>(project, HttpStatus.OK);
	}

}
