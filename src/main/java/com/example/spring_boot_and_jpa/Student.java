package com.example.spring_boot_and_jpa;

import jakarta.persistence.*;

import static jakarta.persistence.GenerationType.SEQUENCE;

// class as entity of database
@Entity(name="Student") // it essensial to give your entity a name
@Table(
        name="student",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "student_email_unique"
                        ,columnNames = "email")
        }
)
public class Student {
    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "student_sequence"
    )

    @Column(
            name = "id",
            updatable = false
    )
    private Long id;
    @Column(
            name = "firstName",
            nullable = false

    )
    private String firstName;
    @Column(
            name = "lastName",
            nullable = false

    )
    private String lastName;

    @Column(
            name = "email",
            nullable = false,
            columnDefinition = "TEXT"


    )
    private String email;

    @Column(name = "age")
    private Integer age;


    public Student(
                   String firstName,
                   String lastName,
                   String email,
                   Integer age) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
    }

    public Student() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                '}';
    }
}
