package com.skellas.jbehave.tests.configurations;

import org.jbehave.core.annotations.Configure;
import org.jbehave.core.annotations.UsingEmbedder;
import org.jbehave.core.junit.spring.SpringAnnotatedEmbedderRunner;
import org.jbehave.core.steps.ParameterConverters;
import org.junit.runner.RunWith;

@RunWith(SpringAnnotatedEmbedderRunner.class)
@Configure(parameterConverters = ParameterConverters.EnumConverter.class)
@UsingEmbedder()
public class ServerCreationStories {
}
