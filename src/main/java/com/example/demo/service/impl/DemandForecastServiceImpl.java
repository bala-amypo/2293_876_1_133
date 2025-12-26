@Override
public List<DemandForecast> getForecastsForStore(Long storeId) {
    return repository.findByStoreId(storeId);
}
