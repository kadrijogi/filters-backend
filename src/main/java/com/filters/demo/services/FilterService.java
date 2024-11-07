package com.filters.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.filters.demo.DAL.FilterRepository;
import com.filters.demo.DAL.UserRepository;
import com.filters.demo.model.Filter;

@Service
public class FilterService {

    private final FilterRepository filterRepository;
    private final UserRepository userRepository;

    public FilterService(FilterRepository filterRepository, UserRepository userRepository) {
        this.filterRepository = filterRepository;
        this.userRepository = userRepository;
    }

    // Create a new filter for a specific user
    @Transactional
    public Optional<Filter> createFilterForUser(Long userId, Filter filter) {
        return userRepository.findById(userId).map(user -> {
            filter.setUser(user);  // Associate filter with user
            filter.getCriteria().forEach(criteria -> criteria.setFilter(filter)); // Associate each criteria with filter
            return filterRepository.save(filter);
        });
    }

    // Get all filters for a specific user
    public List<Filter> getAllFiltersByUserId(Long userId) {
        return filterRepository.findByUserId(userId);
    }

    // Get a specific filter by ID and user
    public Optional<Filter> getFilterByIdAndUserId(Long filterId, Long userId) {
        return filterRepository.findByIdAndUserId(filterId, userId);
    }

    // Update an existing filter for a specific user
    @Transactional
    public Optional<Filter> updateFilterForUser(Long userId, Long filterId, Filter filterDetails) {
        return filterRepository.findByIdAndUserId(filterId, userId).map(existingFilter -> {
            existingFilter.setName(filterDetails.getName());
            existingFilter.setCriteria(filterDetails.getCriteria());

            filterDetails.getCriteria().forEach(criteria -> criteria.setFilter(existingFilter)); // Set filter reference for each criteria
            return filterRepository.save(existingFilter);
        });
    }

    // Delete a specific filter by ID and user
    @Transactional
    public boolean deleteFilterForUser(Long userId, Long filterId) {
        return filterRepository.findByIdAndUserId(filterId, userId).map(filter -> {
            filterRepository.delete(filter);
            return true;
        }).orElse(false);
    }
}
    

