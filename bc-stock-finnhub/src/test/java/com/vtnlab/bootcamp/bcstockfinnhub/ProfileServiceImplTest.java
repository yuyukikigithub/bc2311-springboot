package com.vtnlab.bootcamp.bcstockfinnhub;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.client.RestTemplate;

import com.vtnlab.bootcamp.bcstockfinnhub.model.Profile;
import com.vtnlab.bootcamp.bcstockfinnhub.service.impl.ProfileServiceImpl;

@WebMvcTest(ProfileServiceImpl.class)
public class ProfileServiceImplTest {

    @MockBean
    private RestTemplate restTemplate;
    
    @Test
    void getProfileTest(){
        Profile profile = new Profile(null, null, null, null, null, null, null, 0, null, 0, null, null);
        Mockito.when(restTemplate.getForObject("profile.com", Profile.class)).thenReturn(profile);
        assertEquals(restTemplate.getForObject("profile.com", Profile.class),profile);
    }

}
