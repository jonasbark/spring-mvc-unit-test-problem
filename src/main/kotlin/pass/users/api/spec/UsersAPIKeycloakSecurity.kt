package pass.users.api.spec

import org.springframework.core.annotation.Order
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter

@EnableWebSecurity(debug = true)
@Order(2)
class UsersAPIKeycloakSecurity : WebSecurityConfigurerAdapter() {
    override fun configure(http: HttpSecurity) {
        http.authorizeRequests {
            it.antMatchers(HttpMethod.GET, "/tenants/").access("hasAuthority('pass.user')")
            it.antMatchers(
                HttpMethod.POST,
                "/tenants/"
            ).access("hasAuthority('pass.user.admin') and hasAuthority('pass.user')")
            it.antMatchers(
                HttpMethod.DELETE,
                "/tenants/{tenantId:[\\d+]}/"
            ).access("hasAuthority('pass.user.admin') and hasAuthority('pass.user')")
            it.antMatchers(
                HttpMethod.GET,
                "/tenants/{tenantId:[\\d+]}/"
            ).access("hasAuthority('pass.user')")
            it.antMatchers(
                HttpMethod.PUT,
                "/tenants/{tenantId:[\\d+]}/"
            ).access("hasAuthority('pass.user.admin') and hasAuthority('pass.user')")

            it.antMatchers(
                HttpMethod.GET,
                "/tenants/{tenantId:[\\d+]}/users/"
            ).access("hasAuthority('pass.user.user-list') and hasAuthority('pass.user')")
            it.antMatchers(
                HttpMethod.POST,
                "/tenants/{tenantId:[\\d+]}/users/"
            ).access("hasAuthority('pass.user.user-write-admin') and hasAuthority('pass.user')")
        }.also {
            it.cors().disable().csrf().disable()
        }
    }
}
