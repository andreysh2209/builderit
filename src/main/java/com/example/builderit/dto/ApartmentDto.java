package com.example.builderit.dto;

import com.example.builderit.models.Room;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApartmentDto {
    private Long id;
    private String name;
    private List<RoomDto> rooms=new ArrayList<>();
}
