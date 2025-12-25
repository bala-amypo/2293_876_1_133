@Entity
public class DemandForecast {

    @Id @GeneratedValue
    private Long id;

    @ManyToOne
    private Store store;

    @ManyToOne
    private Product product;

    private Integer forecastedDemand;
    private LocalDate forecastDate;
}
