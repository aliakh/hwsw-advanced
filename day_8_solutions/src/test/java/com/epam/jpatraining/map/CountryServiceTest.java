package com.epam.jpatraining.map;

import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.epam.jpatraining.map.domain.CountyEntity;
import com.epam.jpatraining.map.repository.CountyRepository;
import com.epam.jpatraining.map.service.CountryService;


@RunWith(MockitoJUnitRunner.class)
public class CountryServiceTest {

	@InjectMocks
	private CountryService underTest;
	
	@Mock
	private CountyRepository countyRepository;

	@Test
	public void findAllShouldReturnAllCounties() {
		// Given
		List<CountyEntity> actual = new LinkedList<>();
		BDDMockito.given(countyRepository.findAll()).willReturn(actual);
		
		// When
		Iterable<CountyEntity> result = underTest.findAll();

		// Then
		Assert.assertEquals(result, actual);
		BDDMockito.then(countyRepository).should(BDDMockito.times(1)).findAll();
	}
}
