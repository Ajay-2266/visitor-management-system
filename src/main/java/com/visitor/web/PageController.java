package com.visitor.web;

import com.visitor.entity.Admin;
import com.visitor.entity.CardOperation;
import com.visitor.entity.Visitor;
import com.visitor.service.AdminService;
import com.visitor.service.CardOperationService;
import com.visitor.service.OTPService;
import com.visitor.service.VisitorService;

import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class PageController {

    private final VisitorService visitorService;
    private final AdminService adminService;
    private final CardOperationService cardOperationService;
    private final OTPService otpService;

    @GetMapping("/visitors")
    public String visitorsPage(Model model) {
        model.addAttribute("visitors", visitorService.getAll());
        return "visitors";
    }

    @PostMapping("/visitors/add")
    public String addVisitor(@ModelAttribute Visitor visitor) {
        visitorService.create(visitor);
        return "redirect:/visitors";
    }

    @GetMapping("/admins")
    public String adminsPage(Model model) {
        model.addAttribute("admins", adminService.getAll());
        return "admins";
    }

    @PostMapping("/admins/add")
    public String addAdmin(@ModelAttribute Admin admin) {
        adminService.create(admin);
        return "redirect:/admins";
    }

    @GetMapping("/otp")
    public String otpPage(Model model) {
        model.addAttribute("otps", otpService.getAll());
        return "otp";
    }

    @GetMapping("/cards")
    public String cardsPage(Model model) {
        model.addAttribute("cards", cardOperationService.getAll());
        model.addAttribute("cardOperation", new CardOperation(null, null, new Visitor(), null, null));
        model.addAttribute("visitors", visitorService.getAll());
        return "cards";
    }

    @PostMapping("/cards/add")
    public String addCard(@ModelAttribute CardOperation card) {
        Visitor visitor = null;
        if (card.getVisitor() != null && card.getVisitor().getId() != null) {
            visitor = visitorService.getById(card.getVisitor().getId());
        }
        if (visitor == null) {
            visitor = new Visitor();
            visitor.setName("New Visitor");
            visitor = visitorService.create(visitor);
        }
        card.setVisitor(visitor);
        card.setTimestamp(LocalDateTime.now());
        card.setOperation("ASSIGNED");
        cardOperationService.create(card);
        return "redirect:/cards";
    }
}
