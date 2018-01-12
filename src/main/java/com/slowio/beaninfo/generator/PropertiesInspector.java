package com.slowio.beaninfo.generator;


import org.apache.commons.beanutils.PropertyUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.beans.FeatureDescriptor;
import java.beans.PropertyDescriptor;
import java.util.Arrays;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 *
 */
public class PropertiesInspector {

    /**
     * Log instance
     */
    private final Logger log = LoggerFactory.getLogger(getClass());

    final private Class<?> modelClass;

    public PropertiesInspector(Class<?> modelClass) {
        this.modelClass = modelClass;
    }

    public Class<?> getModelClass() {
        return modelClass;
    }

    public SortedSet<String> getProperties() {
        PropertyDescriptor[] values = PropertyUtils.getPropertyDescriptors(modelClass);
        log.debug("Found {} properties on class {}", values.length, modelClass.getSimpleName());
        return Arrays.stream(values)
                .map(FeatureDescriptor::getName)
                .filter(x -> !"class".equals(x))
                .collect(Collectors.toCollection(TreeSet::new));

    }
}
