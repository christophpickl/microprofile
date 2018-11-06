package com.github.christophpickl.microprofile

import org.eclipse.microprofile.metrics.annotation.Counted
import java.util.concurrent.ConcurrentHashMap
import javax.enterprise.context.ApplicationScoped
import javax.enterprise.context.RequestScoped
import javax.inject.Inject
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

data class Account(
    val id: Long,
    val alias: String
)

@ApplicationScoped
open class AccountService {

    private val repo = ConcurrentHashMap<Long, Account>()

    open fun readAll(): List<Account> = repo.values.toList()

}

@Path("accounts")
@RequestScoped
@Counted
open class AccountResource {


    @Inject
    private lateinit var service: AccountService

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    open fun getAccounts() = Response.ok(service.readAll()).build()

}
