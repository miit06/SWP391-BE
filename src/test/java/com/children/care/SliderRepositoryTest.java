package com.children.care;

import com.children.care.entity.Slider;
import com.children.care.repository.SliderRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) // Sử dụng database thực tế
class SliderRepositoryTest {

    @Autowired
    private SliderRepository sliderRepository;

    @Test
    void testSaveSlider() {
        // Given
        Slider slider = new Slider();
        slider.setTitle("Slider 1");
        slider.setImage("slider1.jpg");
        slider.setBacklink("https://example.com");
        slider.setStatus(1);
        slider.setNotes("First slider");
        slider.setCategoryId(2);
        slider.setPostId(5);

        // When
        Slider savedSlider = sliderRepository.save(slider);

        // Then
        assertThat(savedSlider).isNotNull();
        assertThat(savedSlider.getSliderId()).isNotNull();
        assertThat(savedSlider.getTitle()).isEqualTo("Slider 1");
    }

    @Test
    void testFindById() {
        // Given
        Slider slider = new Slider();
        slider.setTitle("Find Me");
        slider.setImage("findme.jpg");
        slider.setBacklink("https://findme.com");
        slider.setStatus(1);
        slider.setNotes("Find this slider");
        slider.setCategoryId(3);
        slider.setPostId(6);
        Slider savedSlider = sliderRepository.save(slider);

        // When
        Optional<Slider> foundSlider = sliderRepository.findById(savedSlider.getSliderId());

        // Then
        assertThat(foundSlider).isPresent();
        assertThat(foundSlider.get().getTitle()).isEqualTo("Find Me");
    }

    @Test
    void testDeleteSlider() {
        // Given
        Slider slider = new Slider();
        slider.setTitle("Delete Me");
        slider.setImage("delete.jpg");
        slider.setBacklink("https://delete.com");
        slider.setStatus(0);
        slider.setNotes("To be deleted");
        slider.setCategoryId(4);
        slider.setPostId(7);
        Slider savedSlider = sliderRepository.save(slider);
        Long sliderId = savedSlider.getSliderId();

        // When
        sliderRepository.deleteById(sliderId);
        Optional<Slider> deletedSlider = sliderRepository.findById(sliderId);

        // Then
        assertThat(deletedSlider).isEmpty();
    }
}
