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
    public String view(@RequestParam int id, Model model) {
        model.addAttribute("dto", managementService.viewMember(id));
        return "management/view";
    }

    @RequestMapping("update.do")
    public String update(MemberDTO dto) {
            managementService.updateMember(dto);
            return "redirect:/";
    }

    @RequestMapping("delete.do")
    public String delete(int id) {
            managementService.deleteMember(id);
            return "redirect:/";
    }

    @RequestMapping("cancel.do")
    public String cancel(int id) {
        managementService.cancelMember(id);
        return "redirect:/";
    }

    @RequestMapping("deletenow.do")
    public String deleteNow(int id) {
        managementService.deleteNowMember(id);
        return "redirect:/";
    }


}
