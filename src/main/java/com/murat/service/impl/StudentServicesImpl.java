package com.murat.service.impl;

import com.murat.DTO.DtoStudent;
import com.murat.DTO.DtoStudentIU;
import com.murat.entities.Student;
import com.murat.repository.IStudentRepository;
import com.murat.service.IStudentServices;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServicesImpl implements IStudentServices {


    private final  IStudentRepository studentRepository;

    @Autowired
    public StudentServicesImpl(IStudentRepository studentRepository){
        this.studentRepository=studentRepository;
    }

    @Override
    public DtoStudent saveStudent(DtoStudentIU dtoStudentIU) {
        Student student=new Student();
        BeanUtils.copyProperties(dtoStudentIU, student);
        Student respond=studentRepository.save(student);
        DtoStudent dtoStudent=new DtoStudent();
        BeanUtils.copyProperties(respond,dtoStudent);
        return dtoStudent;
    }

    @Override
    public List<DtoStudent> getStudentList() {
        List<Student> list=studentRepository.findAll();
        List<DtoStudent> respondList=new ArrayList<>();
        for (Student a:list) {
            DtoStudent dtoStudent=new DtoStudent();
            BeanUtils.copyProperties(a,dtoStudent);
            respondList.add(dtoStudent);
        }

        return respondList;
    }

    @Override
    public DtoStudent getStudent(Integer id) {
        Optional<Student> dbStudent=studentRepository.findById(id);
        DtoStudent dtoStudent=new DtoStudent();
        if(dbStudent.isPresent()) {
            Student student=dbStudent.get();
            BeanUtils.copyProperties(student,dtoStudent);

        }
        return dtoStudent;
    }

    @Override
    public DtoStudent deleteStudentById(Integer id) {
        Optional<Student> dbStudent=studentRepository.findById(id);
        DtoStudent dtoStudent=new DtoStudent();
        if(dbStudent.isPresent()){
            Student student=dbStudent.get();
            BeanUtils.copyProperties(student,dtoStudent);
            studentRepository.deleteById(id);

        }
        return dtoStudent;
    }

    @Override
    public DtoStudent updateStudent(Integer id, DtoStudentIU dtoStudentIU) {
        Optional<Student> optionalDbStudent = studentRepository.findById(id);
        Student dbStudent;
        DtoStudent dtoStudent=new DtoStudent();

        if(optionalDbStudent.isPresent()){
            dbStudent=optionalDbStudent.get();
            BeanUtils.copyProperties(dtoStudentIU,dbStudent);
            studentRepository.save(dbStudent);
            BeanUtils.copyProperties(dbStudent,dtoStudent);
        }
        return dtoStudent;
    }


}
