package com.github.christophpickl.microprofile

import java.io.InputStream
import java.io.OutputStream
import java.lang.reflect.Type
import javax.json.Json
import javax.ws.rs.Consumes
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.MultivaluedMap
import javax.ws.rs.ext.MessageBodyReader
import javax.ws.rs.ext.MessageBodyWriter
import javax.ws.rs.ext.Provider

@Provider
@Consumes(MediaType.APPLICATION_JSON)
class BookMessageBodyReader : MessageBodyReader<Account> {

    override fun readFrom(type: Class<Account>?, genericType: Type?, annotations: Array<out Annotation>?, mediaType: MediaType?, httpHeaders: MultivaluedMap<String, String>?, entityStream: InputStream?): Account {
        return Account(42, "TODO")
    }

    override fun isReadable(type: Class<*>, genericType: Type?, annotations: Array<out Annotation>?, mediaType: MediaType?): Boolean =
        type == Account::class.java

}

@Provider
@Produces(MediaType.APPLICATION_JSON)
class BookMessageBodyWriter : MessageBodyWriter<Account> {

    override fun writeTo(t: Account?, type: Class<*>?, genericType: Type?, annotations: Array<out Annotation>?, mediaType: MediaType?, httpHeaders: MultivaluedMap<String, Any>?, entityStream: OutputStream?) {
        val jsonWriter = Json.createWriter(entityStream)
        val jsonObject = Json.createObjectBuilder().add("foo", 42).build()
        jsonWriter.writeObject(jsonObject)
        jsonWriter.close()
    }

    override fun isWriteable(type: Class<*>?, genericType: Type?, annotations: Array<out Annotation>?, mediaType: MediaType?): Boolean =
        type == Account::class.java

}
