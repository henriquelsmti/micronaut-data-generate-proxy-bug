package com.example.model

import groovy.transform.CompileStatic
import groovy.transform.EqualsAndHashCode
import io.micronaut.configuration.hibernate.jpa.proxy.GenerateProxy

import javax.persistence.Entity

@Entity
@GenerateProxy
@CompileStatic
@EqualsAndHashCode
class Bacon extends Pork {
	BigDecimal price
}
