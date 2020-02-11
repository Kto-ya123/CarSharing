package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
public class Accident {
    private static final String FORMAT = "YYYY/MM/DD";
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat(FORMAT);

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private Date dateOfAccident;

    @Column
    private Double costOfDamage;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {
            CascadeType.DETACH,
            CascadeType.REFRESH})
    private Contract contract;
}
