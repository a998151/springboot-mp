package com.example.springbootmp.groovy

/**
 *
 * @author BCY
 */
class convertDemo {

    static void main(String[] args) {
        def data = [
                list: [
                        [degree: '硕士', level: 1],
                        [name: '方水娣', degree: '本科', level: 1],
                        [name: '光帆', degree: '本科', level: 2],
                        [name: '郑华娜', degree: '博士', level: 1]
                ]
        ]

        println data.list*.name

//        println run(data)
    }


    static List run(Map<String, Object> data) {
        def al = []
        data.list.each {
            if (it.degree == '博士') {
                al << [name: it.name, code: 'A']
            } else if (it.degree == '硕士') {
                al << [name: it.name, code: 'B']
            } else if (it.degree == '本科') {
                al << [name: it.name, code: 'C']
            }
        }
        return al
    }
}
