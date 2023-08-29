package me.kktrkkt.demobootweb.handler_method.multipart_file;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class FileController {

    @GetMapping("/files")
    public String getFiles(){
        return "multipart/form";
    }

    @PostMapping("/files")
    public String postFiles(@RequestParam MultipartFile file,
                            RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("message", file.getOriginalFilename());
        return "redirect:/files";
    }
}
