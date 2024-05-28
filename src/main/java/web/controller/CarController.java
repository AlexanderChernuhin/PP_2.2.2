package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarService;
import web.service.CarServiceImpl;

import java.util.List;

@Controller
public class CarController {

    @Autowired
    private CarServiceImpl carService;

    @GetMapping("/cars")
    public String getCars(@RequestParam(value = "count", required = false, defaultValue = "6") int count, ModelMap model) {
        List<Car> allCars = carService.getCarList();
        List<Car> cars = carService.getCars(allCars, count);
        model.addAttribute("cars", cars);
        return "cars";
    }
}
