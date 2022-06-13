package com.example.hack.web.Controllers;

import com.example.hack.entities.*;
import com.example.hack.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;

@Controller
public class OrganizationController
{
    @Autowired OrganizationService organizationService;
    @Autowired EventService eventService;
    @Autowired VolunteerEventsService volunteerEventsService;
    @Autowired VolunteerAchievementsService volunteerAchievementsService;
    @Autowired EventRequirementService eventRequirementService;
    @Autowired EventTagService eventTagService;
    @Autowired VolunteerService volunteerService;
    @Autowired VolunteerReviewService volunteerReviewService;
    @Autowired OrganizationPopularTagsService organizationPopularTagsService;
    @Autowired OrganizationReviewService organizationReviewService;

    //Страница регестрации/логирования

    @PostMapping("/Org/Register")
    public boolean Registrate(OrganizationEntity newOrganization){
        if (organizationService.unique(newOrganization.getInn())){
            organizationService.add(newOrganization);
            return true;
            //Возвращает личный кабинет
        }
        else return false;
    }

    @PostMapping("/Org/Login")
    public boolean login (OrganizationEntity organization){
        if (organizationService.check(organization)){
            return true;
            //Возвращает личный кабинет
        }
        return false;
    }

    //Прогрузка личного кабинета
    @PostMapping("Org/Events")
    public ArrayList<EventEntity> privateProfile(OrganizationEntity organization){

        ArrayList<EventEntity> events= eventService.getEventsByOrganization(organization.getId());
        return  events;
        //Переносит на страницу данные о компании и массив с мероприятиями
    }

    //Нажатие на конкретное мероприятие , тогда загрузится страница с информацией о нем и с его участниками(Как я понимаю нажатие перенаправляет на адрес event/id)
    public void pickedEvent(int eventID){
        EventEntity event= eventService.getByID(eventID);
        ArrayList<EventTagsEntity> eventTags= eventTagService.getAllEventTags(eventID);
        ArrayList<EventRequirementEntity> requirements = eventRequirementService.getAllEventRequirements(eventID);
        ArrayList<VolunteerEventsEntity> volunteers = volunteerEventsService.getAllEventVolnteers(eventID);
        //Передает на страницу эти данные
    }

    //Редактирование данные о событии
    //Апдейты можно поместить в одну большую функцию , удаление и добавлние вызывается по кнопкам , рядом с этими списками
    public void editEvent(EventEntity event){
        eventService.update(event);
    }
    public void deleteEvent(EventEntity event){
        eventService.delete(event);
    }

    public void deleteTag(EventTagsEntity tag){
        eventTagService.delete(tag);
    }
    public void updateTag(EventTagsEntity tag){
        eventTagService.update(tag);
    }
    public void addTag(EventTagsEntity tag){
        eventTagService.add(tag);
    }

    public void deleteRequerment(EventRequirementEntity requirement){
        eventRequirementService.delete(requirement);
    }
    public void updateRequerment(EventRequirementEntity requirement){
        eventRequirementService.update(requirement);
    }
    public void addRequerment(EventRequirementEntity requirement){
        eventRequirementService.add(requirement);
    }

    //Пользователи , которые участвую в событии
    public void deleteVolunteer(VolunteerEventsEntity volunteer){
        volunteerEventsService.delete(volunteer);
    }
    public void giveVolunteerAward(VolunteerEntity volunteer, AchievementEntity achievement){
        VolunteerAchievementsEntity volunteerAchievement =new VolunteerAchievementsEntity();
        volunteerAchievement.setVolunteer(volunteer);
        volunteerAchievement.setAchivment(achievement);

        volunteerAchievementsService.add(volunteerAchievement);
    }
    public void takeFromVolunteerAward(VolunteerAchievementsEntity volunteerAchievement){
        volunteerAchievementsService.delete(volunteerAchievement);
    }
    public void writeVolunteerReview(VolunteerEntity volunteer ,ReviewEntity review){
        VolunteerReviewEntity volunteerReview = new VolunteerReviewEntity();
        volunteerReview.setVolunteer(volunteer);
        volunteerReview.setReview(review);
        volunteerReviewService.add(volunteerReview);

    }
    public void editVolunteerReview(VolunteerReviewEntity volunteerReview){
        volunteerReviewService.update(volunteerReview);
    }
    public void deleteVolunteerReview(VolunteerReviewEntity volunteerReview){
        volunteerReviewService.delete(volunteerReview);
    }

    //Создание нового события

    //Берет данные с страницы, organizer, создает все нужные записи
    public void createEvent(ArrayList<TagEntity> tags, ArrayList<String> requirements , EventEntity event , OrganizationEntity organization){
        event.setOrgonizer(organization);
        event.setId(eventService.add(event));

        for (int i=0;i<tags.size();i++){
            EventTagsEntity eventTag= new EventTagsEntity();
            eventTag.setEvent(event);
            eventTag.setTag(tags.get(i));
            eventTagService.add(eventTag);
        }

        for (int i=0;i<requirements.size();i++){
            EventRequirementEntity eventRequirement= new EventRequirementEntity();
            eventRequirement.setEvent(event);
            eventRequirement.setRequirement(requirements.get(i));
            eventRequirementService.add(eventRequirement);
        }
    }

    //Страница профиля, получает все нужные данные , затем добавляет их на страницу
    public void profile (int companyID){
        ArrayList<EventEntity> events= eventService.getEventsByOrganization(companyID);
        ArrayList<TagEntity> popularTags= organizationPopularTagsService.getCompanyTags(companyID);
        ArrayList<ReviewEntity> reviews= organizationReviewService.getCompanyReviews(companyID);
        OrganizationEntity organization= organizationService.getByID(companyID);

        //Передает всю эту информацию на странциу
    }

}
