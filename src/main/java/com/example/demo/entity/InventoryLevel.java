@Entity
@Table(uniqueConstraints = {
    @UniqueConstraint(columnNames = {"store_id","product_id"})
})
public class InventoryLevel {

    @Id @GeneratedValue
    private Long id;

    @ManyToOne
    private Store store;

    @ManyToOne
    private Product product;

    private Integer quantity;

    private LocalDateTime lastUpdated;

    @PrePersist
    @PreUpdate
    void updateTime() {
        lastUpdated = LocalDateTime.now();
    }
}
