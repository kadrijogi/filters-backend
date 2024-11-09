package com.filters.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.filters.demo.model.Filter;
import com.filters.demo.services.FilterService;


@RestController
@RequestMapping("/filters")
@CrossOrigin(origins = "https://kadrijogi.github.io/filters-app")
public class FilterController {

    private final FilterService filterService;

    public FilterController(FilterService filterService) {
        this.filterService = filterService;
    }

    // GET: An endpoint to check backend health
    @GetMapping("/health")
    public String get() {
        return "OK";
    }

    // POST: Create a new filter for a specific user
    @PostMapping("/user/{userId}")
    public ResponseEntity<Filter> createFilterForUser(@PathVariable Long userId, @RequestBody Filter filter) {
        Optional<Filter> createdFilter = filterService.createFilterForUser(userId, filter);

        // If the filter was created successfully, return it with 201 (Created)
        return createdFilter.map(f -> new ResponseEntity<>(f, HttpStatus.CREATED))
                            .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // GET: Get a specific filter by its ID and user ID
    @GetMapping("/user/{userId}/{filterId}")
    public ResponseEntity<Filter> getFilterByIdAndUserId(@PathVariable Long userId, @PathVariable Long filterId) {
        Optional<Filter> filter = filterService.getFilterByIdAndUserId(filterId, userId);

        // If the filter is found, return it with 200 OK
        return filter.map(f -> new ResponseEntity<>(f, HttpStatus.OK))
                            .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // GET: Get all filters for a specific user
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Filter>> getAllFiltersByUserId(@PathVariable Long userId) {
        List<Filter> filters = filterService.getAllFiltersByUserId(userId);

        // If the user has filters, return them with 200 OK
        if (!filters.isEmpty()) {
            return new ResponseEntity<>(filters, HttpStatus.OK);
        }

        // If no filters are found, return 404 (Not Found)
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // PUT: Update an existing filter for a specific user
    @PutMapping("/user/{userId}/{filterId}")
    public ResponseEntity<Filter> updateFilterForUser(@PathVariable Long userId, @PathVariable Long filterId, @RequestBody Filter filterDetails) {
        Optional<Filter> updatedFilter = filterService.updateFilterForUser(userId, filterId, filterDetails);

        // If the filter is updated successfully, return it with 200 OK
        return updatedFilter.map(f -> new ResponseEntity<>(f, HttpStatus.OK))
                            .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // DELETE: Delete a specific filter by its ID and user ID
    @DeleteMapping("/user/{userId}/{filterId}")
    public ResponseEntity<Void> deleteFilterForUser(@PathVariable Long userId, @PathVariable Long filterId) {
        boolean isDeleted = filterService.deleteFilterForUser(userId, filterId);

        // If the filter was deleted successfully, return 204 No Content
        if (isDeleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        // If the filter was not found, return 404 Not Found
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}