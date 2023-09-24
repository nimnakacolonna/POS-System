package com.springbootacademytwo.batch7newpos.dto.request;

import com.springbootacademytwo.batch7newpos.entity.enums.MeasuringUnitType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ItemSaveRequestDTO {

    private String itemname;
    private MeasuringUnitType measuringUnitType;
    private double balanceQty;
    private double  supplierPrice;
    private double sellingPrice;




}
