package com.example.hack.web.Controllers;

import com.example.hack.entities.*;
import com.example.hack.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;

@Controller
public class VolunteerController
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


    //Логин и регистрация

    public void Registrate(VolunteerEntity newVolunteer){
        if (volunteerService.check(newVolunteer.getName() , newVolunteer.getPassword() )){
            volunteerService.add(newVolunteer);
            //Возвращает личный кабинет
        }
    }

    public void login (String name, String pass){
        if (!volunteerService.check(name,pass)){
            //Возвращает личный кабинет
        }
    }

    //Главная страница с рекомендациями

    public void recomendedEvents(int userID){
        ArrayList<EventEntity> events = eventService.getEventsInFuture();
        ArrayList<TagEntity> tags= volunteerFavoriteTagsService.getAllVolunteerTags(userID);
        ArrayList<EventEntity> result =new ArrayList<>();

        result= eventService.getEventsWithMinOneTag(events,tags);

        //Получается массив событий , которые будут в будующем и у которых есть хотя бы одно совподение по тэгу
    }





    //Получение всех друзей
    public void getFriends(int volunteerID){
        ArrayList<VolunteerEntity> friends= friendsService.getAllFriends(volunteerID);
    }

    //Поиск людей по имени
    public void findVolunteer(String name){
        ArrayList<VolunteerEntity> volunteers= volunteerService.getByName(name);
    }

    //Удалить из друзей
    public void deleteFromFriends(FriendsEntity friend){
        friendsService.delete(friend);
    }

    //Получение профиля человека
    public void yourProfile (int userID){
        ArrayList<AchievementEntity> achievements= volunteerAchievementsService.getAllVolunteerAchivments(userID);
        ArrayList<VolunteerEntity> friends= friendsService.getAllFriends(userID);
        ArrayList<ReviewEntity> reviews= volunteerReviewService.getAllVolunteerReviews(userID);
        VolunteerEntity volunteer= volunteerService.getByID(userID);
        //Теперь нужно передать всю эту информацию на страницу
    }
    //Добавить редактирование тегов , информации

    //Все мероприятия , в которых участвовал , при нажатии на него все инфа о нем , так же , как в оргонизаторе
    public void getAllEvents(int userID){
        ArrayList<EventEntity> events =volunteerEventsService.getAllVolunteerEvents(userID);
    }
    public void eventInfo(int eventID){
        EventEntity event= eventService.getByID(eventID);
        ArrayList<EventTagsEntity> eventTags= eventTagService.getAllEventTags(eventID);
        ArrayList<EventRequirementEntity> requirements = eventRequirementService.getAllEventRequirements(eventID);
        ArrayList<VolunteerEventsEntity> volunteers = volunteerEventsService.getAllEventVolnteers(eventID);
    }

    //Ачивки , перечисление всех очивок , сумма общего щета

    public void getAllAchievements (int userID){
        ArrayList<AchievementEntity> achievements= volunteerAchievementsService.getAllVolunteerAchivments(userID);
    }
    public void getPoints(int userID){
        int points = volunteerAchievementsService.getPoints(userID);
    }

    //Профиль , в нем отображатся все мероприятия , ачивки , которые есть , список друзей , комментарии о нем , общая информация

    public void profile (int userID){
        ArrayList<AchievementEntity> achievements= volunteerAchievementsService.getAllVolunteerAchivments(userID);
        ArrayList<VolunteerEntity> friends= friendsService.getAllFriends(userID);
        ArrayList<ReviewEntity> reviews= volunteerReviewService.getAllVolunteerReviews(userID);
        VolunteerEntity volunteer= volunteerService.getByID(userID);
        //Теперь нужно передать всю эту информацию на страницу
    }


}
