package com.zidio_connection.Service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zidio_connection.DTO.AdminActionDTO;
import com.zidio_connection.Entity.AdminActionLog;
import com.zidio_connection.Repository.AdminActionRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AdminActionService {

	@Autowired
	private AdminActionRepository adminActionRepo;
	
	public AdminActionLog perforanceAction(AdminActionDTO dto) {
		AdminActionLog admin = new AdminActionLog();
		admin.setAdminId(dto.getAdminId());
		admin.setTargetUserID(dto.getTargetUSerId());
		admin.setAction(dto.getAction());
		admin.setTimeStamp(LocalDateTime.now());
		return adminActionRepo.save(admin);
	}

	public List<AdminActionLog>getActionsAdmin(String adminID){
		return adminActionRepo.findByAdminId(adminID);
	}
	
	public List<AdminActionLog>getActionByUser(String targetUserId){
		return adminActionRepo.findByTargetUserID( targetUserId);
	}
}
