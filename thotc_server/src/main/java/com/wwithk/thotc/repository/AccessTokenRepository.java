package com.wwithk.thotc.repository;

import com.wwithk.thotc.dao.AccessTokenDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccessTokenRepository extends JpaRepository<AccessTokenDao,Long> {
    Optional<AccessTokenDao> findById(Long id);

    @Query(value = "select * from ACCESS_TOKEN_DAO LIMIT 1",nativeQuery = true)
    AccessTokenDao findFirstElement();
}
