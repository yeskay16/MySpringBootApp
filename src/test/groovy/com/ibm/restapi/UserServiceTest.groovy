package com.ibm.restapi

import com.ibm.restapi.service.UserService
import spock.lang.Specification

class UserServiceTest extends  Specification{

    def "user service test"() {
        given:
        UserService userService = new UserService()
        when:
        def user = userService.getUserFromListOrDb(1000)
        then:
        user.getId() == 1000

    }
}
