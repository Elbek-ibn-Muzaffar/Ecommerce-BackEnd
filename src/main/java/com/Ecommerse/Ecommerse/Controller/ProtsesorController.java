package com.Ecommerse.Ecommerse.Controller;

import com.Ecommerse.Ecommerse.Domains.Protsessor;
import com.Ecommerse.Ecommerse.Dto.ProtsessorDto;
import com.Ecommerse.Ecommerse.Service.ProtsessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class ProtsesorController {
    @Autowired
    ProtsessorService protsessorService;

    @PostMapping("/admin/addProtsessor")
    public ResponseEntity saveProtsessor(@RequestBody ProtsessorDto protsessorDto)
    {
        Protsessor protsessor=protsessorService.saveProtsessor(protsessorDto);
        return ResponseEntity.ok(protsessor);
    }

    @GetMapping("/admin/getAllProtsessor")
    public ResponseEntity getAllProtsessor()
    {
        List<Protsessor> protsessors = protsessorService.getAllProtsessor();
        return ResponseEntity.ok(protsessors);
    }
}
