package net.kiel.domain;

import lombok.Data;

import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

/**
 * Created by kiel on 2016. 4. 19..
 */
@Entity
@Data
public class Product {
    @Id
    @GeneratedValue
    private Long id;

    private String productName;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "product_account")
    private List<Account> accounts;
}
