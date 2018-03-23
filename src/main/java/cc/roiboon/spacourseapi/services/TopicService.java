package cc.roiboon.spacourseapi.services;


import cc.roiboon.spacourseapi.models.Topic;
import cc.roiboon.spacourseapi.repositories.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class TopicService implements ResourceService<Topic> {

  @Autowired
  private TopicRepository repository;

  @Override
  public List<Topic> all() {
    List<Topic> list = new ArrayList<>();
    repository
        .findAll()
        .forEach(list::add);
    return list;
  }

  @Override
  public Topic getById(String id) {
    return repository
        .findById(id)
        .orElse(null);
  }

  @Override
  public boolean create(Topic t) {
    try {
      repository.save(t);
      return true;
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
  }

  @Override
  public boolean updateById(String id, Topic t) {
    try{
      repository.save(t);
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

}
