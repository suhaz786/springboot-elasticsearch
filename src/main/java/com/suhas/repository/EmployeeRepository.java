package com.suhas.repository;

import com.suhas.model.Employee;
import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends ElasticsearchCrudRepository<Employee, Long> {

    List<Employee> findByOrganizationName(String name);
    List<Employee> findByName(String name);

}
