package com.studentManagement.studentManagement.controller;

import com.studentManagement.studentManagement.entity.Student;
import com.studentManagement.studentManagement.service.StudentService;
import lombok.Getter;
import lombok.Setter;
import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.annotation.RequestAction;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.ocpsoft.rewrite.faces.annotation.Deferred;
import org.ocpsoft.rewrite.faces.annotation.IgnorePostback;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import java.util.ArrayList;
import java.util.List;

@ViewScoped
@Component(value = "studentController")
@ELBeanName(value = "studentController")
@Join(path = "/", to = "/student/student-form.jsf")
@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @Setter
    @Getter
    private List<Student> studentList;

    @Getter
    @Setter
    private List<String> items = new ArrayList<>();

    @Getter
    @Setter
    private String selectedItem;

    @Getter
    @Setter
    private List<String> cityDistricts = new ArrayList<>();

    @Getter
    @Setter
    private Student student;

    @Getter
    @Setter
    private Boolean isEditable ;

    @Getter
    @Setter
    private Boolean isList;

    @Getter
    @Setter
    private Boolean isUpdate;

    @Getter
    @Setter
    private UploadedFile file;

    @PostConstruct
    public void postInit() {
        this.student = new Student();
        isEditable=false;
        isList=true;
        isUpdate=false;
        items.add("Ankara");
        items.add("Gaziantep");
        items.add("Sivas");
        items.add("Van");
        studentList=studentService.getAllStudents();
    }

    @Deferred
    @RequestAction
    @IgnorePostback
    public void loadStudents(){
        studentList=studentService.getAllStudents();
        isEditable=false;
    }

    public void registerStudent() {
        studentService.addStudent(student);
        student = new Student();
        isList=true;
        isEditable=false;
        if (file != null) {
            FacesMessage message = new FacesMessage("Successful", file.getFileName() + " is uploaded.");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
        loadStudents();
    }


    public void cancel() {
        isEditable=false;
        isList=true;
        student = new Student();
    }

    public void handleCityChange(String item) {
        cityDistricts = new ArrayList<>();
        if (item.equals("Ankara")) {
            cityDistricts.add("Ankara - Gölbaşı");
        } else if (item.equals("Gaziantep")) {
            cityDistricts.add("Gaziantep - Nizip");
        }
    }

    public void editDecide(){
        if(!isEditable){
            student=new Student();
        }
    }

    public void deleteStudent(int id){
        studentService.delStudent(id);
        loadStudents();
    }

    public void edit(int id){
        student = studentService.getStudent(id);
        isUpdate=true;
        isEditable=true;
        isList=false;
    }

    public void isListFunc(){
        isList=true;
        isEditable=false;
        loadStudents();
    }

    public void addStudentFunc(){
        isList=false;
        isEditable=true;
        student=new Student();
    }


}
