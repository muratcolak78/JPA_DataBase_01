package com.murat.service;

import com.murat.DTO.DtoStudent;
import com.murat.DTO.DtoStudentIU;
import java.util.List;


public interface IStudentServices {
    public DtoStudent saveStudent(DtoStudentIU student);
    public List<DtoStudent> getStudentList();
    public DtoStudent getStudent(Integer id);
    public DtoStudent deleteStudentById(Integer id);
    public DtoStudent updateStudent(Integer id, DtoStudentIU dtoStudentIU);
}
