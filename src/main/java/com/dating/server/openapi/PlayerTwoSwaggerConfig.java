package com.dating.server.openapi;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.stereotype.Component;

@OpenAPIDefinition(info = @Info(
        description = "Player2 API",
        version = "0.01",
        title = "Player2 API"
//        contact = @Contact(
//                name = "Andrey Ruzhentsev",
//                email = "a.ruzence@gmail.com"
//        ),
//        license = @License(
//                name = "Apache 2.0",
//                url = "http://www.apache.org/licenses/LICENSE-2.0"
//        )
), servers = @Server(description = "Player2 API", url = "/"))
@Component
public class PlayerTwoSwaggerConfig {
}
