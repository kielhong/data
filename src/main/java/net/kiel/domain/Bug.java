package net.kiel.domain;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * Created by kiel on 2016. 4. 19..
 */
@Entity
@EntityListeners(AuditingEntityListener.class)
@Data
public class Bug {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Account reporter;

    @ManyToOne
    @JoinColumn(nullable = false)
    private BugStatus status;

    @OneToMany
    @JoinTable(name = "bug_component",
            foreignKey = @ForeignKey(name = "FK_bug_component_bug"),
            inverseForeignKey = @ForeignKey(name = "FK_bug_component_component"))
    private List<Component> components;

    @CreatedDate
    private ZonedDateTime createdDatetime;

    @LastModifiedDate
    private ZonedDateTime modifiedDatetime;
}
