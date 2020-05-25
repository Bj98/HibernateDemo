package com.example.HibernateDemo.repositories;

import com.example.HibernateDemo.models.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends CrudRepository<Post,Integer> {

    List<Post> findByUserId(Integer id);
}
