package com.mkjw.second_project.repository;

import com.mkjw.second_project.domain.TakeRelationship;
import com.mkjw.second_project.domain.TakeRelationshipId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TakeRelationshipRepository extends JpaRepository<TakeRelationship, TakeRelationshipId> {
}
