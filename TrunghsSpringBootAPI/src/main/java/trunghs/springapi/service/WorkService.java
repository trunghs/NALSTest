package trunghs.springapi.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import trunghs.springapi.model.Work;

@Repository
public interface WorkService extends JpaRepository<Work, Long>{

}
