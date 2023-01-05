package com.supplydemandapi.controller;

import com.supplydemandapi.model.Product;
import com.supplydemandapi.model.ProductAvailability;
import com.supplydemandapi.service.ISupplyDemandService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SupplyDemandController {

    private final Logger logger = LoggerFactory.getLogger(SupplyDemandController.class);
    @Autowired
    private ISupplyDemandService iSupplyDemandService;

    @PostMapping("/getAvailability")
    public ProductAvailability getAvailability(@RequestBody Product product) {
        logger.info("In getAvailability method.");
        return iSupplyDemandService.getProductAvailability(product);
    }
}
