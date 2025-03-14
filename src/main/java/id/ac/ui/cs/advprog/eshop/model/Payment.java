package id.ac.ui.cs.advprog.eshop.model;

import lombok.Setter;
import lombok.Getter;
import lombok.Builder;
import java.util.Map;
import java.util.Arrays;

@Builder
@Getter
public class Payment {
    String id;
    String method;
    String status;
    Map<String, String> paymentData;

    public Payment(String id, String method, String status, Map<String, String> paymentData) {
        this.id = id;
        this.paymentData = paymentData;
        this.setStatus(status);
        this.setMethod(method);
    }

    public void setStatus(String status) {
        String[] statusList = {"SUCCESS", "REJECTED"};
        if (Arrays.stream(statusList).noneMatch(item -> (item.equals(status)))) {
            throw new IllegalArgumentException();
        }
        else {
            this.status = status;
        }
    }

    public void setMethod(String method) {
        String[] methodList = {"voucher", "cod"};
        if (Arrays.stream(methodList).noneMatch(item -> (item.equals(method)))) {
            throw new IllegalArgumentException();
        }
        else {
            this.method = method;
        }
    }
}