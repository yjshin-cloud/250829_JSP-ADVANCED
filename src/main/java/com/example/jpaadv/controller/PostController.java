package com.example.jpaadv.controller;

import com.example.jpaadv.model.dto.PostDTO;
import com.example.jpaadv.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor // 의존성주입
@RequestMapping("/posts") // posts -> get, post...
public class PostController {
    private final PostService postService;

    @GetMapping // ("/")
    public String list(Model model) {
        model.addAttribute("posts", postService.findAll());
        return "post/list"; // resources/templates/post/list.html
    }

    @GetMapping("/new")
    public String createForm(Model model) {
        // new PostDTO.SaveRequest() -> 빈 생성자
        model.addAttribute("post", new PostDTO.SaveRequest());
        return "post/form"; // resources/templates/post/form.html
    }

    @PostMapping("/new")
    public String create(@ModelAttribute("post") PostDTO.SaveRequest dto) {
        // new PostDTO.SaveRequest() -> 빈 생성자
        postService.save(dto);
        // P-R-G
        return "redirect:/posts";
    }

    @GetMapping("/{id}") // path variable
    public String detail(@PathVariable Long id, Model model) {
        // /{} -> /1 -> 1 -> Long id
        model.addAttribute("post", postService.findById(id));
        return "post/detail";
    }

    @PostMapping("/{id}/delete") // path variable
    public String delete(@PathVariable Long id) {
        postService.delete(id);
        return "redirect:/posts";
    }

    @GetMapping("/{id}/edit") // path variable
    public String updateForm(@PathVariable Long id, Model model) {
        PostDTO.Response postResponse = postService.findById(id);
        // 수정의 대상이 될 원본을 불러와요
        PostDTO.SaveRequest postRequest = new PostDTO.SaveRequest();
        postRequest.setTitle(postResponse.title()); // record
        postRequest.setContent(postResponse.content());
        postRequest.setAuthor(postResponse.author());
        // post에다가 주면 -> form
        model.addAttribute("post", postRequest);
        model.addAttribute("postId", id);
        return "post/form";
    }

    @PostMapping("/{id}/edit") // path variable
    public String update(@PathVariable Long id, @ModelAttribute("post") PostDTO.SaveRequest dto) {
        postService.update(id, dto);
        return "redirect:/posts";
    }
}