package br.com.globallabs.springwebmvc.rest;

import br.com.globallabs.springwebmvc.Exception.JediNotFoundException;
import br.com.globallabs.springwebmvc.model.Jedi;
import br.com.globallabs.springwebmvc.repository.JediRepository;
import br.com.globallabs.springwebmvc.service.JediService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class JediResource {

    @Autowired
    private JediService service;

    @GetMapping("/api/jedi")
    public List<Jedi> getAllJedi(){
        return service.findAll();
    }

    @GetMapping("/api/jedi/{id}")
    public ResponseEntity<Jedi> getJedi(@PathVariable("id") Long id){
        final Jedi jedi = service.findById(id);
        return ResponseEntity.ok(jedi);
    }
    
    @PostMapping("/api/jedi")
    @ResponseStatus(HttpStatus.CREATED)
    public Jedi createJedi(@Validated @RequestBody Jedi jedi){
        return service.save(jedi);
    }

    @PutMapping("/api/jedi/{id}")
    public ResponseEntity<Jedi> getJedi(@PathVariable("id") Long id,
                                        @Validated @RequestBody Jedi dto){
        final Jedi jedi =service.update(id, dto);
        return ResponseEntity.ok(jedi);
    }

    @DeleteMapping("/api/jedi/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteJedi(@PathVariable("id") Long id){
        service.delete(id);
    }
}
