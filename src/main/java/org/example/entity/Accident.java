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
    private static final String FORMAT = "YYYY/MM/DD hh:mm";
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat(FORMAT);

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    @DateTimeFormat(pattern = "yyyy/MM/dd hh:mm")
    private Date dateOfAccident;

    @Column
    private Double costOfDamage;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {
            CascadeType.DETACH,
            CascadeType.REFRESH})
    private Contract contract;
}
