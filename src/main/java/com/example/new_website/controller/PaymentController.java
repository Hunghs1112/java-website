package com.example.new_website.controller;

import com.example.new_website.model.Course;
import com.example.new_website.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PaymentController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/payment")
    public String paymentPage(@RequestParam("courseId") Long courseId, Model model) {
        Course course = courseService.getCourseById(courseId);
        model.addAttribute("course", course);
        return "payment";
    }

    @PostMapping("/process-payment")
    public String processPayment(@RequestParam("courseId") Long courseId,
                                 @RequestParam("cardNumber") String cardNumber,
                                 @RequestParam("expiryDate") String expiryDate,
                                 @RequestParam("cvv") String cvv,
                                 @RequestParam("httt_ma") String paymentMethod,
                                 @RequestParam("kh_ten") String customerName,
                                 @RequestParam("kh_gioitinh") String customerGender,
                                 @RequestParam("kh_diachi") String customerAddress,
                                 @RequestParam("kh_dienthoai") String customerPhone,
                                 @RequestParam("kh_email") String customerEmail,
                                 @RequestParam("kh_ngaysinh") String customerBirthDate,
                                 @RequestParam("kh_cmnd") String customerId,
                                 Model model) {
        // Simulate payment processing
        Course course = courseService.getCourseById(courseId);
        model.addAttribute("course", course);
        model.addAttribute("paymentMethod", paymentMethod);
        model.addAttribute("customerName", customerName);
        model.addAttribute("customerGender", customerGender);
        model.addAttribute("customerAddress", customerAddress);
        model.addAttribute("customerPhone", customerPhone);
        model.addAttribute("customerEmail", customerEmail);
        model.addAttribute("customerBirthDate", customerBirthDate);
        model.addAttribute("customerId", customerId);
        return "payment_success";
    }
}
