package com.filters.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.filters.demo.model.Filter;
import com.filters.demo.services.FilterService;


@RestController
@RequestMapping("/")
public class FilterController {

    @Autowired
    private FilterService filterService;
    
    // Endpoint to create a new filter
    @PostMapping
    public Filter createFilter(@RequestBody Filter filter) {
        return filterService.saveFilter(filter);
    }

    // Endpoint to get all filters
    @GetMapping
    public List<Filter> getAllFilters() {
        return filterService.getAllFilters();
    }

    // Endpoint to get a filter by ID
    @GetMapping("/{id}")
    public Optional<Filter> getFilterById(@PathVariable Long id) {
        return filterService.getFilterById(id);
    }

    // Endpoint to delete a filter by ID
    @DeleteMapping("/{id}")
    public void deleteFilter(@PathVariable Long id) {
        filterService.deleteFilterById(id);
    }
    
}
