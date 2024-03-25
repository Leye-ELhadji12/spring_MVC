package com.managerhospital;

import com.managerhospital.dao.PatientDAO;
import com.managerhospital.entities.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class ManagerHospitalApplication implements CommandLineRunner {

    @Autowired PatientDAO patientDAO;

    public static void main(String[] args) {
        SpringApplication.run(ManagerHospitalApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        patientDAO.save(new Patient(null,"Moustapha",new Date(),false,"Masculin",230));
        patientDAO.save(new Patient(null,"Youssouf",new Date(),false,"Masculin",243));
        patientDAO.save(new Patient(null,"David",new Date(),true,"Masculin",2123));
        patientDAO.save(new Patient(null,"Marie",new Date(),false,"Feminin",203));

    }
}
