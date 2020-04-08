package pass.users.api.spec.handler.tenant

import com.fasterxml.jackson.databind.ObjectMapper
import kotlinx.coroutines.runBlocking
import kotlin.Int
import kotlin.Long
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.server.ResponseStatusException
import org.springframework.web.servlet.function.ServerRequest
import org.springframework.web.servlet.function.ServerResponse
import org.springframework.web.servlet.function.ServerResponse.ok
import org.springframework.web.servlet.function.body
import org.springframework.web.servlet.function.paramOrNull
import pass.users.api.spec.dbo.tenant.TenantTenant

interface TenantTenantDatabaseHandler {
    /**
     * : Provides all tenants.
     * HTTP Code 200: array containing the models
     */
    suspend fun getAll(maxResults: Int?, page: Int?): Page<TenantTenant>

    /**
     * : Creates a tenant.
     * HTTP Code 201: Object of tenant.
     * HTTP Code 400: Validation Error
     */
    suspend fun create(body: TenantTenant): TenantTenant

    /**
     * : Deletes a tenant.
     * HTTP Code 200: Success
     * HTTP Code 404: Not found
     * HTTP Code 409: Subresources must be deleted first!
     */
    suspend fun remove(tenantId: Long)

    /**
     * : Provides a tenant.
     * HTTP Code 200: Object of tenant.
     * HTTP Code 404: Not found
     */
    suspend fun getById(tenantId: Long): TenantTenant?

    /**
     * : Updates a tenant.
     * HTTP Code 200: Object of tenant.
     * HTTP Code 404: Not found
     * HTTP Code 400: Validation Error
     */
    suspend fun update(body: TenantTenant, tenantId: Long): TenantTenant
}

@Component("tenant.Tenant")
class TenantTenantHandler {
    @Autowired
    lateinit var databaseHandler: TenantTenantDatabaseHandler

    @Autowired
    private lateinit var objectMapper: ObjectMapper

    /**
     * : Provides all tenants.
     * HTTP Code 200: array containing the models
     */
    fun getAll(serverRequest: ServerRequest) = success {
        val maxResults = serverRequest.paramOrNull("maxResults")?.toInt() ?: 100
        val page = serverRequest.paramOrNull("page")?.toInt() ?: 0
        databaseHandler.getAll(maxResults, page)
    }

    /**
     * : Creates a tenant.
     * HTTP Code 201: Object of tenant.
     * HTTP Code 400: Validation Error
     */
    fun create(serverRequest: ServerRequest) = success {
        val body: TenantTenant = serverRequest.body()
        databaseHandler.create(body)
    }

    private fun success(function: suspend () -> Any): ServerResponse = runBlocking {
        ok().contentType(MediaType.APPLICATION_JSON).body(function())
    }

    /**
     * : Deletes a tenant.
     * HTTP Code 200: Success
     * HTTP Code 404: Not found
     * HTTP Code 409: Subresources must be deleted first!
     */
    fun remove(serverRequest: ServerRequest) = success {
        val tenantId = serverRequest.pathVariable("tenantId").toLong()
        databaseHandler.remove(tenantId)
    }

    /**
     * : Provides a tenant.
     * HTTP Code 200: Object of tenant.
     * HTTP Code 404: Not found
     */
    fun getById(serverRequest: ServerRequest) = success {
        val tenantId = serverRequest.pathVariable("tenantId").toLong()
        databaseHandler.getById(tenantId) ?: throw ResponseStatusException(HttpStatus.NOT_FOUND)
    }

    /**
     * : Updates a tenant.
     * HTTP Code 200: Object of tenant.
     * HTTP Code 404: Not found
     * HTTP Code 400: Validation Error
     */
    fun update(serverRequest: ServerRequest) = success {
        val body: TenantTenant = serverRequest.body() ?: throw ResponseStatusException(
            HttpStatus.NOT_ACCEPTABLE,
            "Missing body"
        )
        val tenantId = serverRequest.pathVariable("tenantId").toLong()
        databaseHandler.update(body, tenantId)
    }
}


@Component
class TenantHandler : TenantTenantDatabaseHandler {
    override suspend fun getAll(maxResults: Int?, page: Int?): Page<TenantTenant> {
        return PageImpl(emptyList<TenantTenant>())
    }

    override suspend fun create(body: TenantTenant): TenantTenant {
        return body
    }

    override suspend fun remove(tenantId: Long) {

    }

    override suspend fun getById(tenantId: Long): TenantTenant? {
        return TenantTenant()
    }

    override suspend fun update(body: TenantTenant, tenantId: Long): TenantTenant {
        return body
    }

}
