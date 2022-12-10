package bonni.francesco.data

import bonni.francesco.effectivejetpackcompose.sampleDataJson
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import javax.inject.Inject

class PersonRepositoryImpl @Inject constructor(): PersonRepository {
    override fun getPersonList(): List<Person> = Json.decodeFromString(string = sampleDataJson)
}