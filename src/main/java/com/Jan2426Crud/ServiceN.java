package com.Jan2426Crud;


import org.springframework.cache.annotation.Cacheable;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class ServiceN {

    private final   Repo repo;

//    public ServiceN(Repo repo) {
//        this.repo = repo;
//    }

    public ABCD add(ABCD abcd){
        return repo.save(abcd);
    }

    public List<ABCD> addAllAsNew() {
        List<ABCD> list = repo.findAll();

        List<ABCD> newEntities = list.stream()
                .map(x -> {
                    ABCD copy = new ABCD();
                    copy.setName(x.getName());                  // copy fields
                    copy.setBalance(x.getBalance() + 123);     // modify balance
                    return copy;                               // id is null -> new entity
                })
                .collect(Collectors.toList());

        return repo.saveAll(newEntities);  // inserts new rows
    }


    @Cacheable(value = "abcd", key = "#id")
    public ABCD getABCDById(int id) {
        System.out.println("Fetching from DB..._______________________________________________________________"); // You'll see this only once
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }


    public Page<ABCD> getALL(int pageNummber, int size){

         Pageable pageable = PageRequest.of(pageNummber,size);
         return repo.findAll(pageable);
    }

    public Map<?, Long> groupByField(String field) {
        List<ABCD> products = repo.findAll();

        switch (field.toLowerCase()) {
            case "balance":
                return products.stream()
                        .collect(Collectors.groupingBy(
                                ABCD::getBalance,
                                Collectors.counting()
                        ));

            case "name":
                return products.stream()
                        .collect(Collectors.groupingBy(
                                ABCD::getName,
                                Collectors.counting()
                        ));

            default:
                throw new IllegalArgumentException("Invalid group by field: " + field);
        }
    }

    public String deleteById(int id){
        repo.deleteById(id);;
        return "Account With Id No: "+ id + " Deleted Successfully";
    }



}
