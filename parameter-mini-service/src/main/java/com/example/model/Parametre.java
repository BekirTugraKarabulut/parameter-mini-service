package com.example.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "parametre")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Parametre {

    @Id
    @Column(name = "code")
    private Long code;

    @Column(name = "parametre_ad")
    private String parametreAd;

}
