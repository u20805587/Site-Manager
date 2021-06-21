package za.co.aubling.demo.dto;

import lombok.*;
import org.springframework.stereotype.Repository;

import javax.persistence.Column;
import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Repository
public class SiteProjectTaskDto implements Serializable {

    private Long subtaskId;
    private Long projectId;
    private BigDecimal length;
    private BigDecimal width;
    private BigDecimal height;
    private String unit;
    private String status;


}
