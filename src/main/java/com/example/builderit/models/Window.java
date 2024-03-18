package com.example.builderit.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "windows")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Window {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "width")
    private Double width;
    @Column(name = "height")
    private Double height;
    @ManyToOne (cascade = CascadeType.REFRESH )
    private Room room;
}
