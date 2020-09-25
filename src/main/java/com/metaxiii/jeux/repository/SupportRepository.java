package com.metaxiii.jeux.repository;

import com.metaxiii.jeux.model.Support;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupportRepository extends JpaRepository<Support, Integer> {
}
