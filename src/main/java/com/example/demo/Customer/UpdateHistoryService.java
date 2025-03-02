package com.example.demo.Customerlist;

import com.example.demo.Customerlist.UpdateHistory;
import com.example.demo.Customerlist.UpdateHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UpdateHistoryService {
    @Autowired
    private UpdateHistoryRepository updateHistoryRepository;

    public List<UpdateHistory> getHistoryByCustomerId(Long customerId) {
        return updateHistoryRepository.findByCustomerId(customerId);
    }

    public void saveUpdateHistory(UpdateHistory updateHistory) {
        updateHistoryRepository.save(updateHistory);
    }
}
