package dev.moudni.accountservice.model;

import lombok.*;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor @ToString @Builder
public class Customer {
    private Long id;
    private String name;
    private String email;
}
