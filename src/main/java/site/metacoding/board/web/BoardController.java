package site.metacoding.board.web;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.RequiredArgsConstructor;
import site.metacoding.board.domain.Board;
import site.metacoding.board.domain.BoardRepository;

@RequiredArgsConstructor
@Controller
public class BoardController {

    private final BoardRepository boardRepository;

    @GetMapping({ "/", "/board" })
    public String boardList(Model model) {
        model.addAttribute("boards", boardRepository.findAll());
        return "boardList";
    }

    @GetMapping("/board/{id}")
    public String boardList(@PathVariable Integer id, Model model) {
        Optional<Board> boardOp = boardRepository.findById(id);

        if (boardOp.isPresent()) {
            model.addAttribute("board", boardOp.get());
        } else { // 없으면?
            return "error";
        }

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

    @PostMapping("/board")
    public String boardWrite(Board board) { // title, content, nickname 받기
        boardRepository.save(board);
        return "redirect:/";
    }
}
