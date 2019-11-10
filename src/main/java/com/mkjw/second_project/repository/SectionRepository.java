package com.mkjw.second_project.repository;

import com.mkjw.second_project.domain.Section;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SectionRepository extends JpaRepository<Section, Integer> {
}
