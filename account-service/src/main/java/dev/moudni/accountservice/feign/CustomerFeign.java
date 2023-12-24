package dev.moudni.accountservice.feign;

import dev.moudni.accountservice.model.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "CUSTOMER-SERVICE", configuration = FeignInterceptor.class)
public interface CustomerFeign  {
    @GetMapping("/customer-api/customer/{id}")
    Customer getCustomer(@PathVariable Long id);

    @GetMapping("/customer-api/customers")
    List<Customer> getCustomers();
}
