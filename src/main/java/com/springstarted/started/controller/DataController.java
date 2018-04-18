package com.springstarted.started.controller;


import com.springstarted.started.Utils.TextUtils;
import com.springstarted.started.exception.ExceptionDefineRuntime;
import com.springstarted.started.exception.ResourceNotFoundexception;
import com.springstarted.started.model.DataTable;
import com.springstarted.started.repository.DataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class DataController {

    @Autowired
    DataRepository repository;

    //Get All Data
    @GetMapping("/data")
    public List<DataTable> getAllData() {
        return repository.findAll();
    }

    //Create a new data
    @PostMapping("/data")
    public DataTable createAData(@Valid @RequestBody DataTable data) {
        List<DataTable> dataList = repository.findAll();
        checkAlredyExists(data, dataList);
        return repository.save(data);
    }

    private void checkAlredyExists(@Valid @RequestBody DataTable data, List<DataTable> dataList) {
        for (DataTable data1 : dataList) {
            if (data1.getEmail().equals(data.getEmail())) {
                throw new ExceptionDefineRuntime("This email", "already exists with", "email field", data.getEmail());
            } else if (data1.getPhone_number().equals(data.getPhone_number())) {
                throw new ExceptionDefineRuntime("This phone number", "already exists with", "phone number field", data.getPhone_number());
            }
        }
    }

    //Get Single data by id
    @GetMapping("/data={id}")
    public DataTable getDataById(@PathVariable(value = "id") Integer id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundexception("Data", "id", id));
    }

    //Update a data
    @PutMapping("/data={id}")
    public DataTable updateDataById(@PathVariable(value = "id") Integer id, @Valid @RequestBody DataTable data) {

        List<DataTable> dataList = repository.findAll();
        DataTable user = repository.findById(id).orElseThrow(() -> new ResourceNotFoundexception("Data", "id", id));
        checkAlredyExists(data, dataList);
        if (!TextUtils.isEmpty(data.getName()))
            user.setName(data.getName());
        if (!TextUtils.isEmpty(data.getEmail()))
            user.setEmail(data.getEmail());
        if (!TextUtils.isEmpty(data.getAddress()))
            user.setAddress(data.getAddress());
        if (!TextUtils.isEmpty(data.getPhone_number()))
            user.setPhone_number(data.getPhone_number());

        return repository.save(user);
    }

    //Delete a Data
    @DeleteMapping("data={id}")
    public ResponseEntity<?> deleteDataById(@PathVariable(value = "id") Integer id) {
        DataTable data = repository.findById(id).orElseThrow(() -> new ResourceNotFoundexception("Data", "id", id));
        repository.delete(data);
        return ResponseEntity.ok().build();
    }
}
