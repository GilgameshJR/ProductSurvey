package com.db2.productsurvey.beans;

import com.db2.productsurvey.Experience;
import com.db2.productsurvey.MissingAnswersException;
import com.db2.productsurvey.Sex;
import com.db2.productsurvey.entities.*;

import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.enterprise.context.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import java.util.Date;
import java.util.List;

@Stateful(name="ResponseSubmitServiceBean")
public class ResponseSubmitServiceBean {
    @PersistenceContext(unitName = "ProductSurvey", type = PersistenceContextType.EXTENDED)
    private EntityManager em;

    private List<Answer> answers;

    public ResponseSubmitServiceBean() {

    }

    public void addMarketingAnswers(List<Answer> answers) {
        this.answers=answers;
    }

    public List<Answer> getMarketingAnswers() {
        return this.answers;
    }

    @EJB(name = "com.db2.productsurvey.beans/QuestionnaireServiceBean")
    private QuestionnaireServiceBean questionnaireService;

    public Response addPersonalAnswersAndStore(SimpleUser author, Integer userAge, Sex userSex, Experience userExperience) throws MissingAnswersException {
        if (answers==null)
            throw new MissingAnswersException("bad flow: this method should be ALWAYS called after addMarketingAnswers, which will add mandatory answers in the bean");

        Response response=new Response();
        response.setAnswers(answers);

        if (userAge!=null)
            response.setUserAge(userAge);
        if (userSex!=null)
            response.setUserSex(userSex);
        if (userExperience!=null)
            response.setUserExperience(userExperience);

        response.setAuthor(author);
        response.setTimestamp(new Date());
        Questionnaire todayQuestionnaire=questionnaireService.getTodayQuestionnaire();
        todayQuestionnaire.addResponse(response);
        em.persist(response);
        em.merge(todayQuestionnaire);
        //to force insert into db and point calculation triggers execution
        em.flush();
        //to update points after triggers execution
        em.refresh(response);
        return response;
    }
}