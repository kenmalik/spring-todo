package com.kmlongid.todo_list;

import java.util.ArrayList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

@SpringBootApplication
@Controller
public class TodoApplication {

  private static int currentId = 0;

  private record Item(int id, String content) {
  };

  private static final ArrayList<Item> items = new ArrayList<Item>();

  public static void main(String[] args) {
    SpringApplication.run(TodoApplication.class, args);
  }

  @GetMapping("/")
  public String home(Model model) {
    model.addAttribute("items", items);
    return "home";
  }

  @PostMapping("/add")
  public String add(@RequestParam(name = "item", required = true) String item,
      Model model) {
    Item newItem = new Item(++currentId, item);
    items.add(newItem);
    model.addAttribute("item", newItem);
    return "components :: return-value";
  }

  @DeleteMapping("/delete")
  @ResponseStatus(HttpStatus.OK)
  public void delete(@RequestParam(name = "id", required = true) int id) {
    try {
      Thread.sleep(1000);
    } catch (Exception e) {

    }

    items.removeIf(item -> (item.id() == id));
  }

}
