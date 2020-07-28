package com.contratus.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.contratus.backend.data.entity.HistoryItem;

public interface HistoryItemRepository extends JpaRepository<HistoryItem, Long> {
}
