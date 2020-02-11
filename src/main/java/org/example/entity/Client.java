package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String surname;

    @Column
    private String name;

    @Column
    private String patronymic;

    @Column
    private String passport;

    @Column
    private Integer experience;

    @Column
    private String phoneNumber;

    @Column
    private String address;
}
