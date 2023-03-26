package com.ahmet.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class IftarMenuUpdateRequestDto {
    private Long id;
    private double fiyat;
    private String meze;
    private String icecek;
}
