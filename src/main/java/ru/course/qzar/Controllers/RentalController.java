package ru.course.qzar.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.course.qzar.Repositories.RentalRepository;
import ru.course.qzar.Models.Rental;
import ru.course.qzar.Models.QZarArena;
import ru.course.qzar.Repositories.QZarRepository;

import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
@RequestMapping("/create")
public class RentalController {
    private final RentalRepository rentalRepository;
    private final QZarRepository QZarRepository;

    @Autowired
    public RentalController(RentalRepository rentalRepository, QZarRepository QZarRepository) {
        this.rentalRepository = rentalRepository;
        this.QZarRepository = QZarRepository;
    }

    @GetMapping
    public String register(Model model) {
        List<QZarArena> QZarArenas = QZarRepository.findAll();
        model.addAttribute("rentals", QZarArenas);
        model.addAttribute("UserForm", new Rental());
        return "create";
    }

    @PostMapping
    public String addAppointment(@ModelAttribute("UserForm") Rental appForm, BindingResult bindingResult, Model model) {
        String phoneNumber = appForm.getPhoneNumber();
        if (phoneNumber.isBlank()) {
            model.addAttribute("error", "Введите номер телефона");
            model.addAttribute("UserForm", new Rental());
            model.addAttribute("qzararena", QZarRepository.findAll());
            return "create";
        }
        Pattern pattern = Pattern.compile("^(\\+7|7|8)?[\\s\\-]?\\(?[489][0-9]{2}\\)?[\\s\\-]?[0-9]{3}[\\s\\-]?[0-9]{2}[\\s\\-]?[0-9]{2}$");
        Matcher match = pattern.matcher(phoneNumber);
        if (!match.matches()) {
            model.addAttribute("error", "Неправильный номер телефона");
            model.addAttribute("UserForm", new Rental());
            model.addAttribute("qzararena", QZarRepository.findAll());
            return "create";
        }

        String name = appForm.getCustomer();
        if (name.isBlank()) {
            model.addAttribute("error", "Введите имя");
            model.addAttribute("UserForm", new Rental());
            model.addAttribute("qzararena", QZarRepository.findAll());
            return "create";
        }

        Date date = appForm.getDate();
        if (date.before(new Date(System.currentTimeMillis()))) {
            model.addAttribute("error", "Указанная дата уже прошла");
            model.addAttribute("UserForm", new Rental());
            model.addAttribute("qzararena", QZarRepository.findAll());
            return "create";
        }
        rentalRepository.saveAndFlush(appForm);
        return "redirect:/";
    }
}
