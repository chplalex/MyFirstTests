package com.geekbrains.myfirsttests

import assertk.tableOf
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class EmailValidatorTest {

    @Test
    fun `positive cases`() {
        tableOf("email")
            .row("name@email.com")
            .row("name@email.co.uk")
            .row("name.family@email.co.uk")
            .forAll { email ->

                val actual = EmailValidator.isValidEmail(email)

                assertTrue(actual)
            }
    }

    @Test
    fun `negative cases`() {
        tableOf("email")
            .row(null as String?)
            .row("name@email")
            .row("name@email..com")
            .row("@email.com")
            .row("user@")
            .row("пользователь@домен.ру")
            .forAll { email ->

                val actual = EmailValidator.isValidEmail(email)

                assertFalse(actual)
            }
    }
}
