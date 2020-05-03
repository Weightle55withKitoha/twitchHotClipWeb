package com.wwithk.thotc.repository;

import com.wwithk.thotc.dao.TableInfoDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TableInfoRepository extends JpaRepository<TableInfoDao,Long> {

}
