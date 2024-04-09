package Medilux.senifit.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Getter
@NoArgsConstructor
public class Member {

    public Member(Long id, @NonNull String username, @NonNull int age, String phone, Gender gender, Experience exp, int cycle) {
        this.id = id;
        this.username = username;
        this.age = age;
        this.phone = phone;
        this.gender = gender;
        this.exp = exp;
        this.cycle = cycle;
    }

    @Id @GeneratedValue
    private Long id;

    @NonNull
    private String username;

    @NonNull
    private int age;

    private String phone;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Enumerated(EnumType.STRING)
    private Experience exp;

    private int cycle;

    public enum Gender {
        MALE, FEMALE
    }

    public enum Experience {
        BEGINNER, INTERMEDIATE, ADVANCED
    }
}
