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
@Entity(name = "developers_skills")
public class DeveloperSkill implements BaseEntity<Long> {

    @Serial
    private static final long serialVersionUID = 2763625545677557995L;

    @Id
    @Column(name = "developers_id")
    private Long id;

    @Column(name = "skills_id")
    private Long skillId;
}
