package site.metacoding.board.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.RequiredArgsConstructor;
import site.metacoding.board.domain.BoardRepository;

@RequiredArgsConstructor
@Controller
public class BoardController {

    private final BoardRepository boardRepository;

    @GetMapping({ "/", "/board" })
    public String boardList() {
        return "boardList";
    }

    @GetMapping("/board/{id}")
    public String boardList(@PathVariable Integer id) {
        return "boardDetail";
    }

    @GetMapping("/board/writeForm")
    public String boardWriteForm() {
        return "boardWriteForm";
    }

    @GetMapping("/board/updateForm")
    public String boardUpdateForm() {
        return "boardUpdateForm";
    }
}
