package com.slowio.beaninfo;

import com.slowio.beaninfo.generator.PropertiesInspector;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 *
 */
class PropertyInspectorTest {

    @Test
    void testGetProperties() {
        PropertiesInspector testBeanInspector = new PropertiesInspector(TestBean.class);
        Set<String> testProperties = testBeanInspector.getProperties();
        assertThat(testProperties).size().isEqualTo(7);
    }

    @Test
    void testIndexedPropertyBean() {
        PropertiesInspector testBeanInspector = new PropertiesInspector(IndexedPropertyBean.class);
        Set<String> testProperties = testBeanInspector.getProperties();
        assertThat(testProperties).size().isEqualTo(2);
    }

    @Test
    void testEmptyBean() {
        PropertiesInspector testBeanInspector = new PropertiesInspector(EmptyBean.class);
        Set<String> testProperties = testBeanInspector.getProperties();
        assertThat(testProperties).size().isEqualTo(0);
    }
}
