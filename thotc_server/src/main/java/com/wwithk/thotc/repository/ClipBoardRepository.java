package com.wwithk.thotc.repository;

import com.wwithk.thotc.dao.ClipboardInfoDao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClipBoardRepository extends JpaRepository<ClipboardInfoDao,Long> {
}
