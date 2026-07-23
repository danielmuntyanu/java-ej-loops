package com.daniel.looper;

public class LooperMapper {
    public static Looper toEntity(LooperDTO dto) {
        int n = Integer.parseInt(dto.input());
        return new Looper(n);
    }
}
