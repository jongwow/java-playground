# Java SPI Demo

## Scripts

```shell
mvn clean package
```

(Mac 기준)
```shell
java -cp ./exchange-rate-api/target/exchange-rate-api-1.0-SNAPSHOT.jar:./exchange-rate-app/target/exchange-rate-app-1.0-SNAPSHOT.jar:./exchange-rate-impl/target/exchange-rate-impl-1.0-SNAPSHOT.jar:"./exchange-rate-impl/target/depends/*" com.jongwow.rate.app.MainApp
```