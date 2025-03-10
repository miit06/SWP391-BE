package com.children.care;

import com.children.care.controller.SliderController;
import com.children.care.entity.Slider;
import com.children.care.service.SliderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SliderControllerTest {

    @Mock
    private SliderService sliderService;

    @InjectMocks
    private SliderController sliderController;

    private Slider slider1;
    private Slider slider2;

    @BeforeEach
    void setUp() {
        slider1 = new Slider();
        slider1.setSliderId(1L);
        slider1.setTitle("Slider 1");
        slider1.setImage("image1.jpg");
        slider1.setBacklink("http://example.com");
        slider1.setStatus(1);
        slider1.setNotes("Sample note");
        slider1.setCategoryId(10);
        slider1.setPostId(100);

        slider2 = new Slider();
        slider2.setSliderId(2L);
        slider2.setTitle("Slider 2");
        slider2.setImage("image2.jpg");
        slider2.setBacklink("http://example.com/2");
        slider2.setStatus(0);
        slider2.setNotes("Another note");
        slider2.setCategoryId(20);
        slider2.setPostId(200);
    }

    @Test
    void testGetAllSliders() {
        List<Slider> sliders = Arrays.asList(slider1, slider2);
        when(sliderService.getAllSliders()).thenReturn(sliders);

        ResponseEntity<List<Slider>> response = sliderController.getAllSliders();

        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(2, response.getBody().size());
    }

    @Test
    void testGetSliderById_Found() {
        when(sliderService.getSliderById(1L)).thenReturn(slider1);
        ResponseEntity<Slider> response = sliderController.getSliderById(1L);

        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(slider1, response.getBody());
    }

    @Test
    void testGetSliderById_NotFound() {
        when(sliderService.getSliderById(3L)).thenReturn(null);
        ResponseEntity<Slider> response = sliderController.getSliderById(3L);

        assertEquals(404, response.getStatusCodeValue());
    }

    @Test
    void testCreateSlider() {
        when(sliderService.createSlider(any(Slider.class))).thenReturn(slider1);
        ResponseEntity<Slider> response = sliderController.createSlider(slider1);

        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(slider1, response.getBody());
    }

    @Test
    void testUpdateSlider_Found() {
        when(sliderService.updateSlider(eq(1L), any(Slider.class))).thenReturn(slider1);
        ResponseEntity<Slider> response = sliderController.updateSlider(1L, slider1);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(slider1, response.getBody());
    }

    @Test
    void testUpdateSlider_NotFound() {
        when(sliderService.updateSlider(eq(3L), any(Slider.class))).thenReturn(null);
        ResponseEntity<Slider> response = sliderController.updateSlider(3L, slider1);

        assertEquals(404, response.getStatusCodeValue());
    }

    @Test
    void testDeleteSlider_Found() {
        when(sliderService.deleteSlider(1L)).thenReturn(true);
        ResponseEntity<Void> response = sliderController.deleteSlider(1L);

        assertEquals(200, response.getStatusCodeValue());
    }

    @Test
    void testDeleteSlider_NotFound() {
        when(sliderService.deleteSlider(3L)).thenReturn(false);
        ResponseEntity<Void> response = sliderController.deleteSlider(3L);

        assertEquals(404, response.getStatusCodeValue());
    }
}