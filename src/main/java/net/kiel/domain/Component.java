package net.kiel.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.ZonedDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by kiel on 2016. 4. 22..
 */
@Entity
@EntityListeners(AuditingEntityListener.class)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Component {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @CreatedDate
    private ZonedDateTime createdDatetime;



}
