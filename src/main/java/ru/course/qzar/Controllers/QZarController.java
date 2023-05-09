package ru.course.qzar.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.course.qzar.Models.QZarArena;
import ru.course.qzar.Repositories.QZarRepository;

import java.util.List;

@Controller
public class QZarController {
    @Autowired
    QZarRepository QZarRepository;
    @GetMapping("/arenas")
    public String arenas(Model model){
        List<QZarArena> QZarArenaList = QZarRepository.findAll();
        model.addAttribute("QZarArenaList", QZarArenaList);
        return "arenas";
    }
}