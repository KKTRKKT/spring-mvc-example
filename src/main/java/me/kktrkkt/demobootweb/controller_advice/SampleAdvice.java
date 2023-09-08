package me.kktrkkt.demobootweb.controller_advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletResponse;

@ControllerAdvice(assignableTypes = SampleController.class)
public class SampleAdvice {

    //@InitBinder, @ModelAttribute 등등 지정가능하다

    @ExceptionHandler
    public String sampleExceptionHandler(RuntimeException exception, Model model, HttpServletResponse response) {
        response.setStatus(HttpStatus.BAD_REQUEST.value());
        model.addAttribute("message", "sample error");
        return "error";
    }

    @ExceptionHandler(SampleException.class)
    public ResponseEntity<String> sampleExceptionHandler() {
        return ResponseEntity.badRequest().body("sample error");
    }


}
