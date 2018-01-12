package com.slowio.beaninfo.generator;

import com.google.common.base.CaseFormat;
import com.google.googlejavaformat.java.Formatter;
import com.google.googlejavaformat.java.FormatterException;
import com.slowio.beaninfo.generator.exception.InvalidSourceException;
import org.jboss.forge.roaster.Roaster;
import org.jboss.forge.roaster.model.source.EnumConstantSource;
import org.jboss.forge.roaster.model.source.JavaEnumSource;
import org.jboss.forge.roaster.model.source.MethodSource;

import java.util.Set;

/** */
public class PropertiesBuilder {

  private final Class<?> modelClass;
  private final Set<String> properties;
  private final PropertiesBuilderConfig builderConfig;

  public PropertiesBuilder(Class<?> modelClass, PropertiesBuilderConfig builderConfig) {
    this(modelClass, new PropertiesInspector(modelClass).getProperties(), builderConfig);
  }

  public PropertiesBuilder(
      Class<?> modelClass, Set<String> properties, PropertiesBuilderConfig builderConfig) {
    this.modelClass = modelClass;
    this.properties = properties;
    this.builderConfig = builderConfig;
  }

  public String buildClassCode() {
    String className = modelClass.getSimpleName() + builderConfig.getPropertiesClassNameExtension();
    final JavaEnumSource javaClass = Roaster.create(JavaEnumSource.class);
    javaClass.setPackage(modelClass.getPackage().getName()).setName(className);
    javaClass.addProperty(String.class, "propertyName").setMutable(false);
    javaClass.addImport(String.class);
    MethodSource methodSource = javaClass.addMethod();
    methodSource = methodSource.setBody("this.propertyName = propertyName;");
    methodSource = methodSource.setConstructor(true);

    for (String prop : properties) {
      CaseFormat format = CaseFormat.valueOf(builderConfig.getPropertyCaseFormat().name());
      CaseFormat fromFormat = CaseFormat.valueOf(builderConfig.getFromPropertyCaseFormat().name());
      String name = fromFormat.to(format, prop);
      EnumConstantSource enumConstantSource = javaClass.addEnumConstant(name);
      enumConstantSource.setConstructorArguments(String.format("\"%s\"", prop));
    }

    try {
      String rawSource = builderConfig.getCopyrightHeader();
      if(rawSource == null) {
          rawSource = "";
      }
      rawSource += javaClass.toUnformattedString();
      return new Formatter().formatSource(rawSource);
    } catch (FormatterException e) {
      throw new InvalidSourceException(e.getMessage(), e);
    }
  }
}
