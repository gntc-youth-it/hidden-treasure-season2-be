package com.hidden_treasure_season2.user.domain;

import com.google.zxing.WriterException;
import com.hidden_treasure_season2.common.exception.BadRequestException;
import com.hidden_treasure_season2.common.exception.model.ExceptionCode;
import com.hidden_treasure_season2.qr.domain.QRCode;
import com.hidden_treasure_season2.treasure.domain.Treasure;
import com.hidden_treasure_season2.user.model.request.UserNamingRequest;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "user")
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

    protected User() {
        this.qrCode = QRCode.generateNewQR();
        this.catchTimes = 0;
    }

    public String getQRImage() {
        try {
            return qrCode.toImage();
        } catch (IOException | WriterException e) {
            throw new RuntimeException(e);
        }
    }

    public static User createEmptyUser() {
        return new User();
    }

    public void setName(UserNamingRequest request) {
        this.name = request.getName();
    }

    public void findTreasure(Treasure treasure) {
        if (scannedTreasure.contains(treasure)) {
            throw new BadRequestException(ExceptionCode.TREASURE_ALREADY_FOUND);
        }
        scannedTreasure.add(treasure);
    }

    public void found() {
        catchTimes++;
    }
}
