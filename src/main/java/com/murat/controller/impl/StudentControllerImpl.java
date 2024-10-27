package com.murat.controller.impl;

import com.murat.DTO.DtoStudent;
import com.murat.DTO.DtoStudentIU;
import com.murat.controller.IStudentController;
import com.murat.service.IStudentServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "/rest/api/student")
public class StudentControllerImpl implements IStudentController {


    private final IStudentServices studentServices;
    @Autowired
    public StudentControllerImpl(IStudentServices studentServices){
        this.studentServices=studentServices;
    }

    // Parametre olarak normalde DTO kullaninlir simdilik Student kullaniliyor
    @PostMapping(path = "/save")
    @Override
    public DtoStudent saveStudent(@RequestBody @Valid DtoStudentIU dtoStudentIU) {
        return studentServices.saveStudent(dtoStudentIU);
    }
    @GetMapping(path = "/getlist")
    @Override
    public List<DtoStudent> getStudentList() {
        return studentServices.getStudentList();
    }
    @GetMapping(path="/getbyid/{id}")
    @Override
    public DtoStudent getStudent(@PathVariable(name = "id") Integer id) {
        return studentServices.getStudent(id);
    }
    @DeleteMapping(path ="delete/{id}")
    @Override
    public DtoStudent deleteStudentById(@PathVariable(name = "id") Integer id) {
        return studentServices.deleteStudentById(id);
    }
    @PutMapping(path = "update/{id}")
    @Override
    public DtoStudent updateStudent(@PathVariable(name = "id") Integer id,
                                 @RequestBody @Valid DtoStudentIU student) {
        return studentServices.updateStudent(id,student);
    }


}
