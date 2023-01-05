package com.supplydemandapi.service;

import com.supplydemandapi.exception.NoQuantityAvailableException;
import com.supplydemandapi.model.Demand;
import com.supplydemandapi.model.Product;
import com.supplydemandapi.model.ProductAvailability;
import com.supplydemandapi.model.Supply;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class SupplyDemandServiceImpl implements ISupplyDemandService {

    private final Logger logger = LoggerFactory.getLogger(SupplyDemandServiceImpl.class);
    private final List<Supply> supplyList = Arrays.asList(
            new Supply("Product1",10.0),
            new Supply ("Product2",5.0)
    );
    private final List<Demand> demandList = Arrays.asList(
            new Demand("Product1",2.0),
            new Demand("Product2",5.0)
    );
    @Override
    public ProductAvailability getProductAvailability(Product product) {
        logger.info("In getProductAvailability method");
        ProductAvailability productAvailability = new ProductAvailability();
        double availability = 0.0;
        Double supplyQty = getSupplyQuatity(supplyList, product.getProductId());
        Double demandQty = getDemandQuatity(demandList, product.getProductId());
        availability = supplyQty-demandQty;
        if(availability != 0.0) {
            logger.info("Required Quantity is available for the product");
            productAvailability.setAvailability(availability);
            productAvailability.setProductId(product.getProductId());
        } else {
            logger.error("No quantity available for the product");
            throw new NoQuantityAvailableException("No Content");
        }
        return productAvailability;
    }

    private Double getSupplyQuatity(List<Supply> supplyList, String productName) {
        return supplyList.stream()
                .filter(supply -> supply.getProductId().equals(productName))
                .map(Supply::getQuantity).findAny().get();
    }

    private Double getDemandQuatity(List<Demand> demandList, String productName) {

        return demandList.stream()
                .filter(supply -> supply.getProductId().equals(productName))
                .map(Demand::getQuantity).findAny().get();
    }
}
