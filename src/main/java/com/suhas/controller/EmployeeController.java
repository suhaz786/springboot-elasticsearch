package com.suhas.controller;

import java.util.List;

import com.suhas.model.Employee;
import com.suhas.repository.EmployeeRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "/employees", description = "REST Controller for handling all employee related services")
@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	EmployeeRepository repository;

	@ApiOperation(value = "Create Employee", notes = "API to create a employee", nickname = "add")
	@ApiResponses(value = {
			@ApiResponse(code = 500, message = "Server error"),
			@ApiResponse(code = 404, message = "Service not found"),
			@ApiResponse(code = 405, message = "Method not allowed"),
			@ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 200, message = "Success")})
	@PostMapping
	public Employee add(@RequestBody Employee employee) {
		return repository.save(employee);
	}

	@ApiOperation(value = "Find By Name", notes = "API to find by name", nickname = "findByName")
	@ApiResponses(value = {
			@ApiResponse(code = 500, message = "Server error"),
			@ApiResponse(code = 404, message = "Service not found"),
			@ApiResponse(code = 405, message = "Method not allowed"),
			@ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 200, message = "Success")})
	@GetMapping("/{name}")
	public List<Employee> findByName(@PathVariable("name") String name) {
		return repository.findByName(name);
	}

	@ApiOperation(value = "Find By Organization Name", notes = "API to find by organization name", nickname = "findByOrganizationName")
	@ApiResponses(value = {
			@ApiResponse(code = 500, message = "Server error"),
			@ApiResponse(code = 404, message = "Service not found"),
			@ApiResponse(code = 405, message = "Method not allowed"),
			@ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 200, message = "Success")})
	@GetMapping("/organization/{organizationName}")
	public List<Employee> findByOrganizationName(@PathVariable("organizationName") String organizationName) {
		return repository.findByOrganizationName(organizationName);
	}

}
