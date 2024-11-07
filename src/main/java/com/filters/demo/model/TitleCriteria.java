package com.filters.demo.model;

import com.filters.demo.model.enums.ComparisonType;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class TitleCriteria extends Criteria {
    
    private String title;
    private ComparisonType comparisonType; // Uses CONTAINS, STARTS_WITH, ENDS_WITH, etc.
}
