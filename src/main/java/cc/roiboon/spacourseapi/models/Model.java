package cc.roiboon.spacourseapi.models;


public interface Model {

  void setId(String id);

  default String getId() {
    return "";
  }
}
