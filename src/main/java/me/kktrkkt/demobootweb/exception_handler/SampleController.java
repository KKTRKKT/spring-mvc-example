package me.kktrkkt.demobootweb.exception_handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletResponse;

@Controller
public class SampleController {

    // 해당 컨트롤러의 예외를 처리하는 핸들러
    // RuntimeException을 가지는 모든 예외를 처리한다
    @ExceptionHandler
    public String sampleExceptionHandler(RuntimeException exception, Model model, HttpServletResponse response) {
        response.setStatus(HttpStatus.BAD_REQUEST.value());
        model.addAttribute("message", "sample error");
        return "error";
    }

    // 예외 발생시 더 구체적인 예외를 먼저 처리한다.
    // ResponseEntity타입으로 리턴하려면 예외를 던진 메소드도 ResponseEntity타입을 반환해야한다.
    @ExceptionHandler(SampleException.class)
    public ResponseEntity<String> sampleExceptionHandler() {
        return ResponseEntity.badRequest().body("sample error");
    }

    @GetMapping("/samples/form")
    public String getSampleForm() throws IllegalArgumentException {
        throw new IllegalArgumentException();
    }

    @GetMapping("/api/samples")
    public ResponseEntity<?> getSample() throws SampleException {
        throw new SampleException();
    }
}
