package com.challenge.weather.domain.city.usecases

import com.challenge.weather.domain.city.model.City
import com.challenge.weather.domain.city.repository.CityRepository
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class GetCitiesByNameUseCaseTest {

    private val nameCity = "Peru"
    lateinit var useCase: GetCitiesByNameUseCase

    @Mock
    lateinit var cityRepository: CityRepository

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        useCase = GetCitiesByNameUseCase(cityRepository)
    }

    @Test
    fun getCities_execute_notEmpty() = runTest {
        Mockito.`when`(cityRepository.getByName(nameCity))
            .thenReturn(cities())

        Assert.assertTrue(useCase.execute(nameCity).isNotEmpty())
    }

    private fun cities(): List<City> {
        return mutableListOf<City>().apply {
            repeat(10) { index ->
                add(City("Name $index", "Country $index"))
            }
        }
    }
}