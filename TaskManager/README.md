Task Manager Application - Built on Angular, Spring Boot & Postgres. This App provides capability to create/modify/end tasks.

Spring Boot Code Base
https://github.com/nagarajan-sivathanu/Spring-Boot-API/tree/master/TaskManager

Angular Code Base
https://github.com/nagarajan-sivathanu/Angular/tree/master/taskmanager

Docker Compose File
version: '3'
services:
  mypostgres:
    image: postgres:latest
    container_name: taskmanager_postgres_container
    network_mode: bridge
    volumes:
      - /opt/postgres:/var/lib/postgresql/data
    restart: always
    environment:
      POSTGRES_PASSWORD: admin
      POSTGRES_USER: postgres
      POSTGRES_DB: master
    expose:
      - 5432        
    ports:
      - 5432:5432
  springbootapp:
    image: nagaraj16/taskmanager_springboot_api:release_1.0.0
    network_mode: bridge
    container_name: taskmanager_springboot_container
    environment:
      SPRING_DATASOURCE_URL: jdbc:postgresql://taskmanager_postgres_container:5432/master
    expose:
      - 8081
    ports:
      - 8081:8081
    restart: always
    depends_on:
      - mypostgres
    links:
      - mypostgres  
  angularapp:
    image: nagaraj16/taskmanager_angular_app:release_1.0.1
    network_mode: bridge
    container_name: taskmanager_angular_container
    environment:
      API_URL: http://taskmanager_springboot_container:8081/api/tasks
    volumes:
      - /usr/share/nginx/html:/usr/share/nginx/html 
    expose:
      - 4200
    ports:
      - 4200:4200
      - 8083:80  
    restart: always
    depends_on:
      - mypostgres
      - springbootapp
    links:
      - mypostgres
      - springbootapp
