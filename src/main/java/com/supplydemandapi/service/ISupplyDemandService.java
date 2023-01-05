package com.supplydemandapi.service;

import com.supplydemandapi.model.Product;
import com.supplydemandapi.model.ProductAvailability;

public interface ISupplyDemandService {

    public ProductAvailability getProductAvailability(Product product) ;
}
