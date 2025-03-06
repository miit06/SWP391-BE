package com.children.care.repository;

import com.children.care.entity.Servicedetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepository extends JpaRepository<Servicedetail, String> {
}
