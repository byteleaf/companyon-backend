package de.byteleaf.companyon.auth.boundary

import de.byteleaf.companyon.auth.logic.SecurityContextService
import de.byteleaf.companyon.user.dto.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import graphql.kickstart.tools.GraphQLQueryResolver

@Controller
class SecurityContextResolver : GraphQLQueryResolver {

    @Autowired
    private lateinit var securityContextService: SecurityContextService

    fun getCurrentUser(): User {
        return securityContextService.getCurrentUser()
    }

}