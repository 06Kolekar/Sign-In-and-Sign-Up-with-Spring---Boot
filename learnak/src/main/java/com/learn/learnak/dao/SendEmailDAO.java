package com.learn.learnak.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.learn.learnak.model.SendEmail;

public interface SendEmailDAO extends JpaRepository<SendEmail, Long> {
}
