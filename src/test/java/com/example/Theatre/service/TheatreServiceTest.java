package com.example.Theatre.service;

import com.example.Theatre.dao.TheatreRepository;
import com.example.Theatre.entity.Theatre;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;


@ExtendWith(MockitoExtension.class)
public class TheatreServiceTest {

    @Mock
    TheatreRepository repository;

    @InjectMocks
    TheatreService service;

    @Test
    void getAllTheatres() {
        Theatre theatre1 = new Theatre(1, "name1", "location1");
        Theatre theatre2 = new Theatre(2, "name2", "location2");

        given(repository.getAllTheatres()).willReturn(List.of(theatre1, theatre2));
        List<Theatre> mockValues = service.getAllTheatres();

        assertThat(mockValues.equals(List.of(theatre1, theatre2)));
    }

}
