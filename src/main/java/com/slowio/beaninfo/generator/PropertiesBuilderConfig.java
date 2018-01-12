package com.slowio.beaninfo.generator;

/**
 *
 *
 *
 */
public class PropertiesBuilderConfig {

    private PropertyCaseFormat fromPropertyCaseFormat = PropertyCaseFormat.LOWER_CAMEL;

    private PropertyCaseFormat propertyCaseFormat = PropertyCaseFormat.UPPER_UNDERSCORE;

    private String outputSourceDirectory;

    private String outputClassDirectory;

    private String propertiesClassNameExtension = "Properties";

    private String copyrightHeader = "";


    public PropertyCaseFormat getPropertyCaseFormat() {
        return propertyCaseFormat;
    }

    public void setPropertyCaseFormat(PropertyCaseFormat propertyCaseFormat) {
        if (propertyCaseFormat == null) {
            propertyCaseFormat = PropertyCaseFormat.UPPER_UNDERSCORE;
        }
        this.propertyCaseFormat = propertyCaseFormat;
    }

    public PropertyCaseFormat getFromPropertyCaseFormat() {
        return fromPropertyCaseFormat;
    }

    public void setFromPropertyCaseFormat(PropertyCaseFormat fromPropertyCaseFormat) {
        if (fromPropertyCaseFormat == null) {
            fromPropertyCaseFormat = PropertyCaseFormat.LOWER_CAMEL;
        }
        this.fromPropertyCaseFormat = fromPropertyCaseFormat;
    }

    /**
     * @return The name of the directory to output source files
     */
    public String getOutputSourceDirectory() {
        return outputSourceDirectory;
    }

    public void setOutputSourceDirectory(String outputSourceDirectory) {
        this.outputSourceDirectory = outputSourceDirectory;
    }

    public String getOutputClassDirectory() {
        return outputClassDirectory;
    }

    public void setOutputClassDirectory(String outputClassDirectory) {
        this.outputClassDirectory = outputClassDirectory;
    }

    public String getCopyrightHeader() {
        return copyrightHeader;
    }

    public void setCopyrightHeader(String copyrightHeader) {
        this.copyrightHeader = copyrightHeader;
    }

    /**
     * This represents the additional text that is appended to name the properties class.
     * If we have a class named {@code Person} and the propertiesClassNameExtension is "Properties"
     * the name of the generated class or enum will be PersonProperties
     * @return The extension used to name the properties class
     */
    public String getPropertiesClassNameExtension() {
        return propertiesClassNameExtension;
    }

    public void setPropertiesClassNameExtension(String propertiesClassNameExtension) {
        this.propertiesClassNameExtension = propertiesClassNameExtension;
    }
}
