package com.zidio_connection.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.zidio_connection.DTO.AdminActionDTO;
import com.zidio_connection.Entity.AdminActionLog;
import com.zidio_connection.Service.AdminActionService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/admins")
@RequiredArgsConstructor
public class AdminActionController {

	@Autowired
	private AdminActionService adminService;

	@PostMapping("/action")
	public ResponseEntity<AdminActionLog> perform(@RequestBody AdminActionDTO dto) {
		return ResponseEntity.ok(adminService.perforanceAction(dto));
	}

	@GetMapping("/logs/admin/{adminId}")
	public ResponseEntity<List<AdminActionLog>> logsByAdmin(@PathVariable String adminId) {
		return ResponseEntity.ok(adminService.getActionsAdmin(adminId));
	}

	@GetMapping("/logs/user/{userId}")
	public ResponseEntity<List<AdminActionLog>> logsByUserId(@PathVariable String userId) {
		return ResponseEntity.ok(adminService.getActionByUser(userId));
	}
}
