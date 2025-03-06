package com.example.demo.Customerlist;

import com.example.demo.Customerlist.UpdateHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UpdateHistoryRepository extends JpaRepository<UpdateHistory, Long> {
    List<UpdateHistory> findByCustomerId(Long customerId);
}
