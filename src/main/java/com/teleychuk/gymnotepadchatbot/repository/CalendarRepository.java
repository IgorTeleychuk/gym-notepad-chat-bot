package com.teleychuk.gymnotepadchatbot.repository;

import com.teleychuk.gymnotepadchatbot.model.Calendar;
import org.springframework.data.repository.CrudRepository;

public interface CalendarRepository extends CrudRepository<Calendar, Long> {
}
