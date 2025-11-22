package org.jaganyv.basic_crud.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Crud {
    @Id
    private int id;
    private String task;
    private boolean isCompleted;
}
