package com.dreams.product.server.service.impl;

import com.dreams.product.common.DecreaseStockInput;
import com.dreams.product.common.ProductInfoOutput;
import com.dreams.product.server.dataobject.ProductInfo;
import com.dreams.product.server.enums.ProductStatusEnum;
import com.dreams.product.server.enums.ResultEnum;
import com.dreams.product.server.exception.ProductException;
import com.dreams.product.server.repository.ProductInfoRepository;
import com.dreams.product.server.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Override
    public List<ProductInfo> findUpAll() {
        return productInfoRepository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public List<ProductInfoOutput> findList(List<String> productIdList) {
        return productInfoRepository.findByProductIdIn(productIdList).stream()
                .map(e -> {
                    ProductInfoOutput output = new ProductInfoOutput();
                    BeanUtils.copyProperties(e, output);
                    return output;
                })
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void decreaseStock(List<DecreaseStockInput> decreaseStockInputList) {
        for (DecreaseStockInput decreaseStockInput : decreaseStockInputList) {
            /**
             * Spring Boot 2.x
             */
            // Optional<ProductInfo> productInfoOptional = productInfoRepository.findById(cartDTO.getProductId());

            /**
             * Spring Boot 1.x
             */
            Optional<ProductInfo> productInfoOptional = productInfoRepository.findById(decreaseStockInput.getProductId());

            // 1. 判断商品是否存在
            if (productInfoOptional == null) {
                throw new ProductException(ResultEnum.PRODUCT_NOT_EXIST);
            }

            // 2. 判断库存是否足够
            ProductInfo productInfo = productInfoOptional.get();
            Integer result = productInfo.getProductStock() - decreaseStockInput.getProductQuantity();
            if (result < 0) {
                throw new ProductException(ResultEnum.PRODUCT_STOCK_ERROR);
            }

            productInfo.setProductStock(result);
            productInfoRepository.save(productInfo);
        }
    }
}
