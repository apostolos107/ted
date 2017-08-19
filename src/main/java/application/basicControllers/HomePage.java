package application.basicControllers;

import application.search.Search;
import application.search.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by thanasis on 2/8/2017.
 */
@Controller
public class HomePage {
    SimpleDateFormat dateFormat=new SimpleDateFormat("MM/dd/yyy");
    {
        dateFormat=new SimpleDateFormat("MM/dd/yyy");
    }

    @Autowired
    SearchService searchService;
    @RequestMapping("/")
    String homeController(Model model,
                          @RequestParam("date-range") String dateRange,
                          @RequestParam("place-name") String city,
                          @RequestParam("people") Integer persons
    ){
        return "index";
    }

    @RequestMapping("/result")
    String resultController(Model model,
                            @RequestParam("date-range") String dateRange,
                            @RequestParam("city") String city,
                            @RequestParam("people") Integer people,
                            @RequestParam(value = "max-cost",required = false,defaultValue = "0") Integer maxCost,
                            @RequestParam(value = "wifi",required = false, defaultValue = "false") Boolean wifi,
                            @RequestParam(value = "fridge",required = false, defaultValue = "false") Boolean fridge,
                            @RequestParam(value = "kitchen",required = false, defaultValue = "false") Boolean kitchen,
                            @RequestParam(value = "tv",required = false, defaultValue = "false") Boolean tv,
                            @RequestParam(value = "parking",required = false, defaultValue = "false") Boolean parking,
                            @RequestParam(value = "elevator",required = false, defaultValue = "false") Boolean elevator,
                            @RequestParam(value = "air-condition",required = false, defaultValue = "false") Boolean airCondition
    ){
        Date fromDate=null;
        Date toDate=null;
        String[] splitStr = dateRange.split("-");
        try {
            if(splitStr[0]!=null && splitStr[0]!=""){
                fromDate = dateFormat.parse(splitStr[0]);
            }else{
                return "index";
            }

            if(splitStr[1]!=null && splitStr[1]!=""){
                toDate = dateFormat.parse(splitStr[1]);
            }else{
                return "index";
            }
        } catch (ParseException e) {
            e.printStackTrace();
            return "index";
        }
        System.out.println("model = [" + model + "], dateRange = [" + dateRange + "], city = [" + city + "], people = [" + people + "], maxCost = [" + maxCost + "], wifi = [" + wifi + "], fridge = [" + fridge + "], kitchen = [" + kitchen + "], tv = [" + tv + "], parking = [" + parking + "], elevator = [" + elevator + "], airCondition = [" + airCondition + "]");
//        Iterable pageResults = searchService.getResultList();
//        Search filters = new Search(fromDate,toDate,city,people);
        Search filters = new Search(fromDate,toDate,city,people,wifi,fridge,kitchen,tv,parking,elevator,airCondition,"all",maxCost);
//        Search filters = new Search(fromDate,toDate,city,people,wifi,fridge,kitchen,tv,parking,elevator,airCondition,"good",maxCost);
//        model.addAttribute("results",pageResults);
        model.addAttribute("oldDateStr",dateRange);
        model.addAttribute("oldValues",filters);
        return "result_page";
    }
}
