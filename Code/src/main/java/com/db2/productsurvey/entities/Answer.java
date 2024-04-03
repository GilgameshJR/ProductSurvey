package com.db2.productsurvey.entities;

import javax.persistence.*;

@Entity
public class Answer {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String answer;

    @JoinColumn(nullable = false)
    @ManyToOne(optional = false)
    //@JoinColumn(name = "question")
    Question question;

    @ManyToOne(optional = false)
    @JoinColumn(name = "RESPONSE_ID", nullable = false)
    Response response;

    public void setResponse(Response response) {
        this.response=response;
    }

    public Response getResponse() {
        return response;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}
