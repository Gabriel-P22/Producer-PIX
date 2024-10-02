package com.alura.pix.entrypoints.dto;

import com.alura.pix.enums.PixStatus;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class PixDto {
  private String identifier;
  private String sourceKey;
  private String destinationKey;
  private Double value;
  private LocalDateTime transferDate;
  private PixStatus status;
}
