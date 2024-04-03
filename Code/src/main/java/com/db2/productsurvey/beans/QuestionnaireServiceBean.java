package com.db2.productsurvey.beans;

import com.db2.productsurvey.entities.Product;
import com.db2.productsurvey.entities.Question;
import com.db2.productsurvey.entities.Questionnaire;

import javax.ejb.EJBTransactionRolledbackException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;
import java.util.List;

@Stateless(name = "QuestionnaireServiceBean")
public class QuestionnaireServiceBean {
    @PersistenceContext(unitName = "ProductSurvey")
    private EntityManager em;

    public QuestionnaireServiceBean() {
    }

    public Questionnaire getQuestionnaireByDate(LocalDate date) {
        try {
            return em.createNamedQuery("Questionnaire.getByDate", Questionnaire.class).setParameter("date", date).getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    public Questionnaire getTodayQuestionnaire() {
        LocalDate today = LocalDate.now();
        try {
            return em.createNamedQuery("Questionnaire.getByDate", Questionnaire.class).setParameter("date", today).getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    public Questionnaire createQuestionnaire(int productId, List<Question> marketingQuestions, LocalDate date) throws EJBTransactionRolledbackException {
        Questionnaire questionnaire = new Questionnaire();
        questionnaire.setQuestions(marketingQuestions);

        Product product = em.find(Product.class, productId);
        questionnaire.setProduct(product);
        questionnaire.setDate(date);

        em.persist(questionnaire);
        return questionnaire;
    }

    public void deleteQuestionnaire(int id) {
        Questionnaire questionnaire=em.find(Questionnaire.class, id);
        em.remove(questionnaire);
    }
}