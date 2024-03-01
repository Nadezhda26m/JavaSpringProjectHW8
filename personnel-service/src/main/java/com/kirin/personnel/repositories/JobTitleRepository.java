package com.kirin.personnel.repositories;

import com.kirin.personnel.model.JobTitle;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Репозиторий для работы с сущностью JobTitle (должность)
 */
public interface JobTitleRepository extends JpaRepository<JobTitle, Integer> {
}
