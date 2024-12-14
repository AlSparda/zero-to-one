package ru.zero_to_one.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.zero_to_one.entity.ResearchWorker;

public interface ResearchWorkerRepository extends JpaRepository<ResearchWorker, UUID> {

}