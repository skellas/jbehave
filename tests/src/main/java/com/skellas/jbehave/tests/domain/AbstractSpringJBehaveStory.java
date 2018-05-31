package com.skellas.jbehave.tests.domain;

import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.embedder.Embedder;
import org.jbehave.core.embedder.EmbedderControls;
import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.reporters.FilePrintStreamFactory.ResolveToPackagedName;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.io.UnderscoredCamelCaseResolver;
import org.jbehave.core.junit.JUnitStory;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.ParameterControls;
import org.jbehave.core.steps.spring.SpringStepsFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

import static org.jbehave.core.reporters.StoryReporterBuilder.Format.HTML;
import static org.jbehave.core.reporters.StoryReporterBuilder.Format.IDE_CONSOLE;
import static org.jbehave.core.reporters.StoryReporterBuilder.Format.TXT;

public abstract class AbstractSpringJBehaveStory extends JUnitStory {
    private static final int STORY_TIMEOUT = 120;
    private ApplicationContext applicationContext;

    public AbstractSpringJBehaveStory() {
        Embedder embedder = new Embedder();
        embedder.useEmbedderControls(embedderControls());
        embedder.useMetaFilters(Arrays.asList("-skip"));
        useEmbedder(embedder);
    }

    @Autowired
    public void setApplicationContext( ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }
    private EmbedderControls embedderControls() {
        return new EmbedderControls()
                .doIgnoreFailureInView(true)
                .useStoryTimeouts(String.valueOf(STORY_TIMEOUT));
    }
    @Override
    public InjectableStepsFactory stepsFactory() {
        return new SpringStepsFactory(configuration(), this.applicationContext);
    }
    @Override
    public Configuration configuration() {
        return new MostUsefulConfiguration()
                .useStoryPathResolver(new UnderscoredCamelCaseResolver())
                .useStoryLoader(new LoadFromClasspath())
                .useStoryReporterBuilder(storyReporterBuilder())
                .useParameterControls(new ParameterControls().useDelimiterNamedParameters(true));
    }
    private StoryReporterBuilder storyReporterBuilder() {
        return new StoryReporterBuilder()
                .withCodeLocation(CodeLocations.codeLocationFromClass(this.getClass()))
                .withPathResolver(new ResolveToPackagedName())
                .withFailureTrace(true)
                .withDefaultFormats()
                .withFormats(IDE_CONSOLE, TXT, HTML);
    }
}
