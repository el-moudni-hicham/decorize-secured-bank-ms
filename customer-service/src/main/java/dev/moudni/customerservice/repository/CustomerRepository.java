package dev.moudni.customerservice.repository;

import dev.moudni.customerservice.entites.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
