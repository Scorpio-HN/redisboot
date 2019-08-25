package com.cssl.service;

import com.cssl.entity.Student;

import java.util.List;
import java.util.Map;

public interface StudentService {
    //查询全部的学生
    public List<Student> findAll();

    //根据id查询学生
    public Student findById(int sid);

    //根据名字和班级查询学生 模糊查询
    public  List<Student> mohu(Map<String, Object> map);

    //根据id删除
    public int delStu(int sid);

    //修改
    public int updateStu(Student student);

    //查询全部的班级
    public List<Student> findAllClass();

    //添加学生信息
    public int addStu(Student student);
}
