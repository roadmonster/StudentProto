package com.hao.demo;

import com.hao.demo.models.CollegeStudent;
import com.hao.demo.repository.StudentDao;
import com.hao.demo.service.StudentAndGradeService;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.*;

@TestPropertySource("/application.properties")
@SpringBootTest
public class StudentAndGradeServiceTest {

    @Autowired
    private JdbcTemplate jdbc;

    @Autowired
    private StudentAndGradeService studentService;

    @Autowired
    private StudentDao studentDao;

    @BeforeEach
    public void setupDatabase() {
    
        jdbc.execute("insert into student(firstname, lastname, email_address) " +
                "values ('Eric', 'Roby', 'eric.roby@luv2code_school.com')");
    }

    @AfterEach
    public void setupAfterTransaction() {
        jdbc.execute("DELETE FROM student");
    }
    @Test
    public void createStudentService() {

        studentService.createStudent("Chadddd", "Darby",
                "chad.darby@luv2code_school.com");

        CollegeStudent student = studentDao.
                findByEmailAddress("chad.darby@luv2code_school.com");

        assertEquals("chad.darby@luv2code_school.com",
                student.getEmailAddress(), "find by email");
    }

    @Test
    public void isStudentNullCheck() {

        assertTrue(studentService.checkIfStudentIsNull(1));

        assertFalse(studentService.checkIfStudentIsNull(0));
    }

}

