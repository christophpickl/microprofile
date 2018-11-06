package com.github.christophpickl.microprofile

import org.eclipse.microprofile.metrics.annotation.Counted
import java.util.concurrent.ConcurrentHashMap
import javax.enterprise.context.ApplicationScoped
import javax.enterprise.context.RequestScoped
import javax.inject.Inject
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.PathParam
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

    init {
        repo[1L] = Account(1L, "myAlias")
        repo[2L] = Account(2L, "yourAlias")
    }

    open fun readAll(): List<Account> = repo.values.toList()

    open fun read(id: Long): Account? = repo[id]

}

@Path("accounts")
@RequestScoped
@Counted
open class AccountResource {

    @Inject
    private lateinit var service: AccountService

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    open fun getAccounts(): Response {
        println("GET /accounts")
        return Response.ok(service.readAll()).build()
    }

    @GET
    @Path("{accountId}")
    @Produces(MediaType.APPLICATION_JSON)
    open fun getAccount(@PathParam("accountId") accountId: Long): Response {
        println("GET /accounts/$accountId")
        val account = service.read(accountId)
        return if (account == null)
            Response.status(Response.Status.NOT_FOUND).build()
        else
            Response.ok(account).build()
    }

}
