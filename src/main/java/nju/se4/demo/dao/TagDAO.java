package nju.se4.demo.dao;

import nju.se4.demo.domain.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagDAO extends JpaRepository<Tag, Integer>{
}
