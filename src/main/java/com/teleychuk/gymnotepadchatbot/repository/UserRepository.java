package com.teleychuk.gymnotepadchatbot.repository;

import com.teleychuk.gymnotepadchatbot.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
