package com.children.care;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.children.care.entity.Slider;
import com.children.care.repository.SliderRepository;
import com.children.care.service.SliderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

class SliderServiceTest {

    @Mock
    private SliderRepository sliderRepository;

    @InjectMocks
    private SliderService sliderService;

    private Slider slider;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        slider = new Slider();
        slider.setSliderId(1L);
        slider.setTitle("Sample Slider");
        slider.setImage("image.jpg");
        slider.setBacklink("http://example.com");
        slider.setStatus(1);
        slider.setNotes("Sample Notes");
        slider.setCategoryId(2);
        slider.setPostId(3);
    }

    @Test
    void testGetAllSliders() {
        when(sliderRepository.findAll()).thenReturn(Arrays.asList(slider));
        List<Slider> sliders = sliderService.getAllSliders();
        assertEquals(1, sliders.size());
    }

    @Test
    void testGetSliderById() {
        when(sliderRepository.findById(1L)).thenReturn(Optional.of(slider));
        Slider found = sliderService.getSliderById(1L);
        assertNotNull(found);
        assertEquals("Sample Slider", found.getTitle());
    }

    @Test
    void testCreateSlider() {
        when(sliderRepository.save(any(Slider.class))).thenReturn(slider);
        Slider created = sliderService.createSlider(slider);
        assertNotNull(created);
        assertEquals("Sample Slider", created.getTitle());
    }

    @Test
    void testUpdateSlider() {
        when(sliderRepository.findById(1L)).thenReturn(Optional.of(slider));
        when(sliderRepository.save(any(Slider.class))).thenReturn(slider);

        Slider updatedSlider = new Slider();
        updatedSlider.setTitle("Updated Title");
        updatedSlider.setImage("updated.jpg");
        updatedSlider.setBacklink("http://updated.com");
        updatedSlider.setStatus(0);
        updatedSlider.setNotes("Updated Notes");
        updatedSlider.setCategoryId(4);
        updatedSlider.setPostId(5);

        Slider result = sliderService.updateSlider(1L, updatedSlider);
        assertNotNull(result);
        assertEquals("Updated Title", result.getTitle());
    }

    @Test
    void testDeleteSlider() {
        when(sliderRepository.existsById(1L)).thenReturn(true);
        doNothing().when(sliderRepository).deleteById(1L);
        boolean isDeleted = sliderService.deleteSlider(1L);
        assertTrue(isDeleted);
    }
}
