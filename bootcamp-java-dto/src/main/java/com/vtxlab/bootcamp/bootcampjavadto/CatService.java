package com.vtxlab.bootcamp.bootcampjavadto;

import java.util.ArrayList;
import java.util.List;

import com.vtxlab.bootcamp.bootcampjavadto.model.Cat;


public class CatService {
  public Cat getCat() {
    // call api, read database
    return new Cat("John", 1);
  }

  public List<Cat> getCats() {
    List<Cat> result = new ArrayList<>();
    result.add(getCat());
    result.add(new Cat("jo", 2));
    result.add(new Cat("lo", 3));
    return result;
  }

  public List<Cat> getCatList() throws Exception {
    List<Cat> cats = new ArrayList<>();
    try{
      cats = callJPH();
      return cats;
    }catch(Exception ex){
      throw new Exception();
    }
  }

  public Cat getatList2(int index) throws Exception{
      if (index<0) {
        throw new IllegalArgumentException();
      }
      List<Cat> cats = new ArrayList<>();
      try {
        cats = callJPH();
        if (cats!=null && cats.size()!=0 && index< cats.size()) {
          return cats.get(index);
        }
        throw new Exception();
      } catch (Exception e) {
        throw new Exception();
      }
  }

  public List<Cat> callJPH() {
    return List.of(new Cat("John",2), new Cat("joh", 2));
  }
    
} 