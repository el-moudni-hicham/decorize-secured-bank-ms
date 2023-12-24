package dev.moudni.accountservice.web;

import dev.moudni.accountservice.entites.Account;
import dev.moudni.accountservice.feign.CustomerFeign;
import dev.moudni.accountservice.model.Customer;
import dev.moudni.accountservice.repository.AccountRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/account-api")
public class AccountController {
    private AccountRepository accountRepository;
    private CustomerFeign customerFeign;

    public AccountController(AccountRepository accountRepository, CustomerFeign customerFeign) {
        this.accountRepository = accountRepository;
        this.customerFeign = customerFeign;
    }

    @GetMapping("/accounts")
    public List<Account> getAccounts(){
        List<Account> accounts = accountRepository.findAll();
        accounts.forEach(account -> {
            Customer customer = customerFeign.getCustomer(account.getCustomerId());
            account.setCustomer(customer);
        });
        return accounts;
    }

    @GetMapping("/account/{id}")
    public Account getAccount(Long id){
        Account account = accountRepository.findById(id).get();
        Customer customer = customerFeign.getCustomer(account.getCustomerId());
        account.setCustomer(customer);
        return account;
    }
}
