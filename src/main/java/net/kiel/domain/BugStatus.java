package net.kiel.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by kiel on 2016. 4. 19..
 */
@Entity
@Data
@NoArgsConstructor
public class BugStatus {
    public BugStatus(String status) {
        this.status = status;
    }

    @Id
    @GeneratedValue
    private Long id;

    private String status;
}
