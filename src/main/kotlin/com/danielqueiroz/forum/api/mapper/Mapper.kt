package com.danielqueiroz.forum.api.mapper

interface Mapper<T, U> {

    fun map(t: T): U

}
