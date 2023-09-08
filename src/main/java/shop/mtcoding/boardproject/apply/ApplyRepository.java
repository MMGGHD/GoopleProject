package shop.mtcoding.boardproject.apply;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ApplyRepository extends JpaRepository<Apply, Integer> {

    // @Query(value = "select * from Apply_tb at left outer join posting_tb pt on
    // at.posting_id = pt.id left outer join resume_tb rt on rt.id = at.resume_id
    // where rt.user_id = :userId;", nativeQuery = true)
    // public List<ApplyResponse.TestApplyListDTO> findApplyList(@Param("userId")
    // Integer userId, @Param("postingId") Integer postingId);
    @Query(value = "select * from Apply_tb at left outer join posting_tb pt on at.posting_id = pt.id left outer join resume_tb rt on rt.id = at.resume_id where rt.user_id = :userId", nativeQuery = true)
    List<Apply> findApplyResumeByUserId(@Param("userId") Integer userId);

    @Query(value = "select * from Apply_tb at left outer join posting_tb pt on at.posting_id = pt.id where at.posting_id = :postingId", nativeQuery = true)
    List<Apply> findApplyPostingByPositngId(@Param("postingId") Integer postingId);
    
    List<Apply> findByPostingId(@Param("postingId") Integer postingId);
    
    // @Query(value = "select user_tb.* from user_tb join resume_tb on user_tb.id = resume_tb.user_id join apply_tb on resume_tb.id = apply_tb.resume_id where apply_tb.id = :applyId", nativeQuery = true)
    // User resumeJoinUserJoinApply(@Param("applyId") Integer applyId);
    
}
