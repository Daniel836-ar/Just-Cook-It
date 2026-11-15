# ---------- Сборка ----------
FROM eclipse-temurin:21-jdk AS build

WORKDIR /app

# Сначала копируем только файлы сборки, чтобы кешировать зависимости
COPY gradlew build.gradle settings.gradle ./
COPY gradle ./gradle
RUN chmod +x gradlew && ./gradlew --no-daemon dependencies

# Затем исходный код приложения
COPY src ./src
RUN ./gradlew --no-daemon bootJar -x test

# ---------- Запуск ----------
FROM eclipse-temurin:21-jre

WORKDIR /app

# Запускаем приложение не от root
RUN groupadd --system spring && useradd --system --gid spring spring

COPY --from=build /app/build/libs/app.jar ./app.jar

USER spring

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
