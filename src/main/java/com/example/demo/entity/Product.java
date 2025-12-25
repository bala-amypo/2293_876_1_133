@Entity
public class Product {

    @Id @GeneratedValue
    private Long id;

    private String sku;
    private String name;
    private String category;

    private boolean active = true;
}
