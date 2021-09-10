package ru.zhegalov.demo.domain;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Data
@Entity
@Accessors(chain = true)
@Table(name = "persons")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(targetEntity = IndividualNumber.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "individual_number_id")
    private IndividualNumber individualNumber;
}
