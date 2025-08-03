package ru.itmo.wp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itmo.wp.form.NoticeForm;
import ru.itmo.wp.form.validator.NoticeCreationValidator;
import ru.itmo.wp.service.NoticeService;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class NoticePage extends Page {
    private final NoticeService noticeService;
    private final NoticeCreationValidator noticeCreationValidator;

    public NoticePage(NoticeService noticeService, NoticeCreationValidator noticeCreationValidator) {
        this.noticeService = noticeService;
        this.noticeCreationValidator = noticeCreationValidator;
    }

    @InitBinder("noticeForm")
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(noticeCreationValidator);
    }

    @GetMapping("/notice/add")
    public String noticeGet(Model model) {
        model.addAttribute("noticeForm", new NoticeForm());
        return "NoticePage";
    }

    @PostMapping("/notice/add")
    public String noticePost(@Valid @ModelAttribute("noticeForm") NoticeForm NoticeForm,
                             BindingResult bindingResult,
                             HttpSession httpSession) {
        if (bindingResult.hasErrors()) {
            return "NoticePage";
        }

        noticeService.add(NoticeForm);
        setMessage(httpSession, "Notice added successfully");

        return "redirect:/";
    }
}
