package org.internship.market.database.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@NamedQueries({
        @NamedQuery(
                name = "findProductByName",
                query = "from ProductEntity where name=:name"
        ),
        @NamedQuery(
                name = "getAllProducts",
                query = "from ProductEntity"
        ),
        @NamedQuery(
                name = "deleteProductByName",
                query = "delete ProductEntity productEntity where name=:name"
        ),
        @NamedQuery(
                name = "updateProductPrice",
                query = "update ProductEntity productEntity set price=:price where name=:name"
        ),
        @NamedQuery(
                name = "updateStock",
                query = "update ProductEntity productEntity set stock=:stock where name=:name"
        ),
})
@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "products")
public class ProductEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "products_raw_materials",
            joinColumns = {@JoinColumn(name = "product_id")},
            inverseJoinColumns = {@JoinColumn(name = "raw_materials_id")}
    )
    private List<RawMaterialEntity> rawMaterialsList;

    @Column(name = "commercial_excess", nullable = false)
    private double commercialExcess;

    @Column(name = "price", nullable = false)
    private double price;

    @Column(name = "stock")
    private int stock;

    @OneToMany(mappedBy = "product")
    private List<OrdersEntity> ordersEntityList;
}
