package controller

import com.metropolitan.dz07.model.Exam
import com.metropolitan.dz07.service.impl.ExamService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

@Controller
@RequestMapping("/")
class ExamController {
    @Autowired
    ExamService examService

    @RequestMapping(method = RequestMethod.GET)
    def examsList(Model model) {
        List<Exam> examsList = examService.findAll()
        model.addAttribute("exams", examsList)
        "index"
    }
}
