package com.example.rest.respitory;

import com.example.rest.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRespitory extends JpaRepository<Book,Long> {
}
