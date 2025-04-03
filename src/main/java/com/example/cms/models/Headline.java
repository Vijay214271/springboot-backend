package com.example.cms.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "headlines")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Headline {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 255)
    private String headline;
}
