package pass.users.api.spec.dbo.tenant

import org.springframework.data.annotation.LastModifiedBy
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.util.ProxyUtils
import org.springframework.stereotype.Repository
import java.io.Serializable
import java.util.*
import javax.persistence.*
import kotlin.reflect.full.declaredMemberProperties
import kotlin.reflect.jvm.javaField

/**
 * Includes information about a tenant.
 */
@Entity(name = "TenantTenant")
@Table(name = "tenant_tenant")
data class TenantTenant(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    @Column(
        length = 100,
        nullable = true
    )
    val name: String? = null,
    @LastModifiedDate
    @Column(nullable = true)
    var modificationDate: Date? = null,
    @LastModifiedBy
    @Column(nullable = true)
    var modifierId: String? = null
) : PassModel<TenantTenant, Long>()


@Repository
interface TenantTenantRepository : JpaRepository<TenantTenant, Long>

@MappedSuperclass
abstract class PassModel<Model : Any, ID : Any> : Serializable {

    fun exists() = readId(this) != null

    override fun hashCode(): Int {
        return super.hashCode()
    }

    override fun equals(other: Any?): Boolean {
        other ?: return false

        if (this === other) return true

        if (javaClass != ProxyUtils.getUserClass(other)) return false

        other as PassModel<*, *>

        val idOther: ID? = readId(other)
        val idThis: ID? = readId(this)

        return idOther == idThis
        // return if (null == this.id) false else this.id == other.id
    }

    fun readId(instance: Any): ID? {
        val clazz = instance.javaClass.kotlin
        @Suppress("UNCHECKED_CAST")
        return clazz.declaredMemberProperties.first { it.javaField?.getAnnotation(Id::class.java) != null }.get(
            instance
        ) as ID?
    }
}
