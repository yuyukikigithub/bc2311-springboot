package com.vtxlab.bootcamp.bootcampjavadto;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.vtxlab.bootcamp.bootcampjavadto.dto.CatDto;
import com.vtxlab.bootcamp.bootcampjavadto.model.Cat;

public class CatController {
    
    public CatDto getCat() {
    Cat cat = new CatService().getCat();
    String description = "Cat Name:" + cat.getName() + ", Cat Age:" + cat.getAge();
    CatDto catDto = new CatDto(description, "Apple");
    return catDto;
  }

  public Map<String, Integer> getCats() { // String -> name, Integer -> age
    // call getCats();
    List<Cat> cs = new CatService().getCats();
    return cs.stream().collect(Collectors.toMap(e->e.getName(), e->e.getAge()));
  }

  public List<Cat> getCatList(){
    try {
      return new CatService().getCatList();
    } catch (Exception e) {
      return null;
    }
  }
}
