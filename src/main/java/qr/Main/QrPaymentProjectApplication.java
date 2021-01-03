package qr.Main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication(scanBasePackages={"Model","Controller"})

//@ComponentScan({"Controller","Model"})
public class QrPaymentProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(QrPaymentProjectApplication.class, args);
    }

}
