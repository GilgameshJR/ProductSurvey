package com.db2.productsurvey.entities;

import com.db2.productsurvey.Experience;
import com.db2.productsurvey.Sex;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
/*
@NamedQuery(name="Response.getByUsernameForQuestionnaire",
        query="SELECT r FROM Response r WHERE r.author.username=:username AND r.questionnaire.id=:questionnaireId")

 */

@NamedQuery(name="Response.getByUsernameForQuestionnaireByDate",
        query="SELECT r FROM Response r WHERE r.author.username=:username AND r.questionnaire.date=:date")
/*
@NamedQuery(name="Response.getForQuestionnaireSortedByPoint",
        query="SELECT r FROM Response r WHERE r.questionnaire.id=:questionnaireId ORDER BY r.points DESC")
*/
@NamedQuery(name="Response.getForQuestionnaireByDateSortedByPoint",
        query="SELECT r FROM Response r WHERE r.questionnaire.date=:questionnaireDate ORDER BY r.points DESC")

@Entity
@Table(uniqueConstraints= {
        @UniqueConstraint(columnNames = {"username", "QUESTIONNAIRE_ID"})
})
public class Response {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    Date timestamp;
    @Column(nullable = false)
    int points=0;
    Integer userAge;
    @Enumerated(EnumType.ORDINAL)
    Sex userSex;
    @Enumerated(EnumType.ORDINAL)
    Experience userExperience;
    @ManyToOne
    @JoinColumn(name = "username", nullable = false)
    SimpleUser author;

    @ManyToOne
    @JoinColumn(name = "QUESTIONNAIRE_ID", nullable = false)
    Questionnaire questionnaire;

    @JoinColumn(nullable = false)
    @OneToMany(mappedBy = "response", fetch = FetchType.EAGER, orphanRemoval = true, cascade = CascadeType.ALL)
    List<Answer> answers;

    public int getId() {
        return id;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public Sex getUserSex() {
        return userSex;
    }

    public void setUserSex(Sex userSex) {
        this.userSex = userSex;
    }

    public Integer getUserAge() {
        return userAge;
    }

    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }

    public Experience getUserExperience() {
        return userExperience;
    }

    public void setUserExperience(Experience userExperience) {
        this.userExperience = userExperience;
    }

    public SimpleUser getAuthor() {
        return author;
    }

    public void setAuthor(SimpleUser author) {
        this.author = author;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        for (Answer answer: answers)
            answer.setResponse(this);

        this.answers = answers;
    }

    public Questionnaire getQuestionnaire() {
        return questionnaire;
    }

    public void setQuestionnaire(Questionnaire questionnaire) {
        this.questionnaire = questionnaire;
    }
}
