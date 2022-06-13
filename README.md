# Хакатон Moscow City Hack, команда ITHB специально для кейса №2 Сервис по размещению и поиску задач для волонтёров

Веб-сервис, позволяющий волонтерам и организациям, готовящим социально значимые мероприятия, найти друг друга. Модуль геймификации отвечает за рейтинг волонтеров и организаторов, достижения за участие в мероприятиях. Поиск мероприятий и волонтеров при помощи тегов, генерируемых нейросетью, и геоинформационного модуля позволяет найти интересующие события и задачи в удобной для локации. Благодаря личным профилям, волонтеры смогут увидеть отзывы об организации, а организаторы смогут убедиться в добросовестности волонтера.

# Figma: [тык](https://www.figma.com/file/lkrL5PS73n8fcIyWTK71Cc/MoscowCityHack?node-id=0%3A1)
# Canva: [тык](https://www.canva.com/design/DAEpGzCuBDc/jHcMScwbpQkJtrBFzbpnpA/watch?utm_content=DAEpGzCuBDc&utm_campaign=designshare&utm_medium=link&utm_source=publishsharelink)

# Это приложение можно поднять с помощью React

В директории проекта необходимо запустить терминал и вбить в него:

### `npm start`

Оно поднимается на localhost по следующей ссылке: [тык](http://localhost:3000)

Для отображения изменений, вносимых в проект, страницу необходимо перезагрузить (F5)
Логи отображаются непосредственно в терминале

### `npm run build`

Билд и деплой приложения

# Серверная часть деплоится посредством Docker-compose, по Dockerfile. Деплой происходит на Heroku: [тык](https://unionithbrelease.herokuapp.com/)

Скрипт для деплоя:

### `mvnw clean build`
### `heroku login`
### `heroku container: login`
### `heroku apps:create <app-name>`
### `mvnw clean deploy`
### `heroku container:release web worker --app=<app-name>`
### `heroku open --app=<app-name>`

