package com.epam.tc.hw7.entities;

import java.util.Arrays;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MetalAndColors {

    private List<Integer> summary;
    private List<String> elements;
    private String color;
    private String metals;
    private List<String> vegetables;

    @Override
    public String toString() {
        return String.format("Summary: %s\nElements: %s\nColor: %s\nMetal: %s\nVegetables: %s",
                summary.stream().reduce(0, Integer::sum),
                Arrays.toString(elements.toArray()), color, metals,
                Arrays.toString(vegetables.toArray())).replaceAll("[\\[\\]]", "");
    }
}
