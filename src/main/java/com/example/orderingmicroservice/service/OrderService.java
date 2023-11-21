package com.example.orderingmicroservice.service;

import com.example.orderingmicroservice.DTOs.OrderDTO;
import com.example.orderingmicroservice.model.Orders;
import com.example.orderingmicroservice.model.Product;
import com.example.orderingmicroservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;
    public static class ProductResult {
        private final List<Product> productList;
        private final long total;

        public ProductResult(List<Product> productList, long total) {
            this.productList = productList;
            this.total = total;
        }
    }
        public List<Orders> getAllOrders() {
            return orderRepository.findAll();
        }

        public Optional<Orders> getOrderById(Long id) {
            return orderRepository.findById(id);
        }

        public Orders createOrder(OrderDTO orderDTO) {
            Orders order = new Orders();

            order.setCustomerId(orderDTO.getCustomerId());
            ProductResult pr = mapProductsDTOToEntity(orderDTO.getProductPrices());
            order.setProducts(pr.productList);
            order.setLatitude(orderDTO.getLatitude());
            order.setLongitude(orderDTO.getLongitude());
            order.setTotal(pr.total);
            return orderRepository.save(order);
        }

        private ProductResult mapProductsDTOToEntity(Map<String, Double> productsMap) {
            List<Product> productList = productsMap.entrySet().stream()
                    .map(entry -> {
                        Product product = new Product();
                        product.setName(entry.getKey());
                        product.setPrice(entry.getValue());
                        return product;
                    })
                    .toList();
            long total = (long) productList.stream()
                    .mapToDouble(Product::getPrice)
                    .sum();
            return new ProductResult(productList, total);
        }

        public List<Orders> getOrdersByCustomerId(Long customerId) {
            return orderRepository.findByCustomerId(customerId);
        }
        public Orders updateOrderUbication(long orderId,double latitude,double longitude){
            Optional<Orders> optionarOrder = orderRepository.findById(orderId);
            if (optionarOrder.isPresent()){
                Orders order = optionarOrder.get();
                order.setLongitude(longitude);
                order.setLatitude(latitude);
                orderRepository.save(order);
                return order;
            }else{
                return null;
            }

        }

}
