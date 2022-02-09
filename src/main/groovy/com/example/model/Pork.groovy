package com.example.model

import groovy.transform.CompileStatic
import groovy.transform.EqualsAndHashCode
import io.micronaut.configuration.hibernate.jpa.proxy.GenerateProxy

import javax.persistence.Id
import javax.persistence.MappedSuperclass

@MappedSuperclass
@GenerateProxy
@CompileStatic
@EqualsAndHashCode()
class Pork {
	@Id
	String id

	Date date
}
