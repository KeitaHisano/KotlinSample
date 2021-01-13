package com.example.kotlinspringbootdemo.application.service

import com.example.kotlinspringbootdemo.application.RecordNotFoundException
import com.example.kotlinspringbootdemo.application.input.CustomerInput
import com.example.kotlinspringbootdemo.domain.model.Customer
import com.example.kotlinspringbootdemo.domain.repository.CustomerRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class CustomerApplicationService(
    private val customerRepository: CustomerRepository
) {
    fun findAll(): List<Customer> {
        return customerRepository.findAll()
    }

    fun findById(id: Int): Customer {
        return customerRepository.findById(id) ?: throw RecordNotFoundException()
    }

    fun create(customerInput: CustomerInput): Int {
        val customer = Customer(
            name = customerInput.name!!,
            email = customerInput.email!!,
            phone_number = customerInput.phone_number!!,
            github_name = customerInput.github_name!!,
            twitter_name = customerInput.twitter_name!!,
            main_org = customerInput.main_org!!,
            sub_org = customerInput.sub_org!!
        )

        return customerRepository.create(customer)
    }

    fun update(id: Int, customerInput: CustomerInput) {
        val existingCustomer = customerRepository.findById(id) ?: throw RecordNotFoundException()

        val customer = existingCustomer.copy(
            name = customerInput.name!!,
            email = customerInput.email!!,
            phone_number = customerInput.phone_number!!,
            github_name = customerInput.github_name!!,
            twitter_name = customerInput.twitter_name!!,
            main_org = customerInput.main_org!!,
            sub_org = customerInput.sub_org!!
        )

        customerRepository.update(customer)
    }

    fun delete(id: Int) {
        val customer = customerRepository.findById(id) ?: throw RecordNotFoundException()
        customerRepository.delete(customer)
    }
}