package com.study.interview.stringManipulation

import com.study.interview.stringManipulation.Question1
import spock.lang.Specification

class Question1Spec extends Specification {

    Question1 q

    void setup() {
        q = new Question1()
    }

    def "return duplicate case1"() {
        given: 'Map contains one key-value pair'
        def s = 'Java'
        def incorrectKey = 'incorrectKey'
        def key = 'a'
        def value = 2

        def map = q.returnDuplicate(s)

        expect: 'Should return the found value when a value is found with the given key'
        map[key as Character] == value

        and: 'Should return null when a value is not found with the given key'
        map['v' as Character] == null

    }
}
