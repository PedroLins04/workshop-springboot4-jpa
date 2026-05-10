package com.web.backweb.resources;

import com.web.backweb.entities.User;
import com.web.backweb.services.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.xml.stream.Location;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResources {

    @Autowired
    private userService service;

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        List<User> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{Id}")
    public ResponseEntity<User> findById(@PathVariable Long Id) {
         User obj = service.findById(Id);
         return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<User> Insert (@RequestBody User obj){
        obj = service.Insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @DeleteMapping(value = "/{Id}")
    public ResponseEntity<Void> Delete (@PathVariable Long Id) {
        service.Delete(Id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{Id}")
    public ResponseEntity<User> Update (@PathVariable Long Id,@RequestBody User obj ) {
        obj = service.Update(Id, obj);
        return ResponseEntity.ok().body(obj);
    }

}
