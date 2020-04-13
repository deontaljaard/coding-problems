package codility.ecommerce;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SoldProductsAggregator {

    private final EURExchangeService exchangeService;

    SoldProductsAggregator(EURExchangeService EURExchangeService) {
        this.exchangeService = EURExchangeService;
    }

    SoldProductsAggregate aggregate(Stream<SoldProduct> products) {
        if (products == null)
            products = Stream.empty();

        List<SimpleSoldProduct> simpleSoldProducts = products
                .filter(product -> {
                    if (product.getCurrency() != null && product.getCurrency().matches("[A-Z]*")) {
                        Optional<BigDecimal> rate = exchangeService.rate(product.getCurrency());
                        return rate.filter(bigDecimal -> bigDecimal.compareTo(BigDecimal.ZERO) > 0).isPresent();
                    } else {
                        return false;
                    }
                })
                .map(product -> new SimpleSoldProduct(product.getName(), product.getPrice()))
                .collect(Collectors.toList());

        BigDecimal totalSold = simpleSoldProducts
                .stream()
                .map(SimpleSoldProduct::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        return new SoldProductsAggregate(simpleSoldProducts, totalSold);
    }

}