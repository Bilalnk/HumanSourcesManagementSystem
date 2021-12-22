package com.kodlama.hrms;

import com.google.common.base.Predicate;
import com.kodlama.hrms.business.abstracts.SchoolDepartmentService;
import com.kodlama.hrms.entities.concretes.Department;
import com.kodlama.hrms.entities.concretes.School;
import com.kodlama.hrms.entities.concretes.SchoolDepartment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
/*
@Configuration
@EnableJpaRepositories(basePackages = {"com/kodlama/hrms/dataAccess"})
*/
public class HrmsApplication {

   /* private SchoolDepartmentService departmentService;

    @Autowired
    public HrmsApplication(SchoolDepartmentService departmentService) {
        this.departmentService = departmentService;
    }
*/
   /* public void add() {

        SchoolDepartment schoolDepartment;

        for (int i = 1; i < 190; i++) {

            int randomId = (int) (Math.random() * 500) + 1;

            Department department = new Department();
            department.setId(randomId);

            School school = new School();
            school.setId(i);

            schoolDepartment = new SchoolDepartment();
            schoolDepartment.setDepartment(department);
            schoolDepartment.setSchool(school);

            this.departmentService.add(schoolDepartment);

        }
    }*/

    public static void main(String[] args) {
        SpringApplication.run(HrmsApplication.class, args);
    }

    @Bean
    public Docket api() {
       /* for (int i = 0; i < 50; i++) {

            add();
        }*/
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis((Predicate<RequestHandler>) RequestHandlerSelectors.basePackage("com.kodlama.hrms"))
                .paths((Predicate<String>) PathSelectors.any())
                .build();
    }

}
