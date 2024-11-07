package com.filters.demo.model;

import java.time.LocalDate;

import com.filters.demo.model.enums.ComparisonType;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class DateCriteria extends Criteria {
    
    private LocalDate date;
    private ComparisonType comparisonType; // Uses GREATER_THAN, LESS_THAN, EQUAL_TO
}
