package com.example.AlbanerooFirst;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Cont {
    @Autowired
    Serv serv;
    @PostMapping("/add-employee")
    public ResponseEntity<String> addEmployee(@RequestBody Model model){
        serv.addEmployee(model);
        return new ResponseEntity<>("Success", HttpStatus.ACCEPTED);
    }
    @PutMapping("/update-employee-name")
    public ResponseEntity<String> updateEmployee(@RequestParam Integer id,@RequestParam String name){
        serv.updateEmployee(id,name);
        return new ResponseEntity<>("Success",HttpStatus.ACCEPTED);
    }
    @GetMapping("/all-employee")
    public ResponseEntity<List<Model>> allEmployee(){
        List<Model> list = serv.allEmployee();
        return new ResponseEntity<>(list,HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/remove-id")
    public ResponseEntity<Model> removeId(@RequestParam Integer id){
        Model model = serv.removeId(id);
        return new ResponseEntity<>(model,HttpStatus.ACCEPTED);
    }

}
