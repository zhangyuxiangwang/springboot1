package com.yi23.springboot.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AllocationOrderDetail implements Serializable {

    private Integer  id, pid, skuId, status, allocationOrderId,
            productStockId, allocationPickingOrderId,
            allocationBoxId, allocationCollectionId, locationId,
            pickAdminId, recheckAdminId, enableDelivery, pickingSort;

    private String productStockCode;

    private LocalDateTime pickTime,recheckTime,addTime;


}
