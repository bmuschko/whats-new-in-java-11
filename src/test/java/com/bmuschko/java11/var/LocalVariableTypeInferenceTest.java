package com.bmuschko.java11.var;

import org.junit.jupiter.api.Test;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LocalVariableTypeInferenceTest {
    @Test
    void canUseVarForLambdaParameters() {
        List<String> months = List.of("January", "February", "March");
        List<String> filteredMonths = months
                .stream()
                .filter(Predicate.not((@NotNull var month) -> month.startsWith("M")))
                .collect(Collectors.toList());
        assertEquals(List.of("January", "February"), filteredMonths);
    }
}
