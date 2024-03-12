package com.example.builderit.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="work_groups")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class WorkGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", unique = true)
    private String name;
    @Column(name = "description")
    private String description;

    @OneToMany (mappedBy = "workGroup", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<SubWorkGroup> subWorkGroups = new ArrayList<>();

    @OneToMany (mappedBy = "workGroup", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Image> images = new ArrayList<>();
}
