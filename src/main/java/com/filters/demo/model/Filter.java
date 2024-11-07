package com.filters.demo.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class Filter {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name; // optional name for the filter

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore  // Prevent serializing the "filters" field in User
    private User user;

    @OneToMany(mappedBy = "filter", cascade = CascadeType.ALL)
    private List<Criteria> criteria;

}
