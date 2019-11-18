# Developer's Software Conference 2019

## Доклады о Spring Framework, которые стоит посмотреть

* [Евгений Борисов. Spring The Reaper Часть 1](https://youtu.be/BmBr5diz8WA)
* [Евгений Борисов. Spring The Reaper Часть 2](https://youtu.be/cou_qomYLNU)
* [Евгений Борисов. Spring The Reaper](https://youtu.be/hDpa6m48eC4)
* [Евгений Борисов. Spring - Глубоко и не очень](https://youtu.be/nGfeSo52_8A)
* [Евгений Борисов. Spring Patterns](https://youtu.be/61duchvKI6o)
* [Евгений Борисов. Spring Data](https://youtu.be/nwM7A4TwU3M)
* [Евгений Борисов, Барух Садогурский. Spring Puzzlers](https://youtu.be/U8MtGYa04v8)
* [Евгений Борисов. Spring Puzzlers: Второй сезон](https://youtu.be/BFEgLtFLdRI)
* [Евгений Борисов, Барух Садогурский. Приключения Сеньора Холмса и Джуниора Ватсона](https://youtu.be/KABC7Fty3x8)
* [Евгений Борисов, Кирилл Толкачев. Проклятие Spring Test](https://youtu.be/7mZqJShu_3c)
* [Евгений Борисов, Кирилл Толкачев. Boot yourself, Spring is coming Часть 1](https://youtu.be/yy43NOreJG4)
* [Евгений Борисов, Кирилл Толкачев. Boot yourself, Spring is coming Часть 2](https://youtu.be/7Cq5zEm2wq0)

## Книги по Spring, которые стоит прочитать

* [Spring in Action](https://www.ozon.ru/context/detail/id/31239365/)
* [Java в облаке](https://www.ozon.ru/context/detail/id/146748538/)

## Примеры кода

### Базовый микросервис

| Пример | Gradle-Модуль |
|----|:-----|
| Базовый сервис | `basic-microservice` |

### Централизованное хранение конфигураций сервисов

| Пример | Gradle-Модуль |
|----|:-----|
| Сервер конфигураций | `cloud-config:cloud-config-server` |
| Клиент к серверу конфигураций | `cloud-config:cloud-config-client` |

### Service Discovery с использованием Eureka

| Пример | Gradle-Модуль |
|----|:-----|
| Сервер Eureka | `cloud-eureka:eureka-server` |
| Сервер конфигураций | `cloud-eureka:cloud-config-server` |
| Клиентские приложения, которые получают конфиг через Eureka | `cloud-eureka:eureka-client` |

### Получение сервисов через Eureka Client

| Пример | Gradle-Модуль |
|----|:-----|
| Клиент с ручной обработкой ошибок | `cloud-eureka:eureka-client-declarative:discovery-client` |
| Клиент и балансировка нагрузки с помощью Ribbon | `cloud-eureka:eureka-client-declarative:ribbon-client` |
| Клиент с fallback на Hystrix | `cloud-eureka:eureka-client-declarative:hystrix-client` |

### Feign-клиент с Eureka

| Пример | Gradle-Модуль |
|----|:-----|
| Декларативный клиент без fallback | `cloud-eureka:eureka-feign-client:discovery-client` |
| Декларативный клиент с fallback на Hystrix | `cloud-eureka:eureka-feign-client:hystrix-client` |

### Реверс-прокси на Zuul

| Пример | Gradle-Модуль |
|----|:-----|
| Zuul | `cloud-eureka:eureka-zuul` |

### OAuth2 с использованием Spring Cloud Security

| Пример | Gradle-Модуль |
|----|:-----|
| Сервер ресурсов | `cloud-security:security-resource-server` |
| Пример приложения | `cloud-security:security-client-application` |
