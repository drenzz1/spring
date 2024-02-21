package org.foo.bootstrap;

import org.foo.enums.Status;
import org.foo.model.*;
import org.foo.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;

@Component
public class DataGenerator implements CommandLineRunner {
    private final PaymentRepository paymentRepository;

    private final MerchantRepository merchantRepository;

    private final CustomerRepository customerRepository;

    private final CartRepository cartRepository;
    private final ItemRepository itemRepository;

    public DataGenerator(PaymentRepository paymentRepository,MerchantRepository merchantRepository,CustomerRepository customerRepository,CartRepository cartRepository,ItemRepository itemRepository) {
        this.paymentRepository = paymentRepository;
        this.merchantRepository=merchantRepository;
        this.customerRepository=customerRepository;
        this.cartRepository=cartRepository;
        this.itemRepository=itemRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Payment payment = new Payment(LocalDate.of(2022,4,19),new BigDecimal("150000"), Status.SUCCESS);
        PaymentDetail paymentDetail = new PaymentDetail(new BigDecimal("140000"),new BigDecimal("10000"),LocalDate.of(2022,4,24));

        payment.setPaymentDetail(paymentDetail);

        Payment payment2 = new Payment(LocalDate.of(2022,4,25),new BigDecimal("100000"), Status.FAILURE);
        PaymentDetail paymentDetail2 = new PaymentDetail(new BigDecimal("90000"),new BigDecimal("5000"),LocalDate.of(2022,4,29));

        payment2.setPaymentDetail(paymentDetail2);

        var merchant = new Merchant("AmazonSubMerchant","M123",new BigDecimal(".25"),new BigDecimal("3.25"),5);
        var customer = new Customer("72 Nuhi Berisha","just.drenzz@gmail.com","Dren","Halili","drenzzy");


        payment.setMerchant(merchant);
        payment2.setMerchant(merchant);

        payment.setCustomer(customer);
        payment2.setCustomer(customer);

        var item1= new Item("Milk","M01");
        var item2= new Item("Sugar","S01");
        var item3= new Item("Bread","B01");

        var cart1 = new Cart();
        var cart2 = new Cart();

        cart1.setItems(Arrays.asList(item1,item2,item3));
        cart2.setItems(Arrays.asList(item3));

        itemRepository.saveAll(Arrays.asList(item1,item2,item3));
        cartRepository.saveAll(Arrays.asList(cart1,cart2));

        customerRepository.save(customer);
        merchantRepository.save(merchant);
        paymentRepository.save(payment);
        paymentRepository.save(payment2);



    }
}
