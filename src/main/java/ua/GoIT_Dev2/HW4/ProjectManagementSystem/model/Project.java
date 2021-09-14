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
@Entity(name = "projects")
public class Project implements BaseEntity<Long> {

    @Serial
    private static final long serialVersionUID = -5862211916185553288L;
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "project_name")
    private String name;

    @Column(name = "cost")
    private int cost;

    /*@Column(name = "company_id")
    private Long companyId;

    @Column(name = "customer_id")
    private Long customerId;*/
}
