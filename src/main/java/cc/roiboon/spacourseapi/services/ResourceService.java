package cc.roiboon.spacourseapi.services;

import cc.roiboon.spacourseapi.models.Model;

import java.util.List;

public interface ResourceService<T extends Model> {
  List<T> all();
  T getById(String id);
  boolean create(T t);
  boolean updateById(String id, T t);
  boolean deleteById(String id);
}
