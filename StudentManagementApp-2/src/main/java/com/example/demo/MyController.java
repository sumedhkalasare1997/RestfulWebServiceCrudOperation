package com.example.demo;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
	
	@Autowired
	StudentRepo studentRepo;
	
	@GetMapping("getAllStudents")
	public List<Student> getAllStudents()
	{
		  List<Student> students=studentRepo.findAll();
		  return students;
	}
	
	@RequestMapping("saveStudents")
	public Student saveStudent(@RequestBody Student student)
	{
		try {
		    return studentRepo.save(student);
		      
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
		
	}
	
	@RequestMapping("getStudentById/{id}")
	public Student getStudentById(@PathVariable int id)
	{
		 try {
			Student student=studentRepo.findById(id).get();
			return student;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
	
	@RequestMapping("updateStudent/{id}/{marks}")
	public Student updateStudent(@PathVariable int id,@PathVariable int marks)
	{
		try {
			Student student=studentRepo.findById(id).get();
			student.marks=marks;
			studentRepo.save(student);
			return student;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;

		}
		
		
	}
	
	@RequestMapping("delete/{id}")
	public String deleteStudent(@PathVariable int id)
	{
		try {
			studentRepo.deleteById(id);
			return "Student Deleted Successfully";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "Student not deleted";
		}
		
	}

}

