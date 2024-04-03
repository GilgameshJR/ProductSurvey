package com.db2.productsurvey.beans;

import com.db2.productsurvey.entities.*;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Stateless(name = "ResponseServiceBean")
public class ResponseServiceBean {
  @PersistenceContext(unitName = "ProductSurvey")
  private EntityManager em;
  public ResponseServiceBean() {
  }

  /*
  public Response getResponseByUserForQuestionnaire(String username, int questionnaireId) {
    try {
      return em.createNamedQuery("Response.getByUsernameForQuestionnaire", Response.class).setParameter("username", username).setParameter("questionnaireId", questionnaireId).getSingleResult();
    } catch (NoResultException e) {
      return null;
    }
  }
   */

  public Response getResponseByUserForQuestionnaire(String username, LocalDate date) {
    try {
      return em.createNamedQuery("Response.getByUsernameForQuestionnaireByDate", Response.class).setParameter("username", username).setParameter("date", date).getSingleResult();
    } catch (NoResultException e) {
      return null;
    }
  }

  public Response getResponse(int responseId) {
    return em.find(Response.class, responseId);
  }

  /*
  public List<Response> getResponseForQuestionnaireSortedByPoint(int questionnaireId) {
    return em.createNamedQuery("Response.getForQuestionnaireSortedByPoint", Response.class).setParameter("questionnaireId", questionnaireId).getResultList();
  }*/
  public List<Response> getResponseForQuestionnaireSortedByPoint(LocalDate questionnaireDate) {
    return em.createNamedQuery("Response.getForQuestionnaireByDateSortedByPoint", Response.class).setParameter("questionnaireDate", questionnaireDate).getResultList();
  }

  public boolean isWordOffensive(String word) {
    word=word.toLowerCase(Locale.ROOT);
    return em.find(OffensiveWord.class, word) != null;
  }

  //then cast each element to Map.Entry<User, Date>
  public List<Opening> getUnsubmittingUsers(int questionnaireId) {
    return em.createNamedQuery("Questionnaire.getUnsubmissionsByQuestionnaire", Opening.class).setParameter("questionnaireId",questionnaireId).getResultList();
  }

  @EJB(name = "com.db2.productsurvey.beans/QuestionnaireServiceBean")
  private QuestionnaireServiceBean questionnaireService;

  //then cast each element to Map.Entry<User, Date>
  public void storeUserOpeningTodayQuestionnaire(SimpleUser user) {
    Opening opening=new Opening();
    opening.setUser(user);
    opening.setTimestamp(new Date());
    Questionnaire questionnaire=questionnaireService.getTodayQuestionnaire();
    questionnaire.addOpening(opening);
    em.persist(questionnaire);
  }
}