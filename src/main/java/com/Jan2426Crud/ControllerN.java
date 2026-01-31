package com.Jan2426Crud;


import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/abcd")
@RequiredArgsConstructor
public class ControllerN {

    private final ServiceN service;



    //http://localhost:8080/abcd
    @PostMapping
    public ABCD add(@RequestBody @Validated ABCD abcd){
        return service.add(abcd);
    }



    //http://localhost:8080/abcd/addall
    @PostMapping("/addall")
    public List<ABCD> addAll(){
        return service.addAllAsNew();
    }



    //http://localhost:8080/abcd/3
    @GetMapping("/{id}")
    public ABCD findById(@PathVariable int id){
        return service.getABCDById(id);
    }


    //http://localhost:8080/abcd/getall?pageNumber=0&&pageSize=15
    @GetMapping("/getall")
    public Page<ABCD> getALL(@RequestParam(defaultValue = "0") int pageNumber,
                             @RequestParam(defaultValue = "100") int pageSize){
        return service.getALL(pageNumber,pageSize);
    }


    //http://localhost:8080/abcd/group?by=balance
    @GetMapping("/group")
    public ResponseEntity<Map<?,Long>> groupProducts(
            @RequestParam(name = "by") String by) {

        Map<?, Long> response = service.groupByField(by);
        return ResponseEntity.ok(response);
    }


    @DeleteMapping("/delete/{id}")
    public String deleteById(@PathVariable int id){
        service.deleteById(id);
        return "Account With Id No: "+ id + " Deleted Successfully";
    }

}
