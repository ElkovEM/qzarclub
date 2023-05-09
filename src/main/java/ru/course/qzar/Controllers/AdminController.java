package ru.course.qzar.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.course.qzar.Repositories.RentalRepository;
import ru.course.qzar.Models.Rental;
import ru.course.qzar.Models.QZarArena;
import ru.course.qzar.Repositories.QZarRepository;

import java.util.List;

@Controller
public class AdminController {
    @Autowired
    RentalRepository rentalRepository;
    @Autowired
    QZarRepository QZarRepository;

    @GetMapping("/admin")
    public String admin(Model model) {
        List<Rental> rentals = rentalRepository.findAll();
        List<QZarArena> QZarArenas = QZarRepository.findAll();
        model.addAttribute("rentals", rentals);
        model.addAttribute("qzararenas", QZarArenas);
        return "admin";
    }
}
