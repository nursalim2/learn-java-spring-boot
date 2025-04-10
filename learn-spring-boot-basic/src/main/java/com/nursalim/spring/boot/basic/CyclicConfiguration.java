package com.nursalim.spring.boot.basic;

import com.nursalim.spring.boot.basic.data.cyclic.CyclicA;
import com.nursalim.spring.boot.basic.data.cyclic.CyclicB;
import com.nursalim.spring.boot.basic.data.cyclic.CyclicC;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CyclicConfiguration {
    @Bean
    public CyclicA cyclicA(CyclicB cyclicB) {
        return new CyclicA(cyclicB);
    }

    @Bean
    public CyclicB cyclicB(CyclicC cyclicC) {
        return new CyclicB(cyclicC);
    }

    @Bean
    public CyclicC cyclicC(CyclicA cyclicA) {
        return new CyclicC(cyclicA);
    }
}
