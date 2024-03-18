package com.example.builderit.models;

import com.example.builderit.enums.RoomType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "rooms")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private RoomType roomType;
    @Column(name = "width")
    private Double width;
    @Column(name = "length")
    private Double length;
    @Column(name = "height")
    private Double height;
    @ManyToOne (cascade = CascadeType.REFRESH )
    private Apartment apartment;
    @OneToMany (mappedBy = "room", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Door> doors=new ArrayList<>();
    @OneToMany (mappedBy = "room", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Window> windows=new ArrayList<>();
}
