# Платформа знаний и сервисов «Деловая среда»| Java | Тестовое задание на АВТ

## Задание:
1. Написать 2 любых функциональных автотеста на Java для любого открытого и реально работающего интернет-ресурса.
Один из автотестов обязательно должен включать в себя заполнение формы.
2. Написать 2 любых API-автотеста на Java для любого открытого и реально работающего интернет-ресурса.
   
## Критерии проверки:
Проверяющий может скачать код и, руководствуясь документацией, запустить тесты.

## Решение:

Для тестирования выбран сервис https://www.mvideo.ru/.

1. UI автотесты:

    1.1. Провека отображения списка главной страницы.

    1.2. Проверка работы поиска. (Включает заполнение формы.)

2. API автотесты:

   2.1. Запрос должен венуть статус 200 при запросе по индификатору категории.

   2.2. Запрос должен вернуть список описания продуктов по списку идентификаторов.

## Запуск тестов:
Скачать репозиторий и запустить тесты через консоль с помощью команды:
```bash
./gradlew clean test
```



