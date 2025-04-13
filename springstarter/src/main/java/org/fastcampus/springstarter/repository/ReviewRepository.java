package org.fastcampus.springstarter.repository;


import org.fastcampus.springstarter.entity.Book;
import org.fastcampus.springstarter.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    //직접 쿼리 메서드를 만들 수 도 있다.
    //지금은 기본적으로 JpaRepository 에서 제공해주는 메서드를 사용하는 방법 실습.


}
