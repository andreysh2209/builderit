package com.example.builderit.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomDto {
    private Long id;
    private String roomType;
    private Double width;
    private Double length;
    private Double height;
    private List<DoorDto> doors=new ArrayList<>();
    private List<WindowDto> windows=new ArrayList<>();
}
