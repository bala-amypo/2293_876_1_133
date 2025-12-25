@Entity
public class TransferSuggestion {

    @Id @GeneratedValue
    private Long id;

    @ManyToOne
    private Product product;

    @ManyToOne
    private Store sourceStore;

    @ManyToOne
    private Store targetStore;

    private Integer suggestedQuantity;
    private String reason;

    private LocalDateTime generatedAt;

    @PrePersist
    void setTime() {
        generatedAt = LocalDateTime.now();
    }
}
