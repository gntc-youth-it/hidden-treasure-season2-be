package com.hidden_treasure_season2.treasure.repository;

import com.hidden_treasure_season2.treasure.domain.Treasure;
import java.beans.JavaBean;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TreasureRepository extends JpaRepository<Treasure, Long> {

}
