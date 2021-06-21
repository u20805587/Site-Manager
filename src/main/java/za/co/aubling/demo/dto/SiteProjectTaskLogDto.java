package za.co.aubling.demo.dto;

import lombok.*;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Repository
public class SiteProjectTaskLogDto implements Serializable {

    private Long subtaskId;
    private Long projectId;
    private Date workDate;
    private BigDecimal length;
    private BigDecimal width;
    private BigDecimal height;


}
