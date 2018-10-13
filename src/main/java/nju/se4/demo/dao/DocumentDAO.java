package nju.se4.demo.dao;

import nju.se4.demo.domain.Document;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentDAO extends JpaRepository<Document, Integer>{

}
