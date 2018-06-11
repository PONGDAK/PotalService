package com.portal.service.controller;

import com.portal.service.model.dto.MemberDTO;
import com.portal.service.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.inject.Inject;
import java.util.List;

@Controller
public class MemberController {

    @Inject
    MemberService memberService;

    @RequestMapping("member/list.do")
    public String memberList(Model model) {
        List<MemberDTO> list = memberService.memberList();
        model.addAttribute("list", list);
        return "member/member_list";
    }

    @RequestMapping("member/write.do")
    public String write() {
        return "member/write";
    }

    @RequestMapping("member/insert.do")
    public String insert(MemberDTO dto) {
//        System.out.print(dto);
        memberService.insertMember(dto);
        return "redirect:/member/list.do";
    }

    @RequestMapping("member/view.do")
    public String view(@RequestParam Integer id, Model model) {
        model.addAttribute("dto", memberService.viewMember(id));
        return "member/view";
    }

    @RequestMapping("member/update.do")
    public String update(MemberDTO dto, Model model) {
        boolean result =
                memberService.checkPw(dto.getId(), dto.getPasswd());
        if (result) {
            memberService.updateMember(dto);
            return "redirect:/member/list.do";
        } else {
            System.out.print(dto);
            model.addAttribute("dto", dto);
            model.addAttribute("date", memberService.viewMember(dto.getId()).getDate());
            model.addAttribute("message", "비밀번호를 확인하세요.");
            return "member/view";
        }
    }

    @RequestMapping("member/delete.do")
    public String delete(Integer id, String passwd, Model model) {
        boolean result = memberService.checkPw(id,passwd);
        if(result){
            memberService.deleteMember(id);
            return "redirect:/member/list.do";
        }else{
            model.addAttribute("message", "비빌번호를 확인하세요");
            model.addAttribute("dto", memberService.viewMember(id));
            return "member/view";
        }
    }
}

