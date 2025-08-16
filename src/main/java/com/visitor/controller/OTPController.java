package com.visitor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;
import com.visitor.service.OTPService;

@Controller
@RequestMapping("/otp")
@RequiredArgsConstructor
public class OTPController {
    private final OTPService otpService;

    @PostMapping("/generate")
    public String generateOtp(@RequestParam String phone) {
        otpService.createOtp(phone);
        return "redirect:/otp";
    }

    @PostMapping("/verify")
    public String verifyOtp(@RequestParam String phone, @RequestParam String otpCode, Model model) {
        boolean success = otpService.verifyOtp(phone, otpCode);
        model.addAttribute("message", success ? "OTP Verified!" : "Invalid OTP");
        model.addAttribute("otps", otpService.getAll());
        return "otp";
    }
}

