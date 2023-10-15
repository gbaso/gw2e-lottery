package com.github.gbaso.gw2elottery.config;

import org.hibernate.generator.internal.CurrentTimestampGeneration;
import org.springframework.aot.hint.MemberCategory;
import org.springframework.aot.hint.RuntimeHints;
import org.springframework.aot.hint.RuntimeHintsRegistrar;

public class HibernateHints implements RuntimeHintsRegistrar {

    @Override
    public void registerHints(RuntimeHints hints, ClassLoader classLoader) {
        hints
                .reflection()
                .registerType(CurrentTimestampGeneration.class, MemberCategory.INVOKE_DECLARED_CONSTRUCTORS);
    }

}
