package org.foo.bootstrap;

import org.foo.enums.Status;
import org.foo.model.Customer;
import org.foo.model.Merchant;
import org.foo.model.Payment;
import org.foo.model.PaymentDetail;
import org.foo.repository.CustomerRepository;
import org.foo.repository.MerchantRepository;
import org.foo.repository.PaymentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;

@Component
public class DataGenerator implements CommandLineRunner {
    private final PaymentRepository paymentRepository;

    private final MerchantRepository merchantRepository;

    private final CustomerRepository customerRepository;

    public DataGenerator(PaymentRepository paymentRepository,MerchantRepository merchantRepository,CustomerRepository customerRepository) {
        this.paymentRepository = paymentRepository;
        this.merchantRepository=merchantRepository;
        this.customerRepository=customerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Payment payment = new Payment(LocalDate.of(2022,4,19),new BigDecimal("150000"), Status.SUCCESS);
        PaymentDetail paymentDetail = new PaymentDetail(new BigDecimal("140000"),new BigDecimal("10000"),LocalDate.of(2022,4,24));

        payment.setPaymentDetail(paymentDetail);

        Payment payment2 = new Payment(LocalDate.of(2022,4,25),new BigDecimal("100000"), Status.FAILURE);
        PaymentDetail paymentDetail2 = new PaymentDetail(new BigDecimal("90000"),new BigDecimal("5000"),LocalDate.of(2022,4,29));

        payment2.setPaymentDetail(paymentDetail2);

        Merchant merchant = new Merchant("AmazonSubMerchant","M123",new BigDecimal(".25"),new BigDecimal("3.25"),5);
        Customer customer = new Customer("72 Nuhi Berisha","just.drenzz@gmail.com","Dren","Halili","drenzzy");


        payment.setMerchant(merchant);
        payment2.setMerchant(merchant);
        payment.setCustomer(customer);
        payment2.setCustomer(customer);

        customerRepository.save(customer);
        merchantRepository.save(merchant);
        paymentRepository.save(payment);
        paymentRepository.save(payment2);



    }
}
