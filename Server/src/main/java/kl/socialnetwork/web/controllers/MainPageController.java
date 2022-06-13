package com.example.hack.web.Controllers;

import com.example.hack.entities.EventEntity;
import com.example.hack.entities.VolunteerAchievementsEntity;
import com.example.hack.entities.VolunteerEntity;
import com.example.hack.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;

@Controller
public class MainPageController
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
    @Autowired FriendsService friendsService;
    @Autowired VolunteerFavoriteTagsService volunteerFavoriteTagsService;


    //Главная страница :
    //Поиск мероприятий по названию
    public void findEventByName(String name){
        ArrayList<EventEntity> events= eventService.getEventWithName(name);
    }
    //Фильтры тегам , времени , месту , способам участия , возраст


    public void search(ArrayList<String> tags , ArrayList<String> requirements , Date beginDate,
                       Date endDate,int minAge,int maxAge,String attednadcyMethod,String disctrict ){
        ArrayList<EventEntity> eventsInTime = eventService.getEventsInDateFrame(beginDate,endDate);


    }
    //Рейтинг волонтеров и Рейтинг компании

    @GetMapping("volunteerLeaders")
    public  HashMap<String,Integer> volLeadBoard(){

        HashMap<String,Integer> volunteersSorted= volunteerAchievementsService.getLeaderBoard((ArrayList<VolunteerEntity>) volunteerService.getAll().clone());
        return volunteersSorted;
    }
    @GetMapping("organizatorsLeaders")
    public HashMap<String,Integer> orgLeadBoard(){
        HashMap<String,Integer> organizationSorted= organizationService.getOrganizationLeaders();
        return organizationSorted;
    }
}
