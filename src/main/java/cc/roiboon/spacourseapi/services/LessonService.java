package cc.roiboon.spacourseapi.services;


import cc.roiboon.spacourseapi.models.Lesson;
import cc.roiboon.spacourseapi.repositories.LessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class LessonService implements ResourceService<Lesson> {

  @Autowired
  private LessonRepository repository;

  @Override
  public List<Lesson> all() {
    List<Lesson> list = new ArrayList<>();
    repository
        .findAll()
        .forEach(list::add);
    return list;
  }

  @Override
  public Lesson getById(String id) {
    return repository
        .findById(id)
        .orElse(null);
  }

  @Override
  public boolean create(Lesson l) {
    try {
      repository.save(l);
      return true;
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
  }

  @Override
  public boolean updateById(String id, Lesson l) {
    try{
      repository.save(l);
      return true;
    }catch (Exception e) {
      e.printStackTrace();
      return false;
    }
  }

  @Override
  public boolean deleteById(String id) {
    try {
      repository.deleteById(id);
      return true;
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
  }

  public List<Lesson> getByCourseId(String id) {
    return repository.getByCourseId(id);
  }

}
