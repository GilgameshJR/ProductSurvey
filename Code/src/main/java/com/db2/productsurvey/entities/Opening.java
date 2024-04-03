package com.db2.productsurvey.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(indexes =
    @Index(name = "opening_index", columnList = "QUESTIONNAIRE_ID, TIMESTAMP")
)
public class Opening {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    @Column(name = "TIMESTAMP", nullable = false)
    private Date timestamp;

    @JoinColumn(name = "QUESTIONNAIRE_ID", nullable = false)
    @ManyToOne (optional = false)
    private Questionnaire questionnaire;

    @JoinColumn(nullable = false)
    @ManyToOne (optional = false)
    private SimpleUser user;


    public void setQuestionnaire(Questionnaire questionnaire) {
        this.questionnaire = questionnaire;
    }

    public Questionnaire getQuestionnaire() {
        return questionnaire;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public SimpleUser getUser() {
        return user;
    }

    public void setUser(SimpleUser user) {
        this.user = user;
    }
}
