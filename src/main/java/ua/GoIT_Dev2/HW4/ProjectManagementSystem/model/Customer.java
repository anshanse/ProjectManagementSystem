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
@Entity(name = "customers")
public class Customer implements BaseEntity<Long> {

    @Serial
    private static final long serialVersionUID = 5184860151334342492L;

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "customer_name")
    private String name;
}
