package com.filters.demo.DAL;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.filters.demo.model.Filter;

@Repository
public interface FilterRepository extends JpaRepository<Filter, Long> {
    
        List<Filter> findByUserId(Long userId);

        Optional<Filter> findByIdAndUserId(Long filterId, Long userId);
}
