package ua.GoIT_Dev2.HW4.ProjectManagementSystem.model;

import java.io.Serializable;

public interface BaseEntity<ID> extends Serializable {
    ID getId ();
}
