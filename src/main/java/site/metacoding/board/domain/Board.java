package site.metacoding.board.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Board {
    private Integer id;
    private String title;
    private String content;
    private String nickname; // 작성자 이름
}
