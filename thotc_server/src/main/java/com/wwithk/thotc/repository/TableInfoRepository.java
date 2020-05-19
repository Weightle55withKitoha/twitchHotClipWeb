package com.wwithk.thotc.repository;

import com.wwithk.thotc.dao.TableInfoDao;
import org.springframework.data.jpa.repository.JpaRepository;
<<<<<<< HEAD
import org.springframework.stereotype.Repository;

=======
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
>>>>>>> ecd1a91d6fb4cbcd60e02fd14ae1ac1ff27ae2ee
import java.util.Optional;

@Repository
public interface TableInfoRepository extends JpaRepository<TableInfoDao,Long> {
    Optional<TableInfoDao> findBystreamerName(String name);
<<<<<<< HEAD
=======
    @Query("SELECT t FROM TableInfoDao t ORDER BY t.viewerCount DESC")
    List<TableInfoDao> findAllDesc();
>>>>>>> ecd1a91d6fb4cbcd60e02fd14ae1ac1ff27ae2ee
}
