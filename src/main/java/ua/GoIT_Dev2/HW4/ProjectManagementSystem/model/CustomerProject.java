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
@Entity(name = "customer_projects")
public class CustomerProject implements BaseEntity<Long>{

    @Serial
    private static final long serialVersionUID = -6192110522880025759L;

    @Id
    @Column(name = "customer_id")
    private Long id;

    @Column(name = "projects_id")
    private Long projectId;
}
