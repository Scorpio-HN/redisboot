package com.cssl.service;

import com.cssl.dao.StudentDao;
import com.cssl.entity.Student;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Transactional
@Component
@MapperScan(basePackages = "com.cssl.dao")
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentDao sd;

    @Override
    public List<Student> findAll() {

        return sd.findAll();
    }

    @Override
    public Student findById(int sid) {
        return sd.findById(sid);
    }

    @Override
    public List<Student> mohu(Map<String, Object> map) {

        return sd.mohu(map);
    }

    @Override
    public int delStu(int sid) {
        return sd.delStu(sid);
    }

    @Override
    public int updateStu(Student student) {
        return sd.updateStu(student);
    }

    @Override
    public List<Student> findAllClass() {
        return sd.findAllClass();
    }

    //添加学生信息
    public int addStu(Student student) {
        return sd.addStu(student);
    }
}
