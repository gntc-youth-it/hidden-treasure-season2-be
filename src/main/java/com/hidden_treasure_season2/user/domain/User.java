package com.hidden_treasure_season2.user.domain;

import com.google.zxing.WriterException;
import com.hidden_treasure_season2.qr.domain.QRCode;
import com.hidden_treasure_season2.treasure.domain.Treasure;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Embedded
    private QRCode qrCode;

    @ManyToMany
    @JoinTable(
            name = "treasure_scans",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "treasure_id")
    )
    private Set<Treasure> scannedTreasure = new HashSet<>();

    private Integer catchTimes;

    public String getQRImage() {
        try {
            return qrCode.toImage();
        } catch (IOException | WriterException e) {
            throw new RuntimeException(e);
        }
    }
}
