package hello

import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.core.Authentication
import org.springframework.security.web.authentication.AuthenticationSuccessHandler
import java.io.IOException
import javax.servlet.ServletException
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse


@Configuration
class AuthConfig : WebSecurityConfigurerAdapter() {

    override fun configure(http: HttpSecurity) {
        super.configure(http)
        http.csrf().disable().authorizeRequests().anyRequest().permitAll()
                .and().httpBasic().disable()
                .logout().disable().formLogin().successHandler(object : AuthenticationSuccessHandler {
            @Throws(IOException::class, ServletException::class)
            override fun onAuthenticationSuccess(request: HttpServletRequest, response: HttpServletResponse, authentication: Authentication) {
                //do nothing
            }
        });

    }
}