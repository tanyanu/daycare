 CREATE TABLE Teacher (
        employee_id INT NOT NULL AUTO_INCREMENT,
        first_name VARCHAR(30) NOT NULL,
        last_name VARCHAR(30) NOT NULL,
        email VARCHAR(30) NOT NULL,
        joining_date DATE NOT NULL,
        annual_review_date DATE,
        avg_rating INT,
        PRIMARY KEY (employee_id)
    );
    
   
 CREATE TABLE Student (
        student_id INT NOT NULL AUTO_INCREMENT,
        first_name VARCHAR(30) NOT NULL,
        last_name VARCHAR(30) NOT NULL,
        address VARCHAR(30) NOT NULL,
        dob DATE NOT NULL,
        age INT NOT NULL,
        registration_date DATE NOT NULL,
        parent_id INT,
        teacher_assigned INT,
        PRIMARY KEY (student_id),
        FOREIGN KEY (parent_id) REFERENCES Parent(parent_id),
        FOREIGN KEY (teacher_assigned) REFERENCES Teacher(employee_id)
    );
    
    
    CREATE TABLE Parent (
        parent_id INT NOT NULL AUTO_INCREMENT,
        first_name VARCHAR(30) NOT NULL,
        last_name VARCHAR(30) NOT NULL,
        email VARCHAR(50) NOT NULL,
        phone bigint NOT NULL,
        PRIMARY KEY (parent_id)
    );
    
    CREATE TABLE Vaccine (
        vaccine_id INT NOT NULL AUTO_INCREMENT,
        name VARCHAR(30) NOT NULL,
        description VARCHAR(30) NOT NULL,
        doses_taken INT NOT NULL,
        total_doses INT NOT NULL,
        doses_taken_dates  VARCHAR(100),
        last_shot_date DATE,
        upcoming_shot_date DATE,
        student_id INT NOT NULL,
        is_vaccinated bit, 
        PRIMARY KEY (vaccine_id),
        FOREIGN KEY (student_id) REFERENCES Student(student_id)
    );
    
    
       CREATE TABLE Feedback (
        feedback_id INT NOT NULL AUTO_INCREMENT,
        employee_id INT NOT NULL,
        rating float NOT NULL,
        review varchar(500) ,
        PRIMARY KEY (feedback_id),
        FOREIGN KEY (employee_id) REFERENCES Teacher(employee_id)
    );
    
      CREATE TABLE studentGroup (
        group_id INT NOT NULL AUTO_INCREMENT,
		group_size INT NOT NULL,
        students_enrolled INT ,
        PRIMARY KEY (group_id)
    );
    
    
    CREATE TABLE classroom (
        class_id INT NOT NULL AUTO_INCREMENT,
		no_of_groups INT NOT NULL,
        groups_enrolled INT ,
        PRIMARY KEY (class_id)
    );
    
      CREATE TABLE ClassroomGroupMapping (
        class_group_id INT NOT NULL AUTO_INCREMENT,
        classroom_id INT NOT NULL,
        group_id INT NOT NULL,
        student_id INT NOT NULL,
        teacher_id INT NOT NULL,
        PRIMARY KEY (class_group_id),
        FOREIGN KEY (student_id) REFERENCES Student(student_id),
        FOREIGN KEY (teacher_id) REFERENCES Teacher(employee_id)
    );
    
    
        alter table parent modify column phone bigint;
        alter table student add column is_deleted boolean default 0;    
        
        alter table teacher add column is_deleted boolean default 0;    
    
    