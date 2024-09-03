package com.question.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.question.entity.UserInfo;

public interface userInfoRepository extends JpaRepository<UserInfo, Long> 
{
	Optional<UserInfo> findByNm(String nm);
}
