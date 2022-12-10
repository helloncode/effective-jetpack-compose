package bonni.francesco.effectivecompose

import androidx.lifecycle.ViewModel
import bonni.francesco.data.Person
import bonni.francesco.data.PersonRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

data class State(val fakeData: List<Person>)

@HiltViewModel
class MainViewModel @Inject constructor(personRepository: PersonRepository) : ViewModel() {
    private val _state = MutableStateFlow(
        State(personRepository.getPersonList())
    )
    val state
        get() = _state.asStateFlow()

    fun selected(person: Person) {
        val result = _state.value.fakeData.map {
            it.copy(selected = it == person)
        }
        _state.value = State(result)
    }

    fun shuffle() {
        val result = _state.value.fakeData.shuffled()
        _state.value = State(result)
    }
}

