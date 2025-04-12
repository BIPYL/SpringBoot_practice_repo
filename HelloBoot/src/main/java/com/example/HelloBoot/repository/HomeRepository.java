package com.example.HelloBoot.repository;

import com.example.HelloBoot.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
//<테이블이름, PK 자료형>
public interface HomeRepository extends JpaRepository<Member, Long>{


}

//내장된 findall, 이미 구현되어 있음.
//public class EntityManager implements HomeRepository{
//     public List<Member> findall(){
//  }
//}