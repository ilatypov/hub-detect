/*
 * Copyright (C) 2017 Black Duck Software Inc.
 * http://www.blackducksoftware.com/
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Black Duck Software ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Black Duck Software.
 */
package com.blackducksoftware.integration.hub.detect.help

import javax.annotation.PostConstruct

import org.apache.commons.lang3.StringUtils
import org.apache.commons.lang3.math.NumberUtils
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.aop.support.AopUtils
import org.springframework.beans.BeansException
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.ApplicationContext
import org.springframework.context.ApplicationContextAware
import org.springframework.stereotype.Component

@Component
public class ValueDescriptionAnnotationFinder implements ApplicationContextAware {
    private final Logger logger = LoggerFactory.getLogger(ValueDescriptionAnnotationFinder.class)

    private ApplicationContext applicationContext

    List<DetectOption> detectOptions

    @PostConstruct
    void init() {
        gatherDetectValues()
    }

    @Override
    public void setApplicationContext(final ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext
    }

    public void gatherDetectValues() {
        Map<String, DetectOption> detectOptionsMap = [:]
        applicationContext.beanDefinitionNames.each { beanName ->
            final Object obj = applicationContext.getBean(beanName)
            Class<?> objClz = obj.getClass()
            if (AopUtils.isAopProxy(obj)) {
                objClz = AopUtils.getTargetClass(obj)
            }
            objClz.declaredFields.each { field ->
                if (field.isAnnotationPresent(ValueDescription.class)) {
                    String key = ''
                    String description = ''
                    Class valueType = field.getType()
                    String defaultValue = ''
                    final ValueDescription valueDescription = field.getAnnotation(ValueDescription.class)
                    description = valueDescription.description()
                    defaultValue = valueDescription.defaultValue()
                    if (!valueDescription.key()?.trim()) {
                        if (field.isAnnotationPresent(Value.class)) {
                            String valueKey = field.getAnnotation(Value.class).value().trim()
                            key = valueKey[2..-2]
                        }
                    } else{
                        key = valueDescription.key().trim()
                    }
                    field.setAccessible(true);
                    Object fieldValue = field.get(obj)
                    if (defaultValue?.trim()) {
                        try {
                            Class type = field.getType()
                            if (String.class.equals(type) && StringUtils.isBlank(fieldValue)) {
                                field.set(obj, defaultValue);
                            } else if (Integer.class.equals(type) && fieldValue == null) {
                                field.set(obj, NumberUtils.toInt(defaultValue));
                            } else if (Boolean.class.equals(type) && fieldValue == null) {
                                field.set(obj, Boolean.parseBoolean(defaultValue));
                            }
                        } catch (final IllegalAccessException e) {
                            logger.error(String.format("Could not set defaultValue on field %s with %s: %s", field.getName(), defaultValue, e.getMessage()));
                        }
                    }
                    if (!detectOptionsMap.containsKey(key)) {
                        detectOptionsMap.put(key, new DetectOption(key, description, valueType, defaultValue))
                    }
                }
            }
        }
        detectOptions = detectOptionsMap.values().toSorted { a, b ->
            a.key <=> b.key
        }
    }

    public List<DetectOption> getDetectValues() {
        detectOptions
    }
}