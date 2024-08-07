package com.example.HibernateJPA;

import com.example.HibernateJPA.dao.StudentDAO;
import com.example.HibernateJPA.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HibernateJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(HibernateJpaApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){

		return runner->{
			//createStudent(studentDAO);
			createMultipleStudents(studentDAO);
//			readStudent(studentDAO);
//			findAllStudents(studentDAO);
//			findByLastName(studentDAO);
//			update(studentDAO);
//			delete(studentDAO);
//			deleteAll(studentDAO);
		};

	}

	private void deleteAll(StudentDAO studentDAO) {
		studentDAO.deleteAll();
	}

	private void delete(StudentDAO studentDAO) {
		int id=5;
		studentDAO.delete(id);
		System.out.println("Record Deleted");
	}

	private void update(StudentDAO studentDAO) {
		int id=5;
		Student retrievedStudent=studentDAO.findById(id);
		System.out.println("Found student: "+ retrievedStudent);
		retrievedStudent.setEmail("newemail@gmail.com");
		System.out.println("Updated student details: "+retrievedStudent);
		studentDAO.update(retrievedStudent);
	}

	private void findByLastName(StudentDAO studentDAO) {
		System.out.println("The retrieved students are: "+studentDAO.findByLastName("Carl"));
	}

	private void findAllStudents(StudentDAO studentDAO) {
		System.out.println("The retrieved students list are: "+studentDAO.findAll());
	}

	private void readStudent(StudentDAO studentDAO) {
		Student student=new Student("Roberto","Carl","roberto@gmail.com");
		studentDAO.save(student);
		Student retrievedStudent=studentDAO.findById(student.getId());
		System.out.println("The retrieved student details are"+ retrievedStudent);
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		System.out.println("Creating 3 student objects");
		Student tempStudent1=new Student("Nivas","T","nivas@gmail.com");
		Student tempStudent2=new Student("Aswin","Visweswar","aswin@gmail.com");
		Student tempStudent3=new Student("Mukesh","Balaji","mukeshbalaji@gmail.com");
		System.out.println("Saving students");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
	}

	private void createStudent(StudentDAO studentDAO) {
		Student tempStudent=new Student("Siva","Kumar","sk@gmail.com");
		studentDAO.save(tempStudent);
		System.out.println("The id of the student is : "+tempStudent.getId());
	}
}
