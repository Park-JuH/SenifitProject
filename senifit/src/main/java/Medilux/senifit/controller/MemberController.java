package Medilux.senifit.controller;


import Medilux.senifit.domain.Member;
import Medilux.senifit.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/members")
public class MemberController {

    private final MemberRepository memberRepository;

    @Autowired
    public MemberController(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    @PostMapping("/join")
    public String signUpMember(Member member, RedirectAttributes redirectAttributes) {
        Member savedMember = memberRepository.save(member);
        if (savedMember == null) {
            redirectAttributes.addFlashAttribute("errorMessage", "Error: Member name exists.");
            return "redirect:/signup";
        }
        return "redirect:/"; // Redirect after registration
    }


    @PostMapping("/login")
    public String userLogin(Member member, RedirectAttributes redirectAttributes) {
        System.out.println("MemberController.userLogin");
        System.out.println("member = " + member.getUsername());

        if (member.getId() != null)
            return "redirect:/routinePage";
        else
            return "redirect:/";
    }
}
