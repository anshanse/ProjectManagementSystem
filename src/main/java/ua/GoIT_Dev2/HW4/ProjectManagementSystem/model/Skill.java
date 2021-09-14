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
@Entity(name = "skills")
public class Skill implements BaseEntity<Long>{

    @Serial
    private static final long serialVersionUID = -5358471669094964579L;

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "skill")
    private String skill;

    @Column(name = "grade")
    private String grade;
}
