package com.leomarqz.bank.notification.repository;

import com.leomarqz.bank.notification.entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface INotificationRepository extends JpaRepository<Notification, Long> {


}
