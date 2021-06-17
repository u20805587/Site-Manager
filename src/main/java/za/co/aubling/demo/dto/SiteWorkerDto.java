package za.co.aubling.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SiteWorkerDto implements Serializable {

    private String name;
    private String surname;
    private String addressLine1;
    private String addressLine2;
    private String addressLine3;
    private String gender;
    private String idNumber;
    private String contactNumber;
    private String nationality;
    private String postalCode;
    private String stateCode;
    private BigDecimal hourlyRate;
    private Timestamp birthDate;
    private String username;
    private String password;
}
