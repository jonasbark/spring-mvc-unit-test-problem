@file:Suppress("WildcardImport")

package pass.users.api.spec.routes

import kotlin.Suppress
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.function.router
import pass.users.api.spec.handler.tenant.TenantTenantHandler

@Configuration
class Routes {

    @Suppress("LongParameterList")
    @Bean
    fun routingTenant(tenantTenantHandler: TenantTenantHandler) = router {
        GET("/tenants/", tenantTenantHandler::getAll)
        POST("/tenants/", tenantTenantHandler::create)
        DELETE("/tenants/{tenantId}/", tenantTenantHandler::remove)
        GET("/tenants/{tenantId}/", tenantTenantHandler::getById)
        PUT("/tenants/{tenantId}/", tenantTenantHandler::update)
    }
}
