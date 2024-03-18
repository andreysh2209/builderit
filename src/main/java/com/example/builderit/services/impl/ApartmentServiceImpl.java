package com.example.builderit.services.impl;

import com.example.builderit.enums.RoomType;
import com.example.builderit.services.ApartmentService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ApartmentServiceImpl implements ApartmentService {
    @Override
    public List<String> getRoomTypes() {
        return Arrays.stream(RoomType.values()).map(roomType -> roomType.name()).toList();
    }
}
