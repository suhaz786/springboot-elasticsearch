package com.suhas;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.testcontainers.elasticsearch.ElasticsearchContainer;
import com.suhas.model.Department;
import com.suhas.model.Employee;
import com.suhas.model.Organization;
import com.suhas.repository.EmployeeRepository;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmployeeRepositoryTest {

    @ClassRule
    public static ElasticsearchContainer container = new ElasticsearchContainer();
    @Autowired
    EmployeeRepository repository;

    @BeforeClass
    public static void before() {
        System.setProperty("spring.data.elasticsearch.cluster-nodes", container.getContainerIpAddress() + ":" + container.getMappedPort(9300));
    }

    @Test
    public void testAdd() {
        Employee employee = new Employee();
//        employee.setId(1L);
        employee.setName("John Smith");
        employee.setAge(33);
        employee.setPosition("Developer");
        employee.setDepartment(new Department(1L, "TestD"));
        employee.setOrganization(new Organization(1L, "TestO", "Test Street No. 1"));
        employee = repository.save(employee);
        Assert.assertNotNull(employee);
        Assert.assertNotNull(employee.getId());
    }

    @Test
    public void testFindAll() {
        Iterable<Employee> employees = repository.findAll();
        Assert.assertTrue(employees.iterator().hasNext());
    }

    @Test
    public void testFindByOrganization() {
        List<Employee> employees = repository.findByOrganizationName("TestO");
        Assert.assertTrue(employees.size() > 0);
    }

    @Test
    public void testFindByName() {
        List<Employee> employees = repository.findByName("John Smith");
        Assert.assertTrue(employees.size() > 0);
    }

}
