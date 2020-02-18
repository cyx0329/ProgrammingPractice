package com.study.interview.leetCode

import com.study.interview.leetCode.ReverseString
import spock.lang.Specification

class ReverseStringSpec extends Specification {

    ReverseString q;

    void setup() {
        q = new ReverseString()
    }

    def "ReverseString"() {
        given :
            def s = "hello"
            def expected = "olleh"
        when :
            def ns = q.reverseString(s)
        then :
            expected == ns
    }
}
