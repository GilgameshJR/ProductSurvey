package com.db2.productsurvey.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;

@NamedQuery(
        name="Questionnaire.getByDate",
        query="SELECT q FROM Questionnaire q WHERE q.date=:date"
)
@NamedQuery(
        name="Questionnaire.getUnsubmissionsByQuestionnaire",
        query="SELECT o FROM Questionnaire q JOIN q.openings o WHERE q.id=:questionnaireId AND o.user.username NOT IN (SELECT a.username FROM q.responses r JOIN r.author a) ORDER BY o.timestamp asc"
)
/*
@NamedQuery(
        name="Questionnaire.getResponsesSortedByPoint",
        query="SELECT r FROM Questionnaire q JOIN q.responses r ORDER BY r.points DESC"
)*/
@Entity
public class Questionnaire {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, unique = true)
    private LocalDate date;

    @OneToMany(mappedBy = "questionnaire", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    List<Opening> openings;

    @OneToMany(mappedBy = "questionnaire", fetch = FetchType.EAGER, orphanRemoval = true, cascade = CascadeType.ALL)
    @OrderBy("timestamp ASC")
    private List<Response> responses;
    @JoinColumn(nullable = false)
    @ManyToOne
    Product product;
    @JoinColumn(nullable = false)
    @OneToMany (mappedBy = "questionnaire", fetch = FetchType.EAGER, orphanRemoval = true, cascade = CascadeType.ALL)
    List<Question> questions;

    public int getId() {
        return id;
    }

    public void addResponse(Response response) {
        response.setQuestionnaire(this);
        this.responses.add(response);
    }

    public List<Response> getResponses() {
        return responses;
    }

    public void addQuestion(Question question) {
        question.setQuestionnaire(this);
        this.questions.add(question);
    }
    public void setQuestions(List<Question> question) {
        for (Question q: question)
            q.setQuestionnaire(this);
        this.questions=question;
    }
    public List<Question> getQuestions() {
        return questions;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public List<Opening> getOpenings() {
        return openings;
    }
    public void addOpening(Opening opening) {
        opening.setQuestionnaire(this);
        openings.add(opening);
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
