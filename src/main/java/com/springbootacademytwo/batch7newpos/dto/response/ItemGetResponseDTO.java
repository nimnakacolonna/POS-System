package com.springbootacademytwo.batch7newpos.dto.response;

import com.springbootacademytwo.batch7newpos.entity.enums.MeasuringUnitType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ItemGetResponseDTO {


    private int itemId;
    private String itemname;
    private double balanceQty;
    private double supplierPrice;
    private double sellingPrice;
    private boolean active;
}
