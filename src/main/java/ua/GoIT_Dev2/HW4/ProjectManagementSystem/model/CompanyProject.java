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
@Entity(name = "companies_projects")
public class CompanyProject implements BaseEntity<Long> {

    @Serial
    private static final long serialVersionUID = -7379966534399505127L;
    @Id
    @Column(name = "companies_id")
    private Long id;

    @Column(name = "project_id")
    private Long projectId;
}
