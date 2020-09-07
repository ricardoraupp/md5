package com.raupp.md5.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.raupp.md5.model.Audio_md5;

	public interface AudioRepository extends CrudRepository<Audio_md5, Integer> {
		
		Audio_md5 findByMd5(@Param("md5") String md5);
	}
