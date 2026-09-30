package com.library.repo;
import com.library.model.Borrowal;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface BorrowalRepository extends JpaRepository<Borrowal,Long>{
 List<Borrowal> findByStudentId(Long studentId);
}