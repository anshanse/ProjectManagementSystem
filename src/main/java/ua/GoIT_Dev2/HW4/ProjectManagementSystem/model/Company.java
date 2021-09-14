package ua.GoIT_Dev2.HW4.ProjectManagementSystem.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serial;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "companies")
public class Company implements BaseEntity<Long> {

    @Serial
    private static final long serialVersionUID = 8007115697480334892L;

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "company_name")
    private String name;

}
