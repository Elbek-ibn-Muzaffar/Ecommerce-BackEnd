package com.Ecommerse.Ecommerse.Controller;

import com.Ecommerse.Ecommerse.Domains.Texnika;
import com.Ecommerse.Ecommerse.Dto.TexnikaDto;
import com.Ecommerse.Ecommerse.Service.TexnikaService;
import org.graalvm.compiler.lir.alloc.lsra.LinearScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class TexnikaController {
    @Autowired
    TexnikaService texnikaService;

    @PostMapping("/admin/addTexnika")
    public ResponseEntity saveTexnika(TexnikaDto texnikaDto)
    {
        Texnika texnika=texnikaService.saveTexnika(texnikaDto);
        return ResponseEntity.ok(texnika);
    }

    @GetMapping("/admin/getAllTexnika")
    public ResponseEntity getAllTexnika()
    {
        List<Texnika> texnikas=texnikaService.getAllTexnika();
        return ResponseEntity.ok(texnikas);
    }
}
