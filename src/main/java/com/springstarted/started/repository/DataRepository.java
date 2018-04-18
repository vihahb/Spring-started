package com.springstarted.started.repository;

import com.springstarted.started.model.DataTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataRepository extends JpaRepository<DataTable, Integer> {
}
