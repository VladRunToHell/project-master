


create database volontueers ;
use volontueers;

create table organization (
	id int not null auto_increment,
    name varchar(255) not null,
    type varchar(255) not null,
    phone varchar(20) ,
    email varchar(255),
    inn varchar(20),
    password varchar (255) not null,
    
    primary key (id)
    
);

create table volunteer (
	id int not null auto_increment,
    name varchar(255) not null,
    birthday date not null,
    gender varchar(255),
	password varchar (255) not null,
    
    primary key (id)
);

create table volunteerskills (
	id int not null auto_increment,
   
   volunteer int not null,
   skill varchar(255) not null,
    
    primary key (id),
    foreign key (volunteer) references volunteer(id)
);

create table volunteerAvailablePlace(
	id int not null auto_increment,
    volunteerId int not null,
    city varchar (255),
    disctrict varchar(255) ,
    metro varchar(255),
    primary key (id),
    foreign key (volunteerId) references volunteer (id)
);

create table tag (
	 id int not null auto_increment,
     name varchar(25) not null,
     
     primary key(id)
);

create table event (
	id int not null auto_increment,
    organizer int not null,
    name varchar (500) not null,
    intro text not null,
    ageMin int ,
    ageMax int ,
    attednadcyMethod varchar(255) not null,
    city varchar(255) ,
    disctrict varchar(255),
    street varchar(255),
    metro varchar (255),
    beginDate date not null,
    endDate date ,
    beginTime time,
    endTime time,
    
    primary key(id),
    foreign key(organizer) references organization(id)
    
);

create table eventCordinates(
	id int not null auto_increment,
    event int not null,
    x double not null,
    y double not null,
    
    primary key (id),
    foreign key (event) references event (id)
);

create table requirements (
	id int not null auto_increment,
    requirement varchar (400) not null,
    event int not null,
    
    primary key(id),
    foreign key(event) references event(id)
);

create table eventTags(
	id int not null auto_increment,
    event int not null,
    tag int not null,
    primary key(id),
    foreign key (event) references event (id),
    foreign key (tag) references tag (id)
    
);

create table volunteerEvents(
	id int not null auto_increment,
    volunteer int not null,
    event int not null,
    
    primary key (id),
    foreign key(volunteer) references volunteer(id),
    foreign key (event) references event(id)
);

create table OrganizationPopularTags(
	id int not null auto_increment,
    tag int not null,
    organization int not null,
    
    primary key (id),
    foreign key (tag) references tag(id),
    foreign key (organization) references organization(id)
);

create table volunteerFavoriteTags(
	id int not null auto_increment,
    tag int not null,
    volunteer int not null,
    
    primary key (id),
    foreign key (tag) references tag(id),
    foreign key (volunteer) references volunteer(id)
);


create table review (
	id int not null auto_increment,
    review text not null,
    event int not null,
    
    
    primary key(id),
    foreign key (event) references event (id)
);
create table organizationReview(
	id int not null auto_increment,
    organization int not null,
    review int not null,
    
    primary key (id),
    foreign key (organization) references organization(id),
    foreign key (review) references review(id)
);

create table volunteerReview(
	id int not null auto_increment,
    volunteer int not null,
    review int not null,
    
    primary key (id),
    foreign key (volunteer) references volunteer(id),
    foreign key (review) references review(id)
);

create table achievement(
	id int not null auto_increment,
    name varchar(255) not null,
    description text not null,
    points int not null,
    uniqueOrNot boolean ,
    image text ,
    
    primary key (id)
    
);

create table userachievements(
	id int not null auto_increment,
    achivment int not null,
    volunteer int not null,
    
    primary key (id),
    foreign key(achivment) references achievement(id),
    foreign key  (volunteer) references volunteer(id)
);

create table friends 
(
	id int not null auto_increment,
    user int not null,
    friend int not null,
    
    primary key(id),
    foreign key (user) references volunteer (id),
    foreign key (friend) references volunteer (id)
);

create table community (
	id int not null auto_increment,
    name varchar (255) not null,
    description varchar(255),
    
    primary key (id)
);


create table communitymembers(
	id int not null auto_increment,
    community int not null,
    user int not null,
    role varchar (255) not null,
    
    primary key (id),
    foreign key (community ) references community(id),
    foreign key (user) references volunteer (id)
);
INSERT INTO organization(name, type, phone, email, inn, password) 
VALUES('РЖД','Коммерческая организация', '300-300-300', 'volunteer@pochet.ru', '7708503727', 'rjdpassword');
INSERT INTO organization(name, type, phone, email, inn, password) 
VALUES('Роспатриотцентр','Государственное учреждение', '200-200-200', 'participant@rospatriotcentr.ru', '7702334543', 'rpcpassword');
INSERT INTO organization(name, type, phone, email, inn, password) 
VALUES('Минстрой России','Государственное учреждение', '100-100-100', 'd06.gorsred@minstroy.gov.ru', '7707780887', 'mrpassword');

INSERT INTO volunteer(name, birthday, gender, password) 
VALUES('Юрий','2001-12-27','Мужской','qwerty123');
INSERT INTO volunteer(name, birthday, gender, password) 
VALUES('Владислав','2001-07-22','Мужской','qwerty12345');
INSERT INTO volunteer(name, birthday, gender, password) 
VALUES('Сергей','2001-03-11','Мужской','passworddd33');

INSERT INTO volunteerskills(volunteer,skill) 
VALUES(1,'Умею выступать');
INSERT INTO volunteerskills(volunteer,skill) 
VALUES(2,'Хорошая физическая подготовка');
INSERT INTO volunteerskills(volunteer,skill) 
VALUES(3,'Умение руководить');

INSERT INTO tag(name) VALUES('Дети');
INSERT INTO tag(name) VALUES('Животные');
INSERT INTO tag(name) VALUES('Здоровье');
INSERT INTO tag(name) VALUES('Культура');
INSERT INTO tag(name) VALUES('Наука и образование');
INSERT INTO tag(name) VALUES('Патриотизм');
INSERT INTO tag(name) VALUES('Природа');
INSERT INTO tag(name) VALUES('Социальное волонтерство');
INSERT INTO tag(name) VALUES('Спорт');

INSERT INTO event(organizer, name, intro, ageMin, ageMax, attednadcyMethod, city, disctrict, street, metro, beginDate, endDate, beginTime, endTime) 
VALUES('1','Уборка парка','Необходима помощь в уборке парка. Требуется 
помощь 10 волонтеров','6','100','оффлайн','Москва','Западный административный округ','Мосфильмовская 27','Минская','2022-06-27','2022-06-30','11:30:00','18:00:00');
INSERT INTO event(organizer, name, intro, ageMin, ageMax, attednadcyMethod, city, disctrict, street, metro, beginDate, endDate, beginTime, endTime) 
VALUES('2','Сбор мусора в сквере','Будет производиться уборка 
сквера от мусора, ждем всех желающих','10','100','оффлайн','Москва','Северо-Восточный административный округ','Хачатурина 20г','Отрадное','2022-07-13','2022-07-17','12:00:00','17:00:00');
INSERT INTO event(organizer, name, intro, ageMin, ageMax, attednadcyMethod, city, disctrict, street, metro, beginDate, endDate, beginTime, endTime) 
VALUES('3','Субботник','Субботник будет проводиться 
для очистки зеленых зон','7','100','оффлайн','Москва','Северный административный округ','Волоколамское шоссе, 56к2','Щукинская','2022-08-01','2022-08-02','09:45:00','15:50:00');

INSERT INTO eventCordinates(event, x, y)
VALUES(1,'55.71091474554308','37.53348112106324');
INSERT INTO eventCordinates(event, x, y)
VALUES(2,'55.86251570163294','37.60444164276124');
INSERT INTO eventCordinates(event, x, y)
VALUES(3,'55.81786378438194','37.46801912784577');

INSERT INTO requirements(requirement, event)
VALUES('Отсутствуют', 1);
INSERT INTO requirements(requirement, event)
VALUES('Отсутствуют', 2);
INSERT INTO requirements(requirement, event)
VALUES('Перчатки, мусорные пакеты и желание работать', 3);

INSERT INTO volunteerEvents(volunteer, event)
VALUES(1,2);
INSERT INTO volunteerEvents(volunteer, event)
VALUES(1,3);
INSERT INTO volunteerEvents(volunteer, event)
VALUES(2,2);
INSERT INTO volunteerEvents(volunteer, event)
VALUES(3,1);
INSERT INTO volunteerEvents(volunteer, event)
VALUES(3,2);
INSERT INTO volunteerEvents(volunteer, event)
VALUES(3,3);

INSERT INTO volunteerFavoriteTags(tag, volunteer)
VALUES(1,1);
INSERT INTO volunteerFavoriteTags(tag, volunteer)
VALUES(3,1);
INSERT INTO volunteerFavoriteTags(tag, volunteer)
VALUES(5,1);
INSERT INTO volunteerFavoriteTags(tag, volunteer)
VALUES(1,2);
INSERT INTO volunteerFavoriteTags(tag, volunteer)
VALUES(2,2);
INSERT INTO volunteerFavoriteTags(tag, volunteer)
VALUES(9,2);
INSERT INTO volunteerFavoriteTags(tag, volunteer)
VALUES(4,3);
INSERT INTO volunteerFavoriteTags(tag, volunteer)
VALUES(5,3);
INSERT INTO volunteerFavoriteTags(tag, volunteer)
VALUES(1,3);

INSERT INTO review(review, event)
VALUES('Хорошее проведениее, добрые организаторы', 1);
INSERT INTO review(review, event)
VALUES('Отличная организация, обязательно посещу ещё!', 1);
INSERT INTO review(review, event)
VALUES('Организаторы немного опоздали с началом, но в целом проведение отличное', 2);
INSERT INTO review(review, event)
VALUES('Организованность оставляет желать лучшего', 3);
INSERT INTO review(review, event)
VALUES('Отличный волонтер, добросовестно работал и брал много задач на себя', 2);
INSERT INTO review(review, event)
VALUES('Четко выполнял поставленные задачи', 1);
INSERT INTO review(review, event)
VALUES('Посредственно выполнял задачи, часто мешал проведению мероприятия', 1);


INSERT INTO organizationReview(organization, review)
VALUES(1,1);
INSERT INTO organizationReview(organization, review)
VALUES(2,2);
INSERT INTO organizationReview(organization, review)
VALUES(3,3);
INSERT INTO organizationReview(organization, review)
VALUES(3,4);

INSERT INTO volunteerReview(volunteer, review)
VALUES(1,5);
INSERT INTO volunteerReview(volunteer, review)
VALUES(2,6);
INSERT INTO volunteerReview(volunteer, review)
VALUES(3,7);


INSERT INTO achievement(name, description, points, uniqueOrNot, image)
VALUES ('Отличный волонтер','Награждаются волонтеры за добросовестное выполнение работы',
'100', false,'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSlcAbvR38RPy6QGZvPg42cN5hR5_J0rsBpRQ&usqp=CAU');
INSERT INTO achievement(name, description, points, uniqueOrNot, image)
VALUES('Волонтер природы','Награждаются за участие в приборке сквера',
'300', true,'https://www.downloadclipart.net/large/green-leaf-png-photo.png');


INSERT INTO userachievements(achivment, volunteer)
VALUES(1,1);
INSERT INTO userachievements(achivment, volunteer)
VALUES(2,1);
INSERT INTO userachievements(achivment, volunteer)
VALUES(1,2);
INSERT INTO userachievements(achivment, volunteer)
VALUES(2,3);

INSERT INTO friends(user, friend)
VALUES(1,2);
INSERT INTO friends(user, friend)
VALUES(1,3);
INSERT INTO friends(user, friend)
VALUES(2,3);
INSERT INTO friends(user, friend)
VALUES(3,1);
INSERT INTO friends(user, friend)
VALUES(3,2);

INSERT INTO community(name, description)
VALUES('Братья природы', 'Набирающий людей коллектив, участвуем в акциях, направленных на помощь природе');
INSERT INTO community(name, description)
VALUES('Помогальщики', 'Молодой коллектив, собирающийся участвовать в большом количестве мероприятий, направленных на помощь природе');

INSERT INTO communitymembers(community, user, role)
VALUES(1,1,'Основатель');
INSERT INTO communitymembers(community, user, role)
VALUES(1,2,'Помощник');
INSERT INTO communitymembers(community, user, role)
VALUES(2,3,'Основатель');