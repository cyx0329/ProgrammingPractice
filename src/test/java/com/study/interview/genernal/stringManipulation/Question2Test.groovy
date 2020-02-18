package com.study.interview.genernal.stringManipulation

import com.study.interview.genernal.stringManipulation.stringManipulation.Question2
import spock.lang.Specification

class Question2Test extends Specification {

    Question2 q

    void setup(){
        q = new Question2()
    }

    def "AreAnagrams"() {
        expect :
            q.areAnagrams(s1, s2) == result

        where :
            s1 | s2 | result
            'anagram' | 'nagaram' | true
            'rat' | 'car' | false
            null | null | true
            null | 'java' | false
            '' | '' | true
            'java' | '' | false
            '' | null | false
            null | '' | false
    }
}
