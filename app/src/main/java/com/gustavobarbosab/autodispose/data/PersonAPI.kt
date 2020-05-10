package com.gustavobarbosab.autodispose.data

import com.gustavobarbosab.autodispose.domain.Person
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface PersonAPI {

    @GET("people")
    fun getPeople(): Single<List<Person>>
}