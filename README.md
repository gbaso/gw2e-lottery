# gw2e-lottery
Automatic lottery subscriber for GW2 Efficiency

Build docker image:

```sh
./mvnw spring-boot:build-image
```

Run it:

```sh
docker run -d \
  -p 8080:8080 \
  -e SPRING_DATASOURCE_URL=<your_jdbc_connection_url>  \
  -e SPRING_DATASOURCE_USERNAME=<your_jdbc_connection_username> \
  -e SPRING_DATASOURCE_PASSWORD=<your_jdbc_connection_password>  \
  gbaso/gw2e-lottery:<version>
```

Create an account:

```http
POST /accounts
{
  "name": "<your_account_name>"
}
```

This application will try to subscribe all of your accounts every 24 hours
