package com.zidio_connection.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zidio_connection.Entity.SubscriptionPlan;
import com.zidio_connection.Entity.User;

@Repository
public interface SubPlanRepository extends JpaRepository<SubscriptionPlan, Long>{

	List<SubPlanRepository>findByUser(User user);
}
