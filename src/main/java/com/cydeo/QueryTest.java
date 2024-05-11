package com.cydeo;

import com.cydeo.enums.CartState;
import com.cydeo.enums.DiscountType;
import com.cydeo.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Arrays;

@Component
public class QueryTest implements CommandLineRunner {

    private final AddressRepository addressRepository;
    private final BalanceRepository balanceRepository;
    private final CartItemRepository cartItemRepository;
    private final CartRepository cartRepository;
    private final CategoryRepository categoryRepository;
    private final CustomerRepository customerRepository;
    private final DiscountRepository discountRepository;
    private final OrderRepository orderRepository;
    private final PaymentRepository paymentRepository;
    private final ProductRepository productRepository;


    public QueryTest(AddressRepository addressRepository, BalanceRepository balanceRepository,
                     CartItemRepository cartItemRepository, CartRepository cartRepository,
                     CategoryRepository categoryRepository, CustomerRepository customerRepository,
                     DiscountRepository discountRepository, OrderRepository orderRepository,
                     PaymentRepository paymentRepository, ProductRepository productRepository) {
        this.addressRepository = addressRepository;
        this.balanceRepository = balanceRepository;
        this.cartItemRepository = cartItemRepository;
        this.cartRepository = cartRepository;
        this.categoryRepository = categoryRepository;
        this.customerRepository = customerRepository;
        this.discountRepository = discountRepository;
        this.orderRepository = orderRepository;
        this.paymentRepository = paymentRepository;
        this.productRepository = productRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("====================AddressRepository================");
        System.out.println(addressRepository.getAllByCustomer(7L));
        System.out.println(addressRepository.getAllByCustomer(7L).get(0).getName());//Office
        System.out.println(addressRepository.findByStreetStartingWith("Po"));
        System.out.println(addressRepository.findTop3ByCustomer_Id(7L));

        System.out.println("====================CartItemRepository================");
        System.out.println(balanceRepository.findByAmountGreaterThanEqual(BigDecimal.valueOf(500)));
        System.out.println(balanceRepository.findByAmountLessThan(BigDecimal.valueOf(500)));
        System.out.println(balanceRepository.findTop5MaxBalance());

        System.out.println("====================CartItemRepository================");
        System.out.println(cartItemRepository.getCartItemByCartStateAndProductName("CREATED", "Tomatoes").get(0).getQuantity());//2
        System.out.println(cartItemRepository.getCartByCartStateDiscountIsNull().get(0).getQuantity());//3
        System.out.println(cartItemRepository.findByCart_CartState(CartState.CREATED).toString());
        System.out.println(cartItemRepository.countBy());//1998

        System.out.println("====================CartRepository================");
        System.out.println(cartRepository.findByDiscount_DiscountType(DiscountType.RATE_BASED));
        System.out.println(cartRepository.findAllByCustomerId(1L));

        System.out.println("====================CategoryRepository================");
        System.out.println(categoryRepository.findByName("Termite Control"));
        //[Category{name='Termite Control', id=1}, Category{name='Termite Control', id=31}] why does not unique id? both name are the same
        System.out.println(categoryRepository.findTop3ByOrderByNameDesc());

        System.out.println("====================CustomerRepository================");
        System.out.println(customerRepository.findByEmail("asturton0@list-manage.com"));
        System.out.println(customerRepository.findByUserName("asturton0"));

        System.out.println("====================DiscountRepository================");
        System.out.println(discountRepository.findByDiscountGreaterThan(BigDecimal.valueOf(26)));
        System.out.println(discountRepository.findByDiscountType(DiscountType.RATE_BASED));
        System.out.println(discountRepository.getAllDiscountBetweenGivenRange(BigDecimal.valueOf(26), BigDecimal.valueOf(51)));

        System.out.println("====================OrderRepository================");
        System.out.println(orderRepository.findTop5ByOrderByTotalPriceDesc());
        System.out.println(orderRepository.existsByCustomerEmail("asturton0@list-manage.com"));
        System.out.println(orderRepository.getAllEqualTotalAndPaidPrice());//[] there is not equal value

        System.out.println("====================PaymentRepository================");
        System.out.println(paymentRepository.totalSumPaidPrice());
        System.out.println(paymentRepository.averagePaidAmount());

        System.out.println("====================ProductRepository================");
        System.out.println(productRepository.findByName("Tomatoes"));
        System.out.println(productRepository.countByPriceGreaterThan(BigDecimal.valueOf(80)));
    }
}
