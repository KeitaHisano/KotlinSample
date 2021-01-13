package com.example.kotlinspringbootdemo.domain.repository

import com.example.kotlinspringbootdemo.domain.model.Customer

interface CustomerRepository {
    fun findAll(): List<Customer>
    fun findById(id: Int): Customer?
    fun create(customer: Customer): Int
    fun update(customer: Customer)
    fun delete(customer: Customer)
}