package site.metacoding.board.domain;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;

// interface로 안만들고 클래스로!!
@RequiredArgsConstructor
@Repository
public class BoardRepository {
    // 아래 클래스로 직접 쿼리를 작성할 수 있다.
    private final EntityManager em;
}
