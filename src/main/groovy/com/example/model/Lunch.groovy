package com.example.model

import groovy.transform.CompileStatic
import groovy.transform.EqualsAndHashCode
import io.micronaut.configuration.hibernate.jpa.proxy.GenerateProxy

import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.Id
import javax.persistence.ManyToOne

@Entity
@GenerateProxy
@CompileStatic
@EqualsAndHashCode
class Lunch {
	@Id
	String id
	@ManyToOne(fetch = FetchType.LAZY)
	Bacon bacon
	BigDecimal price
}
