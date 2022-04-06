package com.br.itau.cat.api.application.unity;

import com.br.itau.cat.api.application.configuration.MapperTestConfiguration;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith({SpringExtension.class})
@ContextConfiguration(classes = MapperTestConfiguration.class)
public abstract class MapperUnityTest {
}
