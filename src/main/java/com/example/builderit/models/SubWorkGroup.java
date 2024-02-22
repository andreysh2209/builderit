package com.example.builderit.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="sub_work_groups")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SubWorkGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", unique = true)
    private String name;
    @Column(name = "description")
    private String description;
    @ManyToOne (cascade = CascadeType.REFRESH )
    private WorkGroup workGroup;
    @OneToMany (mappedBy = "subWorkGroup", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    List<WorkType> workTypes=new ArrayList<>();
}

