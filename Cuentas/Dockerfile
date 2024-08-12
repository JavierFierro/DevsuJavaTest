FROM openjdk:17-slim as builder

WORKDIR /app/cuentas-movimientos

COPY ./Cuentas/.mvn ./.mvn
COPY ./Cuentas/mvnw .
COPY ./Cuentas/pom.xml .

RUN ./mvnw clean package -DskipTests -Dmaven.test.skip -Dmaven.main.skip -Dspring-boot.repackage.skip && rm -r ./target

COPY ./Cuentas/src ./src

RUN ./mvnw clean package -DskipTests

FROM openjdk:17-slim

WORKDIR /app

COPY --from=builder /app/cuentas-movimientos/target/Cuentas-0.0.1-SNAPSHOT.jar .

EXPOSE 8001

ENTRYPOINT ["java", "-jar", "Cuentas-0.0.1-SNAPSHOT.jar"]