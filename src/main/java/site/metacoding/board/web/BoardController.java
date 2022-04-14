package site.metacoding.board.web;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
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

    // data를 리턴하는 함수이다.
    // 해당 함수는 ResponseEntity가 붙어서 json을 리턴한다.
    // ViewResolver가 발동하지 않는다. ViewResolver란 @Controller일때 파일을 리턴할 때 자동 실행된다
    @DeleteMapping("/api/board/{id}")
    public ResponseEntity<?> deleteBoard(@PathVariable Integer id) {
        boardRepository.deleteById(id);
        return new ResponseEntity<>("삭제잘되었어요", HttpStatus.OK);
    }

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
