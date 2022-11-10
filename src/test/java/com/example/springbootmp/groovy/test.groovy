package com.example.springbootmp.groovy

/**
 *
 * @author BCY
 */
class test {

    static void main(String[] args) {
        def nn = null
        println nn.isEmpty()

        def list = [2,3,4,6]
        println list
        println list.size()

        def map = [map: [data: 'Hello']]
        println map.map.data

        def a = "Hello"
        def b = "World"

        println "a + ' ' + b"
        println "${a} + ' ' + ${b}"
        println "$a + ' ' + $b"


        def bi_a = {
            println "a this:" + this
            println "a owner:" + owner // ower指向 bi_a

            def bi_b = {
                println "b this:" + this
                println "b owner:" + owner // ower指向 bi_b
            }
            bi_b.call()
        }
        bi_a.call()


        def a_san = null;
        def b_san = a_san?.trim() ? a_san : 'none'
        println b_san


        def a_map = [map1: [data: 'Hello']]
        def b_map = a_map.map ?.data
        println b_map


        (1..<5).each { println(it) }
    }
}
