package com.slowio.beaninfo;

import com.slowio.beaninfo.generator.PropertiesBuilder;
import com.slowio.beaninfo.generator.PropertiesBuilderConfig;
import org.jboss.forge.roaster.Roaster;
import org.jboss.forge.roaster.model.source.JavaEnumSource;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static com.slowio.beaninfo.generator.Constants.PROPERTIES_CLASS_EXTENTION;
import static org.assertj.core.api.Assertions.assertThat;

/**
 *
 */
public class PropertiesBuilderTest {

    @Test
    public void testTestBeanBuilder() {
        PropertiesBuilderConfig config = new PropertiesBuilderConfig();
        config.setCopyrightHeader("/** This is the copyright */");
        PropertiesBuilder propertyInspector = new PropertiesBuilder(TestBean.class, config);
        String classCode = propertyInspector.buildClassCode();
        assertThat(classCode).isNotBlank();
        System.out.println(classCode);

        JavaEnumSource javaClass = Roaster.parse(JavaEnumSource.class, classCode);
        assertThat(javaClass).isNotNull();
        assertThat(javaClass.getName()).isNotBlank();
        assertThat(javaClass.getName()).isEqualTo("TestBean" + PROPERTIES_CLASS_EXTENTION);
    }

    @Test
    public void printEnv() {
        Map<String, String> env = System.getenv();
        for (String key : env.keySet()) {
            System.out.println(String.format("%s=%s", key, env.get(key)));
        }
    }
}
