package com.example.model

import io.micronaut.test.extensions.spock.annotation.MicronautTest
import io.micronaut.transaction.SynchronousTransactionManager
import io.micronaut.transaction.TransactionDefinition
import io.micronaut.transaction.support.DefaultTransactionDefinition
import jakarta.inject.Inject
import org.hibernate.SessionFactory
import spock.lang.Specification

@MicronautTest
class LunchSpec extends Specification {

	@Inject
	SynchronousTransactionManager synchronousTransactionManager

	@Inject
	SessionFactory sessionFactory

	void 'Test load'() {
		setup:
		TransactionDefinition definition = new DefaultTransactionDefinition(TransactionDefinition.Propagation.REQUIRES_NEW)
		synchronousTransactionManager.execute(definition) {
			Bacon bacon = new Bacon().tap {
				id = '123'
				date = new Date()
				price = 10
			}
			sessionFactory.currentSession.save(bacon)
			Lunch lunch = new Lunch().tap {
				id = '321'
				it.bacon = bacon
				price = 10
			}
			sessionFactory.currentSession.save(lunch)
		}
		when:
		Lunch lunch = sessionFactory.currentSession.get(Lunch, '321')
		then:
		lunch.price == 10
		lunch.id == '321'
		lunch.bacon
		lunch.bacon.price == 10
		lunch.bacon.id == '123'
		lunch.bacon.date
	}
}
