package com.Ecommerse.Ecommerse.Controller;

import com.Ecommerse.Ecommerse.Domains.Komputer;
import com.Ecommerse.Ecommerse.Dto.AdminKompTmplate;
import com.Ecommerse.Ecommerse.Dto.KompTemplate;
import com.Ecommerse.Ecommerse.Dto.KomputerDto;
import com.Ecommerse.Ecommerse.Service.KomputerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping

public class KomputerController {
    @Autowired
    private KomputerService komputerService;

    @PostMapping("/admin/addKomputer")
    public ResponseEntity saveKomp(@RequestBody KomputerDto komputerDto)
    {
        Komputer komputer=komputerService.saveKomputer(komputerDto);
        return ResponseEntity.ok(komputer);
    }

    @GetMapping("/getOneKomputer")
    public ResponseEntity getInfoKomp(@RequestParam String name)
    {
        List<Komputer> komputers= komputerService.getInfoByName(name);
        return ResponseEntity.ok(komputers);
    }

    @GetMapping("/getAllProductDesctop")

    public ResponseEntity getAllProduct()
    {
        List<KompTemplate> kompTemplates=komputerService.getAllProduct();
        return ResponseEntity.ok(kompTemplates);
    }

    @GetMapping("/getAllProductNotebooks")

    public ResponseEntity getAllNotebook()
    {
        List<KompTemplate> kompTemplates=komputerService.getAllNotebooks();
        return ResponseEntity.ok(kompTemplates);
    }

    @GetMapping("/admin/getAllProductNotebooks")
    public ResponseEntity getAllNoteAdmin()
    {
        List<AdminKompTmplate> adminKompTmplates=komputerService.getAllNoteAdmin();
        return ResponseEntity.ok(adminKompTmplates);
    }

    @GetMapping("/admin/getAllProductDesctop")
    public ResponseEntity getAllDesctopAdmin()
    {
        List<AdminKompTmplate> adminKompTmplates=komputerService.getAllDesctopAdmin();
        return ResponseEntity.ok(adminKompTmplates);
    }



    @PutMapping("/admin/updateProduct")
    public ResponseEntity updateProduct(@RequestBody AdminKompTmplate adminKompTmplate)
    {
        Komputer komputer=komputerService.updateInformation(adminKompTmplate);
        return ResponseEntity.ok(komputer);
    }


//    @CrossOrigin(origins = "http://localhost:8080")
    @DeleteMapping("/admin/delette/{id}")
    public ResponseEntity deleteNote(@PathVariable long id)
    {
        komputerService.deleteNote(id);
        return ResponseEntity.ok("Komputer O'chirildi");
    }

}
