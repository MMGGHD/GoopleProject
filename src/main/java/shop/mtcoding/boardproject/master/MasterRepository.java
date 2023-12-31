package shop.mtcoding.boardproject.master;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import shop.mtcoding.boardproject.resume.Resume;

public interface MasterRepository extends JpaRepository<Master, Integer> {

    @Query(value = "select * from master_tb where user_id= :id", nativeQuery = true)
    List<Master> findByUserId(@Param("id") Integer id);

}
