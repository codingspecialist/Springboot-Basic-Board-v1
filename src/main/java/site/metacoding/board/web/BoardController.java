package site.metacoding.board.web;

import org.springframework.stereotype.Controller;

import lombok.RequiredArgsConstructor;
import site.metacoding.board.domain.BoardRepository;

@RequiredArgsConstructor
@Controller
public class BoardController {

    private final BoardRepository boardRepository;
}
