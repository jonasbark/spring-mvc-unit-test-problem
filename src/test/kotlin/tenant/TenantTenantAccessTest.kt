package tenant

import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.security.test.context.support.WithMockUser
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.delete
import org.springframework.test.web.servlet.post
import org.springframework.test.web.servlet.put
import pass.users.api.spec.UsersAPI
import pass.users.api.spec.dbo.tenant.TenantTenant
import pass.users.api.spec.dbo.tenant.TenantTenantRepository

@RunWith(SpringRunner::class)
@ActiveProfiles("test")
@SpringBootTest(classes = [UsersAPI::class])
@AutoConfigureMockMvc
class TenantTenantAccessTest {
    @Autowired
    private lateinit var tenantTenantRepository: TenantTenantRepository

    private lateinit var testDbEntity: TenantTenant

    private val testEntity: TenantTenant = TenantTenant(
        name = "0"
    )

    @Autowired
    private lateinit var mockMvc: MockMvc

    @Autowired
    private lateinit var objectMapper: ObjectMapper

    @Before
    fun createDatabaseContent() {
        tenantTenantRepository.deleteAll()
        testDbEntity = tenantTenantRepository.save(testEntity)
    }

    @Test
    @WithMockUser(authorities = ["pass.user", "pass.client.admin"])
    fun `pass client admin forbidden on create 5e79d316c1528`() {
        val body: TenantTenant = testEntity
        mockMvc.post("/tenants/") {
            accept(MediaType.APPLICATION_JSON)
            contentType = MediaType.APPLICATION_JSON
            content = objectMapper.writeValueAsString(body)
        }.andExpect {
            status { isForbidden }
        }
    }

    @Test
    @WithMockUser(authorities = ["pass.user", "pass.scope.admin"])
    fun `pass scope admin forbidden on create 5e79d316c1528`() {
        val body: TenantTenant = testEntity
        mockMvc.post("/tenants/") {
            accept(MediaType.APPLICATION_JSON)
            contentType = MediaType.APPLICATION_JSON
            content = objectMapper.writeValueAsString(body)
        }.andExpect {
            status { isForbidden }
        }
    }

    @Test
    @WithMockUser(authorities = ["pass.user", "pass.client"])
    fun `pass client forbidden on create 5e79d316c1528`() {
        val body: TenantTenant = testEntity
        mockMvc.post("/tenants/") {
            accept(MediaType.APPLICATION_JSON)
            contentType = MediaType.APPLICATION_JSON
            content = objectMapper.writeValueAsString(body)
        }.andExpect {
            status { isForbidden }
        }
    }

    @Test
    @WithMockUser(authorities = ["pass.user", "pass.scope"])
    fun `pass scope forbidden on create 5e79d316c1528`() {
        val body: TenantTenant = testEntity
        mockMvc.post("/tenants/") {
            accept(MediaType.APPLICATION_JSON)
            contentType = MediaType.APPLICATION_JSON
            content = objectMapper.writeValueAsString(body)
        }.andExpect {
            status { isForbidden }
        }
    }

    @Test
    @WithMockUser(authorities = ["pass.user", "pass.user.user-read-admin"])
    fun `pass user user-read-admin forbidden on create 5e79d316c1528`() {
        val body: TenantTenant = testEntity
        mockMvc.post("/tenants/") {
            accept(MediaType.APPLICATION_JSON)
            contentType = MediaType.APPLICATION_JSON
            content = objectMapper.writeValueAsString(body)
        }.andExpect {
            status { isForbidden }
        }
    }

    @Test
    @WithMockUser(authorities = ["pass.user", "pass.user"])
    fun `pass user forbidden on create 5e79d316c1528`() {
        val body: TenantTenant = testEntity
        mockMvc.post("/tenants/") {
            accept(MediaType.APPLICATION_JSON)
            contentType = MediaType.APPLICATION_JSON
            content = objectMapper.writeValueAsString(body)
        }.andExpect {
            status { isForbidden }
        }
    }

    @Test
    @WithMockUser(authorities = ["pass.user", "pass.user.user-list"])
    fun `pass user user-list forbidden on create 5e79d316c1528`() {
        val body: TenantTenant = testEntity
        mockMvc.post("/tenants/") {
            accept(MediaType.APPLICATION_JSON)
            contentType = MediaType.APPLICATION_JSON
            content = objectMapper.writeValueAsString(body)
        }.andExpect {
            status { isForbidden }
        }
    }

    @Test
    @WithMockUser(authorities = ["pass.user", "pass.user.role-admin"])
    fun `pass user role-admin forbidden on create 5e79d316c1528`() {
        val body: TenantTenant = testEntity
        mockMvc.post("/tenants/") {
            accept(MediaType.APPLICATION_JSON)
            contentType = MediaType.APPLICATION_JSON
            content = objectMapper.writeValueAsString(body)
        }.andExpect {
            status { isForbidden }
        }
    }

    @Test
    @WithMockUser(authorities = ["pass.user", "pass.user.logs"])
    fun `pass user logs forbidden on create 5e79d316c1528`() {
        val body: TenantTenant = testEntity
        mockMvc.post("/tenants/") {
            accept(MediaType.APPLICATION_JSON)
            contentType = MediaType.APPLICATION_JSON
            content = objectMapper.writeValueAsString(body)
        }.andExpect {
            status { isForbidden }
        }
    }

    @Test
    @WithMockUser(authorities = ["pass.user", "pass.mail"])
    fun `pass mail forbidden on create 5e79d316c1528`() {
        val body: TenantTenant = testEntity
        mockMvc.post("/tenants/") {
            accept(MediaType.APPLICATION_JSON)
            contentType = MediaType.APPLICATION_JSON
            content = objectMapper.writeValueAsString(body)
        }.andExpect {
            status { isForbidden }
        }
    }

    @Test
    @WithMockUser(authorities = ["pass.user", "pass.user.user-write-admin"])
    fun `pass user user-write-admin forbidden on create 5e79d316c1528`() {
        val body: TenantTenant = testEntity
        mockMvc.post("/tenants/") {
            accept(MediaType.APPLICATION_JSON)
            contentType = MediaType.APPLICATION_JSON
            content = objectMapper.writeValueAsString(body)
        }.andExpect {
            status { isForbidden }
        }
    }

    @Test
    @WithMockUser(authorities = ["pass.user", "pass.user.admin"])
    fun `pass user admin allowed on create 5e79d316c1528`() {
        val body: TenantTenant = testEntity
        mockMvc.post("/tenants/") {
            accept(MediaType.APPLICATION_JSON)
            contentType = MediaType.APPLICATION_JSON
            content = objectMapper.writeValueAsString(body)
        }.andExpect {
            status { isOk }
        }
    }

    @Test
    @WithMockUser(authorities = ["pass.user", "zeasd.rgasd"])
    fun `zeasd rgasd forbidden on create 5e79d316c1528`() {
        val body: TenantTenant = testEntity
        mockMvc.post("/tenants/") {
            accept(MediaType.APPLICATION_JSON)
            contentType = MediaType.APPLICATION_JSON
            content = objectMapper.writeValueAsString(body)
        }.andExpect {
            status { isForbidden }
        }
    }

    @Test
    @WithMockUser(authorities = ["pass.user", "test.scope"])
    fun `test scope forbidden on create 5e79d316c1528`() {
        val body: TenantTenant = testEntity
        mockMvc.post("/tenants/") {
            accept(MediaType.APPLICATION_JSON)
            contentType = MediaType.APPLICATION_JSON
            content = objectMapper.writeValueAsString(body)
        }.andExpect {
            status { isForbidden }
        }
    }

    @Test
    @WithMockUser(authorities = ["pass.user", "pass.launcher"])
    fun `pass launcher forbidden on create 5e79d316c1528`() {
        val body: TenantTenant = testEntity
        mockMvc.post("/tenants/") {
            accept(MediaType.APPLICATION_JSON)
            contentType = MediaType.APPLICATION_JSON
            content = objectMapper.writeValueAsString(body)
        }.andExpect {
            status { isForbidden }
        }
    }

    @Test
    @WithMockUser(authorities = ["pass.user", "pass.user.device-read-admin"])
    fun `pass user device-read-admin forbidden on create 5e79d316c1528`() {
        val body: TenantTenant = testEntity
        mockMvc.post("/tenants/") {
            accept(MediaType.APPLICATION_JSON)
            contentType = MediaType.APPLICATION_JSON
            content = objectMapper.writeValueAsString(body)
        }.andExpect {
            status { isForbidden }
        }
    }

    @Test
    @WithMockUser(authorities = ["pass.user", "test.testashbda"])
    fun `test testashbda forbidden on create 5e79d316c1528`() {
        val body: TenantTenant = testEntity
        mockMvc.post("/tenants/") {
            accept(MediaType.APPLICATION_JSON)
            contentType = MediaType.APPLICATION_JSON
            content = objectMapper.writeValueAsString(body)
        }.andExpect {
            status { isForbidden }
        }
    }

    @Test
    @WithMockUser(authorities = ["pass.user", "pass.client.admin"])
    fun `pass client admin forbidden on remove 5e79d316c1584`() {
        val tenantId: Long = testDbEntity.id!!
        mockMvc.delete("/tenants/{tenantId}/", tenantId) {
            accept(MediaType.APPLICATION_JSON)
            contentType = MediaType.APPLICATION_JSON

        }.andExpect {
            status { isForbidden }
        }
    }

    @Test
    @WithMockUser(authorities = ["pass.user", "pass.scope.admin"])
    fun `pass scope admin forbidden on remove 5e79d316c1584`() {
        val tenantId: Long = testDbEntity.id!!
        mockMvc.delete("/tenants/{tenantId}/", tenantId) {
            accept(MediaType.APPLICATION_JSON)
            contentType = MediaType.APPLICATION_JSON

        }.andExpect {
            status { isForbidden }
        }
    }

    @Test
    @WithMockUser(authorities = ["pass.user", "pass.client"])
    fun `pass client forbidden on remove 5e79d316c1584`() {
        val tenantId: Long = testDbEntity.id!!
        mockMvc.delete("/tenants/{tenantId}/", tenantId) {
            accept(MediaType.APPLICATION_JSON)
            contentType = MediaType.APPLICATION_JSON

        }.andExpect {
            status { isForbidden }
        }
    }

    @Test
    @WithMockUser(authorities = ["pass.user", "pass.scope"])
    fun `pass scope forbidden on remove 5e79d316c1584`() {
        val tenantId: Long = testDbEntity.id!!
        mockMvc.delete("/tenants/{tenantId}/", tenantId) {
            accept(MediaType.APPLICATION_JSON)
            contentType = MediaType.APPLICATION_JSON

        }.andExpect {
            status { isForbidden }
        }
    }

    @Test
    @WithMockUser(authorities = ["pass.user", "pass.user.user-read-admin"])
    fun `pass user user-read-admin forbidden on remove 5e79d316c1584`() {
        val tenantId: Long = testDbEntity.id!!
        mockMvc.delete("/tenants/{tenantId}/", tenantId) {
            accept(MediaType.APPLICATION_JSON)
            contentType = MediaType.APPLICATION_JSON

        }.andExpect {
            status { isForbidden }
        }
    }

    @Test
    @WithMockUser(authorities = ["pass.user", "pass.user"])
    fun `pass user forbidden on remove 5e79d316c1584`() {
        val tenantId: Long = testDbEntity.id!!
        mockMvc.delete("/tenants/{tenantId}/", tenantId) {
            accept(MediaType.APPLICATION_JSON)
            contentType = MediaType.APPLICATION_JSON

        }.andExpect {
            status { isForbidden }
        }
    }

    @Test
    @WithMockUser(authorities = ["pass.user", "pass.user.user-list"])
    fun `pass user user-list forbidden on remove 5e79d316c1584`() {
        val tenantId: Long = testDbEntity.id!!
        mockMvc.delete("/tenants/{tenantId}/", tenantId) {
            accept(MediaType.APPLICATION_JSON)
            contentType = MediaType.APPLICATION_JSON

        }.andExpect {
            status { isForbidden }
        }
    }

    @Test
    @WithMockUser(authorities = ["pass.user", "pass.user.role-admin"])
    fun `pass user role-admin forbidden on remove 5e79d316c1584`() {
        val tenantId: Long = testDbEntity.id!!
        mockMvc.delete("/tenants/{tenantId}/", tenantId) {
            accept(MediaType.APPLICATION_JSON)
            contentType = MediaType.APPLICATION_JSON

        }.andExpect {
            status { isForbidden }
        }
    }

    @Test
    @WithMockUser(authorities = ["pass.user", "pass.user.logs"])
    fun `pass user logs forbidden on remove 5e79d316c1584`() {
        val tenantId: Long = testDbEntity.id!!
        mockMvc.delete("/tenants/{tenantId}/", tenantId) {
            accept(MediaType.APPLICATION_JSON)
            contentType = MediaType.APPLICATION_JSON

        }.andExpect {
            status { isForbidden }
        }
    }

    @Test
    @WithMockUser(authorities = ["pass.user", "pass.mail"])
    fun `pass mail forbidden on remove 5e79d316c1584`() {
        val tenantId: Long = testDbEntity.id!!
        mockMvc.delete("/tenants/{tenantId}/", tenantId) {
            accept(MediaType.APPLICATION_JSON)
            contentType = MediaType.APPLICATION_JSON

        }.andExpect {
            status { isForbidden }
        }
    }

    @Test
    @WithMockUser(authorities = ["pass.user", "pass.user.user-write-admin"])
    fun `pass user user-write-admin forbidden on remove 5e79d316c1584`() {
        val tenantId: Long = testDbEntity.id!!
        mockMvc.delete("/tenants/{tenantId}/", tenantId) {
            accept(MediaType.APPLICATION_JSON)
            contentType = MediaType.APPLICATION_JSON

        }.andExpect {
            status { isForbidden }
        }
    }

    @Test
    @WithMockUser(authorities = ["pass.user", "pass.user.admin"])
    fun `pass user admin allowed on remove 5e79d316c1584`() {
        val tenantId: Long = testDbEntity.id!!
        mockMvc.delete("/tenants/{tenantId}/", tenantId) {
            accept(MediaType.APPLICATION_JSON)
            contentType = MediaType.APPLICATION_JSON

        }.andExpect {
            status { isOk }
        }
    }

    @Test
    @WithMockUser(authorities = ["pass.user", "zeasd.rgasd"])
    fun `zeasd rgasd forbidden on remove 5e79d316c1584`() {
        val tenantId: Long = testDbEntity.id!!
        mockMvc.delete("/tenants/{tenantId}/", tenantId) {
            accept(MediaType.APPLICATION_JSON)
            contentType = MediaType.APPLICATION_JSON

        }.andExpect {
            status { isForbidden }
        }
    }

    @Test
    @WithMockUser(authorities = ["pass.user", "test.scope"])
    fun `test scope forbidden on remove 5e79d316c1584`() {
        val tenantId: Long = testDbEntity.id!!
        mockMvc.delete("/tenants/{tenantId}/", tenantId) {
            accept(MediaType.APPLICATION_JSON)
            contentType = MediaType.APPLICATION_JSON

        }.andExpect {
            status { isForbidden }
        }
    }

    @Test
    @WithMockUser(authorities = ["pass.user", "pass.launcher"])
    fun `pass launcher forbidden on remove 5e79d316c1584`() {
        val tenantId: Long = testDbEntity.id!!
        mockMvc.delete("/tenants/{tenantId}/", tenantId) {
            accept(MediaType.APPLICATION_JSON)
            contentType = MediaType.APPLICATION_JSON

        }.andExpect {
            status { isForbidden }
        }
    }

    @Test
    @WithMockUser(authorities = ["pass.user", "pass.user.device-read-admin"])
    fun `pass user device-read-admin forbidden on remove 5e79d316c1584`() {
        val tenantId: Long = testDbEntity.id!!
        mockMvc.delete("/tenants/{tenantId}/", tenantId) {
            accept(MediaType.APPLICATION_JSON)
            contentType = MediaType.APPLICATION_JSON

        }.andExpect {
            status { isForbidden }
        }
    }

    @Test
    @WithMockUser(authorities = ["pass.user", "test.testashbda"])
    fun `test testashbda forbidden on remove 5e79d316c1584`() {
        val tenantId: Long = testDbEntity.id!!
        mockMvc.delete("/tenants/{tenantId}/", tenantId) {
            accept(MediaType.APPLICATION_JSON)
            contentType = MediaType.APPLICATION_JSON

        }.andExpect {
            status { isForbidden }
        }
    }

    @Test
    @WithMockUser(authorities = ["pass.user", "pass.client.admin"])
    fun `pass client admin forbidden on update 5e79d316c1636`() {
        val body: TenantTenant = testEntity
        val tenantId: Long = testDbEntity.id!!
        mockMvc.put("/tenants/{tenantId}/", tenantId) {
            accept(MediaType.APPLICATION_JSON)
            contentType = MediaType.APPLICATION_JSON
            content = objectMapper.writeValueAsString(body)
        }.andExpect {
            status { isForbidden }
        }
    }

    @Test
    @WithMockUser(authorities = ["pass.user", "pass.scope.admin"])
    fun `pass scope admin forbidden on update 5e79d316c1636`() {
        val body: TenantTenant = testEntity
        val tenantId: Long = testDbEntity.id!!
        mockMvc.put("/tenants/{tenantId}/", tenantId) {
            accept(MediaType.APPLICATION_JSON)
            contentType = MediaType.APPLICATION_JSON
            content = objectMapper.writeValueAsString(body)
        }.andExpect {
            status { isForbidden }
        }
    }

    @Test
    @WithMockUser(authorities = ["pass.user", "pass.client"])
    fun `pass client forbidden on update 5e79d316c1636`() {
        val body: TenantTenant = testEntity
        val tenantId: Long = testDbEntity.id!!
        mockMvc.put("/tenants/{tenantId}/", tenantId) {
            accept(MediaType.APPLICATION_JSON)
            contentType = MediaType.APPLICATION_JSON
            content = objectMapper.writeValueAsString(body)
        }.andExpect {
            status { isForbidden }
        }
    }

    @Test
    @WithMockUser(authorities = ["pass.user", "pass.scope"])
    fun `pass scope forbidden on update 5e79d316c1636`() {
        val body: TenantTenant = testEntity
        val tenantId: Long = testDbEntity.id!!
        mockMvc.put("/tenants/{tenantId}/", tenantId) {
            accept(MediaType.APPLICATION_JSON)
            contentType = MediaType.APPLICATION_JSON
            content = objectMapper.writeValueAsString(body)
        }.andExpect {
            status { isForbidden }
        }
    }

    @Test
    @WithMockUser(authorities = ["pass.user", "pass.user.user-read-admin"])
    fun `pass user user-read-admin forbidden on update 5e79d316c1636`() {
        val body: TenantTenant = testEntity
        val tenantId: Long = testDbEntity.id!!
        mockMvc.put("/tenants/{tenantId}/", tenantId) {
            accept(MediaType.APPLICATION_JSON)
            contentType = MediaType.APPLICATION_JSON
            content = objectMapper.writeValueAsString(body)
        }.andExpect {
            status { isForbidden }
        }
    }

    @Test
    @WithMockUser(authorities = ["pass.user", "pass.user"])
    fun `pass user forbidden on update 5e79d316c1636`() {
        val body: TenantTenant = testEntity
        val tenantId: Long = testDbEntity.id!!
        mockMvc.put("/tenants/{tenantId}/", tenantId) {
            accept(MediaType.APPLICATION_JSON)
            contentType = MediaType.APPLICATION_JSON
            content = objectMapper.writeValueAsString(body)
        }.andExpect {
            status { isForbidden }
        }
    }

    @Test
    @WithMockUser(authorities = ["pass.user", "pass.user.user-list"])
    fun `pass user user-list forbidden on update 5e79d316c1636`() {
        val body: TenantTenant = testEntity
        val tenantId: Long = testDbEntity.id!!
        mockMvc.put("/tenants/{tenantId}/", tenantId) {
            accept(MediaType.APPLICATION_JSON)
            contentType = MediaType.APPLICATION_JSON
            content = objectMapper.writeValueAsString(body)
        }.andExpect {
            status { isForbidden }
        }
    }

    @Test
    @WithMockUser(authorities = ["pass.user", "pass.user.role-admin"])
    fun `pass user role-admin forbidden on update 5e79d316c1636`() {
        val body: TenantTenant = testEntity
        val tenantId: Long = testDbEntity.id!!
        mockMvc.put("/tenants/{tenantId}/", tenantId) {
            accept(MediaType.APPLICATION_JSON)
            contentType = MediaType.APPLICATION_JSON
            content = objectMapper.writeValueAsString(body)
        }.andExpect {
            status { isForbidden }
        }
    }

    @Test
    @WithMockUser(authorities = ["pass.user", "pass.user.logs"])
    fun `pass user logs forbidden on update 5e79d316c1636`() {
        val body: TenantTenant = testEntity
        val tenantId: Long = testDbEntity.id!!
        mockMvc.put("/tenants/{tenantId}/", tenantId) {
            accept(MediaType.APPLICATION_JSON)
            contentType = MediaType.APPLICATION_JSON
            content = objectMapper.writeValueAsString(body)
        }.andExpect {
            status { isForbidden }
        }
    }

    @Test
    @WithMockUser(authorities = ["pass.user", "pass.mail"])
    fun `pass mail forbidden on update 5e79d316c1636`() {
        val body: TenantTenant = testEntity
        val tenantId: Long = testDbEntity.id!!
        mockMvc.put("/tenants/{tenantId}/", tenantId) {
            accept(MediaType.APPLICATION_JSON)
            contentType = MediaType.APPLICATION_JSON
            content = objectMapper.writeValueAsString(body)
        }.andExpect {
            status { isForbidden }
        }
    }

    @Test
    @WithMockUser(authorities = ["pass.user", "pass.user.user-write-admin"])
    fun `pass user user-write-admin forbidden on update 5e79d316c1636`() {
        val body: TenantTenant = testEntity
        val tenantId: Long = testDbEntity.id!!
        mockMvc.put("/tenants/{tenantId}/", tenantId) {
            accept(MediaType.APPLICATION_JSON)
            contentType = MediaType.APPLICATION_JSON
            content = objectMapper.writeValueAsString(body)
        }.andExpect {
            status { isForbidden }
        }
    }

    @Test
    @WithMockUser(authorities = ["pass.user", "pass.user.admin"])
    fun `pass user admin allowed on update 5e79d316c1636`() {
        val body: TenantTenant = testEntity
        val tenantId: Long = testDbEntity.id!!
        mockMvc.put("/tenants/{tenantId}/", tenantId) {
            accept(MediaType.APPLICATION_JSON)
            contentType = MediaType.APPLICATION_JSON
            content = objectMapper.writeValueAsString(body)
        }.andExpect {
            status { isOk }
        }
    }

    @Test
    @WithMockUser(authorities = ["pass.user", "zeasd.rgasd"])
    fun `zeasd rgasd forbidden on update 5e79d316c1636`() {
        val body: TenantTenant = testEntity
        val tenantId: Long = testDbEntity.id!!
        mockMvc.put("/tenants/{tenantId}/", tenantId) {
            accept(MediaType.APPLICATION_JSON)
            contentType = MediaType.APPLICATION_JSON
            content = objectMapper.writeValueAsString(body)
        }.andExpect {
            status { isForbidden }
        }
    }

    @Test
    @WithMockUser(authorities = ["pass.user", "test.scope"])
    fun `test scope forbidden on update 5e79d316c1636`() {
        val body: TenantTenant = testEntity
        val tenantId: Long = testDbEntity.id!!
        mockMvc.put("/tenants/{tenantId}/", tenantId) {
            accept(MediaType.APPLICATION_JSON)
            contentType = MediaType.APPLICATION_JSON
            content = objectMapper.writeValueAsString(body)
        }.andExpect {
            status { isForbidden }
        }
    }

    @Test
    @WithMockUser(authorities = ["pass.user", "pass.launcher"])
    fun `pass launcher forbidden on update 5e79d316c1636`() {
        val body: TenantTenant = testEntity
        val tenantId: Long = testDbEntity.id!!
        mockMvc.put("/tenants/{tenantId}/", tenantId) {
            accept(MediaType.APPLICATION_JSON)
            contentType = MediaType.APPLICATION_JSON
            content = objectMapper.writeValueAsString(body)
        }.andExpect {
            status { isForbidden }
        }
    }

    @Test
    @WithMockUser(authorities = ["pass.user", "pass.user.device-read-admin"])
    fun `pass user device-read-admin forbidden on update 5e79d316c1636`() {
        val body: TenantTenant = testEntity
        val tenantId: Long = testDbEntity.id!!
        mockMvc.put("/tenants/{tenantId}/", tenantId) {
            accept(MediaType.APPLICATION_JSON)
            contentType = MediaType.APPLICATION_JSON
            content = objectMapper.writeValueAsString(body)
        }.andExpect {
            status { isForbidden }
        }
    }

    @Test
    @WithMockUser(authorities = ["pass.user", "test.testashbda"])
    fun `test testashbda forbidden on update 5e79d316c1636`() {
        val body: TenantTenant = testEntity
        val tenantId: Long = testDbEntity.id!!
        mockMvc.put("/tenants/{tenantId}/", tenantId) {
            accept(MediaType.APPLICATION_JSON)
            contentType = MediaType.APPLICATION_JSON
            content = objectMapper.writeValueAsString(body)
        }.andExpect {
            status { isForbidden }
        }
    }
}
