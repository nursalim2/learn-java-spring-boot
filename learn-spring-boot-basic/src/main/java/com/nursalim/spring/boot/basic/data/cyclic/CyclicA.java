package com.nursalim.spring.boot.basic.data.cyclic;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CyclicA {
    private CyclicB cyclicB;

}
