package application.init;

import application.Recommendation;
import application.database.initializer.CsvInserts;
import application.database.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.*;

/**
 * Created by thanasis on 31/8/2017.
 */
@Controller
public class InitController {
    @Autowired
    LoginRepository loginRepository;
    @Autowired
    ApartmentRepository apartmentRepository;
    @Autowired
    UserRoleRepository userRoleRepository;
    @Autowired
    AvailabilityRepository availabilityRepository;
    @Autowired
    BookInfoRepository bookInfoRepository;

    @Autowired
    CsvInserts csvInserts;

    @Autowired
    Recommendation recommendation;
    @RequestMapping("/init/all")
    String initAll(){
        csvInserts.loginCsvInsertions("csv/login.csv",loginRepository);
        csvInserts.userRoleCsvInsertions("csv/user_role.csv",loginRepository,userRoleRepository);
        csvInserts.apartmentCsvInsertions("csv/apartment.csv",apartmentRepository,loginRepository);
        csvInserts.availabilityCsvInsertions("csv/availability.csv",availabilityRepository,apartmentRepository);
        csvInserts.bookInfoCsvInsertions("csv/book_info.csv",bookInfoRepository,apartmentRepository,loginRepository);
        return "redirect:/";
    }

    @RequestMapping("/init/all2")
    String initAll2(){
        csvInserts.loginCsvInsertions2("csv/reviews.csv",loginRepository);

        return "redirect:/";
    }


    @RequestMapping("/init/rec")
    String initRec(){
        recommendation.initRec();
        return "redirect:/";
    }

    @RequestMapping("/show/rec")
    String doRec(@RequestParam("user")String username){
        System.out.println("Reco is : " +recommendation.getRec(username));
        return "redirect:/";
    }

    @RequestMapping("/add/rec")
    String addRec(){

        return "redirect:/";
    }

}
