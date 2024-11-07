package com.filters.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "criteria_type")
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "criteriaType")
@JsonSubTypes({
    @JsonSubTypes.Type(value = AmountCriteria.class, name = "AmountCriteria"),
    @JsonSubTypes.Type(value = TitleCriteria.class, name = "TitleCriteria"),
    @JsonSubTypes.Type(value = DateCriteria.class, name = "DateCriteria")
})
public abstract class Criteria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "filter_id")
    @JsonIgnore
    private Filter filter;
    
}
