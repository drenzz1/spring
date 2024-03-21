package org.foo.client;

import org.foo.dto.Employee;
import org.foo.dto.Example2;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(url = "https://dummyapi.io", name = "EMPLOYEE-CLIENT")
public interface EmployeeClient {

    @GetMapping("/data/v1/user")
    Employee getEmployee(@RequestHeader("app-id") String id);

    @GetMapping("/data/v1/user/{id}")
    Example2 getEmployee(@RequestHeader("app-id") String id , @PathVariable("id") String id2);



}
