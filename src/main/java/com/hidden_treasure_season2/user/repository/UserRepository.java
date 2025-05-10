package com.hidden_treasure_season2.user.repository;

import com.hidden_treasure_season2.qr.domain.QRCode;
import com.hidden_treasure_season2.user.domain.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByQrCode(QRCode code);
}
