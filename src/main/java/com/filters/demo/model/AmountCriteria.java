package com.filters.demo.model;

import com.filters.demo.model.enums.ComparisonType;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class AmountCriteria extends Criteria {

    private Integer amount;
    private ComparisonType comparisonType; // Uses GREATER_THAN, LESS_THAN, EQUAL_TO
    
}
