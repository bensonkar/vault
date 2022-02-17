package com.example.vault.entities;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

//@Entity
@Data
@ToString
public class ItemLoad implements Serializable {
//    @Id
//    @GeneratedValue
//    private Long itemId;
    private String id;
    private String customer_id;
    private String load_amount;
    private String time;
}
