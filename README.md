# Spring homework 8, 10

## Settings

Maven project

JDK: Amazon Corretto 17 (corretto-17)

Language level: 17 (SDK default)

---

## Описание проекта

Приложение для ресторанного бизнеса.

**Главная страница** приложения: http://localhost:8080/api

Настройки **запуска**: ./.runConfigurations/RunAll.run.xml

**Микросервисы**:

1. eureka-server
2. api-gateway
3. storage-service
4. personnel-service
5. web-client

Подключен **мониторинг** в storage-service и web-client. 
Файл настройки Prometheus и фото dashboard Grafana в папке ".monitoring".

---

## Задания

### HW 8

**_Базовое задание:_**

Добавить в один из Ваших проектов, сделанных ранее, ApiGateWay и Eureka. 
В проекте обязательно должна быть Spring Data.

**_Задание со звездочкой:_**

В проект так же добавить spring config server
Связь между микросервисами перевести на spring cloud openfeign

### HW 10

**_Базовое задание:_**
1) Подключить к своему проекту зависимости actuator, registry-prometheus и micrometer.
2) Установить и подключить к проекту prometheus
3) Установить и подключить Grafana. В Grafana добавить пару точеу контроля (Например: процессоное время приложения и количество запросов)
   Формат сдачи: проект с добавленными зависимостями, файл настройки prometheus и скриншот Grafana с добавленными контрольными точками.

**_Задание со звездочкой:_**
* Проделать, то же самое с многомодульным проектом (добавить под контроль несколько модулей)
* Добавить собственную метрику.