package dev.moudni.accountservice.entites;

import dev.moudni.accountservice.enums.AccountType;
import dev.moudni.accountservice.model.Customer;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter @AllArgsConstructor @NoArgsConstructor @ToString @Builder
public class Account {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String currency;
    private double balance;
    private AccountType type;
    private Long customerId;
    @Transient
    private Customer customer;
}
