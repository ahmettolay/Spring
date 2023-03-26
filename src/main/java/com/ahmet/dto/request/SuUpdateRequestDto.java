package com.ahmet.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class SuUpdateRequestDto {

    private Long id;
    private  String marka;
    private  double sulfat;
    private double sodyum;
    private double amonyum;
    private double ph;
}
