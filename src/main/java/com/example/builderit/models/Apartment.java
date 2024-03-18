package com.example.builderit.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "apartments")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Apartment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", unique = true)
    private String name;
    @OneToMany (mappedBy = "apartment", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Room> rooms=new ArrayList<>();
    @ManyToOne (cascade = CascadeType.REFRESH )
    private User user;
}
