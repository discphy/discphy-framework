package com.discphy.framework.mybatis.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Sort
 */
public class Sort {

    /**
     * orders
     */
    private final List<Order> orders;

    /**
     * @param order order
     */
    private Sort(Order order) {
        this.orders = new ArrayList<>();
        this.orders.add(order);
    }

    private Sort(List<Order> orders) {
        this.orders = orders;
    }

    /**
     * create sort
     * @param direction direction
     * @param property order property name (fieldName)
     * @return sort
     */
    public static Sort by(Direction direction, String property) {
        return new Sort(new Order(direction, property));
    }

    /**
     * create sort Direction default ASC
     * @param property order column name {@link String}
     * @return sort {@link Sort}
     */
    public static Sort by(String property) {
        return Sort.by(Direction.ASC, property);
    }

    /**
     * create sort
     * @param direction direction {@link Direction}
     * @param property order column name {@link String}
     * @return sort {@link Sort}
     */
    public Sort and(Direction direction, String property) {
        this.getOrders().add(new Order(direction, property));
        return new Sort(this.getOrders());
    }

    /**
     * create sort Direction default ASC
     * @param property order column name {@link String}
     * @return sort {@link Sort}
     */
    public Sort and(String property) {
        this.getOrders().add(new Order(Direction.ASC, property));
        return new Sort(this.getOrders());
    }

    /**
     * @return orders {@link List}&lt;{@link Order}&gt;
     */
    public List<Order> getOrders() {
        return this.orders;
    }

    /**
     * ORDER BY ASC, DESC
     */
    public enum Direction {
        /**
         * ORDER BY ASC
         */
        ASC,

        /**
         * ORDER BY DESC
         */
        DESC
    }

    /**
     * ORDER BY Property
     */
    public static class Order {

        /**
         * ORDER BY ASC, DESC
         */
        private final Direction direction;

        /**
         * ORDER BY Column
         */
        private final String property;

        /**
         * @param direction direction {@link Direction}
         * @param property property {@link String}
         */
        public Order(Direction direction, String property) {
            this.direction = direction;
            this.property = property;
        }

        /**
         * @return direction {@link Direction}
         */
        public Direction getDirection() {
            return this.direction;
        }

        /**
         * @return property {@link String}
         */
        public String getProperty() {
            return this.property;
        }
    }

}