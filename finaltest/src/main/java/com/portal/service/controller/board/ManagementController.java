package com.portal.service.controller.board;

import com.portal.service.model.member.dto.MemberDTO;
import com.portal.service.service.member.ManagementService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.inject.Inject;
import java.util.List;

@Controller
@RequestMapping("/management")
public class ManagementController {
    private final ManagementService managementService;

    @Inject
    public ManagementController(ManagementService managementService) {
        this.managementService = managementService;
    }

    @RequestMapping("list.do")
    public String memberList(Model model) {
        List<MemberDTO> list = managementService.memberList();
        model.addAttribute("list", list);
        return "management/member_list";
    }

    @RequestMapping("write.do")
    public String write() {
        return "management/write";
    }

    @RequestMapping("insert.do")
    public String insert(MemberDTO dto) {
//        System.out.print(dto);
        managementService.insertMember(dto);
        return "redirect:/management/list.do";
    }

    @RequestMapping("view.do")
    public String view(@RequestParam Integer id, Model model) {
        model.addAttribute("dto", managementService.viewMember(id));
        return "management/view";
    }

    @RequestMapping("update.do")
    public String update(MemberDTO dto, Model model) {
//        boolean result = managementService.checkPw(dto.getId(), dto.getPasswd());
//        if (result) {
            managementService.updateMember(dto);
            return "redirect:/management/list.do";
//        } else {
//            System.out.print(dto);
//            model.addAttribute("dto", dto);
//            model.addAttribute("date", managementService.viewMember(dto.getId()).getJoin_date());
//            model.addAttribute("message", "비밀번호를 확인하세요.");
//            return "management/view";
//        }
    }

    @RequestMapping("delete.do")
    public String delete(Integer id, String passwd, Model model) {
//        boolean result = managementService.checkPw(id, passwd);
//        if (result) {
            managementService.deleteMember(id);
            return "redirect:/management/list.do";
//        } else {
//            model.addAttribute("message", "비빌번호를 확인하세요");
//            model.addAttribute("dto", managementService.viewMember(id));
//            return "management/view";
//        }
    }
}
