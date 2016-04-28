package net.kiel.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by kiel on 2016. 4. 19..
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BugStatus {
    public BugStatus(String status) {
        this.status = status;
    }

    @Id
    private long id;

    private String status;
}
