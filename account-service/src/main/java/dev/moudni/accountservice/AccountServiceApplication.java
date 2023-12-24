package dev.moudni.accountservice;

import dev.moudni.accountservice.entites.Account;
import dev.moudni.accountservice.enums.AccountType;
import dev.moudni.accountservice.repository.AccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@EnableFeignClients
public class AccountServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(AccountRepository accountRepository){
        return args -> {
            accountRepository.saveAll(
                    List.of(
                            Account.builder().customerId(1L).balance(1000).currency("MAD").type(AccountType.CURRENT).build(),
                            Account.builder().customerId(2L).balance(2000).currency("EUR").type(AccountType.SAVING).build(),
                            Account.builder().customerId(1L).balance(3000).currency("USD").type(AccountType.CURRENT).build()
                    )
            );
        };
    }
}
