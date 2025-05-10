package com.hidden_treasure_season2.treasure.domain;

import com.google.zxing.WriterException;
import com.hidden_treasure_season2.qr.domain.QRCode;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.io.IOException;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Treasure {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private QRCode qrCode;

    private Treasure(QRCode qrCode) {
        this.qrCode = qrCode;
    }

    public String getQRImage() {
        try {
            return qrCode.toImage();
        } catch (IOException | WriterException e) {
            throw new RuntimeException(e);
        }
    }

    public static Treasure createTreasure() {
        return new Treasure(QRCode.generateNewQR());
    }
}
