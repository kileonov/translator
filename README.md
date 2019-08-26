# Translator Project
_translator_ is Spring Boot application that uses Yandex Translation API

# API calls
* GET /translate
  * text - text to be translated
  * from - language that initial text is provided
  * to - language that initial text needs to be traslated to
* Example: localhost:8080/translate?text=Привет?&to=en&from=ru

# How to use this repository?
* Step 1 : Clone this repository.
* Step 2 : mvn clean install
* Step 3 : java -jar target/translator-0.0.1-SNAPSHOT.jar

# Technologies used
* Spring Bootstrap
* Spring Web
* Spring Data
* H2 database
* Yandex Translation API
