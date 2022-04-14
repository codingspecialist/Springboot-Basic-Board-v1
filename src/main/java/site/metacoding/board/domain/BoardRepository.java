package site.metacoding.board.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// JPA가 제공해주는 메서드 사용하자 ....!! 편함!!
@Repository
public interface BoardRepository extends JpaRepository<Board, Integer> {

}
