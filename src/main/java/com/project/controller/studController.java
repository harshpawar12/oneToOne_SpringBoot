package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.model.product;
import com.project.model.student;
import com.project.repo.productRepo;
import com.project.repo.studentRepo;

@RestController
public class studController {

    @Autowired
    private studentRepo Repo;

    @Autowired
    private productRepo proRepo;

  
    student currentStudent; //imp --->this use to setStudent(product).
  

    @RequestMapping("/std")
    public String insertStudent(student Ob) {
    	
    		
    		Repo.save(Ob);
    		currentStudent = Ob;
    	
    	return "Student inserted successfully";
    }

    @RequestMapping("/pro")
    public String insertProduct(product ob1) {
       
        if (currentStudent != null) {
            ob1.setStudents(currentStudent); 
           
            proRepo.save(ob1);
            
            return "Product inserted successfully with link student";
        }
        else
        {
        	System.out.println("Notttttt");
        }
        return "No student found to link with the product!";
    }
//    @RequestMapping("/fetch")
//    public List<product> isFetch(@ModelAttribute product ob)
//    {
//    	List<product>al=proRepo.findAll();
//    	
//    	return al;
//    }
    @RequestMapping("/fetch")
    public List<student> isFetchStu()
    {
    	List<student>al=Repo.findAll();
    	
    	return al;
    }
    @RequestMapping("/serch/{pro_id}")
    public product fetch(@PathVariable int pro_id)
    {
    	product p = proRepo.findById(pro_id).orElse(new product());
    	System.out.println(p);
    	return p;
    }
    
    @RequestMapping("/student/{stud_id}")
    public student fetchstd(@PathVariable int stud_id)
    {
    	student s = Repo.findById(stud_id).orElse(new student());
    	System.out.println(s);
    	return s;
    }
    
    @RequestMapping("/del/{stud_id}")
    public String isdelStud(@PathVariable int stud_id)
    {
    	Repo.deleteById(stud_id);
    	return "Deleted SuccessFully....";
    }
    @RequestMapping("/dell/{pro_id}")
    public String isdelpro(@PathVariable int pro_id)
    {
    	proRepo.deleteById(pro_id);
    	return "product Deleted SuccessFully....";
    }
    //update student
    @RequestMapping("up/{stud_id}")
    public String isUpstud(student ob)
    {
    	student st=Repo.findById(ob.getStud_id()).get();
    	if(!(ob.getStud_name()==null))
    	{
    		st.setStud_name(ob.getStud_name());
    	}else {
    		st.getStud_name();
    	}
    	if(!(ob.getAge()==null))
    	{
    		st.setAge(ob.getAge());
    	}else {
    		st.getAge();
    	}
    	Repo.save(st);
    	return "Student Updated Successfully...!!";
    }
    
  //update product
    @RequestMapping("up1/{pro_id}")
    public String isUpstud1(product ob)
    {
    	product st=proRepo.findById(ob.getPro_id()).get();
    	if(!(ob.getPro_name()==null))
    	{
    		st.setPro_name(ob.getPro_name());
    	}else {
    		st.getPro_name();
    	}
    	if(!(ob.getCategory()==null))
    	{
    		st.setCategory(ob.getCategory());
    	}else {
    		st.getCategory();
    	}
    	if(!(ob.getPrice()==null))
    	{
    		st.setPrice(ob.getPrice());
    	}else {
    		st.getPrice();
    	}
    	proRepo.save(st);
    	return "product Updated Successfully...!!";
    }
    
}