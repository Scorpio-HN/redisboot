package com.cssl.controller;

import com.cssl.entity.Student;
import com.cssl.service.StudentService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import  java.util.Date;
@Controller
@MapperScan(basePackages = "com.cssl.entity")
public class StudentController {
    @Autowired
    private StudentService ss;

    //查询全部的学生
    @RequestMapping("/findAll")
    @ResponseBody
    public List<Student> findAll() {
        return ss.findAll();
    }

    //根据id查询学生
    @RequestMapping("/findById")
    @ResponseBody
    public Student findById(int sid) {
        return ss.findById(sid);
    }

    //根据名字和班级查询学生 模糊查询
    @RequestMapping("/mohu")
    @ResponseBody
    public List<Student> mohu(String sname, String cid) {
        System.out.print("sname:"+sname);
        Map map = new HashMap<String, Object>();
        map.put("sname", sname);
        map.put("cid", cid);
        return ss.mohu(map);
    }

    //根据id删除
    @RequestMapping("/delStu")
    public String delStu(int sid) {
        ss.delStu(sid);
        return "redirect:index.html";
    }

    //根据id-ajax删除
    @RequestMapping("/delStuAajax")
    @ResponseBody
    public int delStuAajax(int sid) {

        return  ss.delStu(sid);
    }

    //修改
    @RequestMapping("/updateStu")
    public String updateStu(Student student) {

        ss.updateStu(student);
        return "redirect:index.html";
    }

    //查询全部的班级
    @RequestMapping("/findAllClass")
    @ResponseBody
    public List<Student> findAllClass() {

        return ss.findAllClass();
    }

    //添加学生信息

    @RequestMapping("/addStu")
    public String addStu(Student student) {
        ss.addStu(student);
        return "redirect:index.html";

    }

    @GetMapping("/hello")
    public String hello(Model model,HttpSession session){
        Student stu=new Student(101,"刘伯温","1685663@qq.com",new Date());
        session.setAttribute("stu",stu);
        model.addAttribute("stu",stu);
        //使用model
        model.addAttribute("userName","普通值，随便给的名字");

        //存储集合
        List<Student> all = ss.findAll();
        model.addAttribute("all",all);

        //存储hashMap
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("aa","测试aa");
        map.put("bb","<a href='http://www.baidu.com'>百度一下</a>");
        map.put("cc",stu);
        map.put("dd",all);

        model.addAttribute("mp",map);


        return "hello";
    }

    @RequestMapping("test/刘伯温")
    public String test2(int id,String name){
        System.out.println("id："+id+",name:"+name);
        return "show";

    }


}
