package com.r3s.trxservice.model.response;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Setter
@Getter
public class TrxRs {
    private UUID id;
    private Date trxDate;
    private int totalAmount;
    private Customer customer;
    private List<Item> items;

    @Setter
    @Getter
    public static class Customer {
        private Long id;
        private String email;
        private String name;
        private String phone;
        private String address;
        private Date createdDate;
        private Date updatedDate;
        private Date deletedDate;
    }

    @Setter
    @Getter
    public static class Item {
        private Long id;
        private String name;
        private String description;
        private int price;
        private List<Category> categories;
    }

    @Setter
    @Getter
    public static class Category {
        private Long id;
        private String name;
    }

}
