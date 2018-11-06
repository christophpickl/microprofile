package com.github.christophpickl.microprofile

import org.eclipse.microprofile.health.Health
import org.eclipse.microprofile.health.HealthCheck
import org.eclipse.microprofile.health.HealthCheckResponse
import javax.enterprise.context.ApplicationScoped

@Health
@ApplicationScoped
open class ServiceHealth : HealthCheck {
    override fun call(): HealthCheckResponse =
        HealthCheckResponse.named("service").withData("foo", 42).up().build()
}
