package com.zidio_connection.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zidio_connection.Entity.BlockListedToken;

@Repository
public interface BlockListedTokenRepository extends JpaRepository<BlockListedToken, Long> {

	public abstract boolean existsByToken(String token); 

}
