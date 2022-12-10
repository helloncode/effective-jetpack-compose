package bonni.francesco.data

interface PersonRepository {
    fun getPersonList(): List<Person>
}