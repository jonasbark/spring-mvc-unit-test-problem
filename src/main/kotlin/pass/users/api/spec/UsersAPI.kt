package pass.users.api.spec

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
@ConfigurationPropertiesScan
@EnableJpaRepositories
class UsersAPI

@Suppress("SpreadOperator")
fun main(args: Array<String>) {
    runApplication<UsersAPI>(*args)
}
