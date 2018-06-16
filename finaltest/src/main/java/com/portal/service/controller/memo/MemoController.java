package com.portal.service.controller.memo;

import com.portal.service.model.memo.dto.MemoDTO;
import com.portal.service.service.memo.MemoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;
import java.util.List;

@Controller
@RequestMapping("/memo")
public class MemoController {

    private final MemoService memoService;

    @Inject
    public MemoController(MemoService memoService) {
        this.memoService = memoService;
    }

    @RequestMapping("list.do")
    public ModelAndView list() {
        List<MemoDTO> items = memoService.list();
        return new ModelAndView("memo/memo_list", "list", items);
    }

    @RequestMapping("insert.do")
    public String insert(MemoDTO dto) {
        memoService.insert(dto);
        return "redirect:/memo/list.do";
    }

    @RequestMapping("view/{id}")
    public ModelAndView view(@PathVariable int id) {
        return new ModelAndView("memo/view", "dto", memoService.memo_view(id));
    }

    @RequestMapping("update/{id}")
    public String update(@PathVariable int id, MemoDTO dto) {
        memoService.update(dto);
        return "redirect:/memo/list.do";
    }

    @RequestMapping("delete/{id}")
    public String delete(@PathVariable int id) {
        memoService.delete(id);
        return "redirect:/memo/list.do";
    }
}

