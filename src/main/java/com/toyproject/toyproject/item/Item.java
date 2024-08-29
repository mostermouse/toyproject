package com.toyproject.toyproject.item;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Item {
    private final String name;
    private Integer size;
    private String description;
}
