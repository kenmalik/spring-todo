package com.kmlongid.todo_list;

import java.util.ArrayList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@SpringBootApplication
@Controller
public class TodoApplication {
  private static final ArrayList<String> items = new ArrayList<String>();

  public static void main(String[] args) {
    SpringApplication.run(TodoApplication.class, args);
  }

  @PostMapping("/add")
  public String test(@RequestParam(name = "item", required = true) String item,
      Model model) {
    items.add(item);
    model.addAttribute("items", items);
    return "list";
  }

}
