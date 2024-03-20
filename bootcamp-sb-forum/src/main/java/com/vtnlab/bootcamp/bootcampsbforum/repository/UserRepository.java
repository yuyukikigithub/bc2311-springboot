package com.vtnlab.bootcamp.bootcampsbforum.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vtnlab.bootcamp.bootcampsbforum.entity.UserEntity;

@Repository //Bean for component scan
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    // select * from users where username = ?
    UserEntity findByUsername(String username);

    List<UserEntity> findAllByEmailAndPhoneOrderByEmailDesc(String email, String phone);
    
    // @Query("SELECT e FROM User e WHERE e.email= :email and e.phone = :phone")
    List<UserEntity> findAllByEmailOrPhone(String email, String phone, Sort sort);
    
    // JPQL
    // SELECT e FROM UserEntity e WHERE CAST(e.addrLat AS double) > :lat
    @Query("SELECT e FROM UserEntity e WHERE CAST(e.addrLat AS double) > :lat")
    List<UserEntity> findAllByAddrLatGreaterThan(@Param("lat") Double latitute );

    // Native SQL
    @Query(value = "SELECT count(1) FROM USERS u WHERE lower(u.name) LIKE lower(concat(:prefix,'%')) ", nativeQuery = true)
    Long countUserByNameStartWith(@Param("prefix") String prefix);
    
    //Hibernate (implementation class) // make bean into spring context
    //objective: implement JPA interface 

    // @Transactional
    @Modifying
    @Query("UPDATE UserEntity u Set u.email = :newEmail WHERE u.id = :userId")
    void updateUser(@Param("userId") Long id, @Param("newEmail") String email);

}