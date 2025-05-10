package com.hidden_treasure_season2.treasure.repository;

import com.hidden_treasure_season2.qr.domain.QRCode;
import com.hidden_treasure_season2.treasure.domain.Treasure;
import com.hidden_treasure_season2.user.domain.User;
import java.beans.JavaBean;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
public interface TreasureRepository extends JpaRepository<Treasure, Long> {

    Optional<Treasure> findByQrCode(QRCode code);
}
