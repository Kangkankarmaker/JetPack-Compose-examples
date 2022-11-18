package k.example.lazycolume.repositiry

import k.example.lazycolume.model.Person

class PersonRepository {
    fun getAllData():List<Person>{
        return listOf(
            Person(
                id = 1,
                firstName = "Kangkan",
                lastName = "Karmaker",
                age = 24
            ),
            Person(
                id = 2,
                firstName = "Kangkan",
                lastName = "k",
                age = 25
            ),
            Person(
                id = 3,
                firstName = "k",
                lastName = "Karmaker",
                age = 26
            ),Person(
                id = 1,
                firstName = "Kangkan",
                lastName = "Karmaker",
                age = 24
            ),
            Person(
                id = 2,
                firstName = "Kangkan",
                lastName = "k",
                age = 25
            ),
            Person(
                id = 3,
                firstName = "k",
                lastName = "Karmaker",
                age = 26
            ),Person(
                id = 1,
                firstName = "Kangkan",
                lastName = "Karmaker",
                age = 24
            ),
            Person(
                id = 2,
                firstName = "Kangkan",
                lastName = "k",
                age = 25
            ),
            Person(
                id = 3,
                firstName = "k",
                lastName = "Karmaker",
                age = 26
            ),Person(
                id = 1,
                firstName = "Kangkan",
                lastName = "Karmaker",
                age = 24
            ),
            Person(
                id = 2,
                firstName = "Kangkan",
                lastName = "k",
                age = 25
            ),
            Person(
                id = 3,
                firstName = "k",
                lastName = "Karmaker",
                age = 26
            )
        )
    }
}