package com.library.repo;
import com.library.model.ActivityLog;
import org.springframework.data.mongodb.repository.MongoRepository;
public interface ActivityLogRepository extends MongoRepository<ActivityLog,String>{}