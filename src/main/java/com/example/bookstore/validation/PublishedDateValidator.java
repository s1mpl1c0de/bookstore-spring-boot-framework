package com.example.bookstore.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.ObjectUtils;

import java.time.LocalDate;
import java.time.chrono.ThaiBuddhistDate;
import java.time.temporal.ChronoField;

@Slf4j
public class PublishedDateValidator implements ConstraintValidator<ValidPublishedDate, LocalDate> {

    @Override
    public boolean isValid(LocalDate publishedDate, ConstraintValidatorContext context) {
        if (ObjectUtils.isEmpty(publishedDate)) {
            return false;
        }

        try {
            ThaiBuddhistDate currentThaiDate = ThaiBuddhistDate.now();
            int currentThaiYear = currentThaiDate.get(ChronoField.YEAR);
            return publishedDate.getYear() > 1000 && publishedDate.getYear() <= currentThaiYear;
        } catch (Exception e) {
            log.error("An error occurred while validate published date: {}", e.getMessage());
            return false;
        }
    }
}
