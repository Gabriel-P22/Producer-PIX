package com.alura.pix.infrastructure.database.model;

import com.alura.pix.entrypoints.dto.PixDto;
import com.alura.pix.enums.PixStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;
import lombok.Data;

@Entity
@Data
public class Pix {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String identifier;
  private String sourceKey;
  private String destinationKey;
  private Double value;
  private LocalDateTime transferDate;

  @Enumerated(EnumType.STRING)
  private PixStatus status;

  public static Pix toEntity(PixDto dto) {
    Pix pix = new Pix();
    pix.setIdentifier(dto.getIdentifier());
    pix.setSourceKey(dto.getSourceKey());
    pix.setStatus(dto.getStatus());
    pix.setValue(dto.getValue());
    pix.setTransferDate(dto.getTransferDate());
    pix.setDestinationKey(dto.getDestinationKey());
    return pix;
  }
}
