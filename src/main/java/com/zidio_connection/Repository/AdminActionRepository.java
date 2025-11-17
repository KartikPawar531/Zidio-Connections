package com.zidio_connection.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zidio_connection.Entity.AdminActionLog;

@Repository
public interface AdminActionRepository extends JpaRepository<AdminActionLog, Long>{

	List<AdminActionLog>findByAdminId(String adminId);
	List<AdminActionLog>findByTargetUserID(String targetUserId);
}
