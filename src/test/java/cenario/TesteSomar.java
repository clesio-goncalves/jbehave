package cenario;

import java.util.Locale;

import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.Keywords;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.i18n.LocalizedKeywords;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.junit.JUnitStory;
import org.jbehave.core.parsers.RegexStoryParser;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;

import steps.SomarSteps;

public class TesteSomar extends JUnitStory {

	@Override
	public Configuration configuration() {

		// as palavras-chave e o parser das estórias através dos métodos
		// useKeywords() e useStoryParser()

		Keywords keywords = new LocalizedKeywords(new Locale("pt"));

		return new MostUsefulConfiguration().useKeywords(keywords)
				.useStoryParser(new RegexStoryParser(keywords))
				// Onde procurar pelas estórias
				.useStoryLoader(new LoadFromClasspath(this.getClass()))
				// Para onde fazer os reports
				.useStoryReporterBuilder(
						new StoryReporterBuilder().withDefaultFormats()
								.withFormats(Format.CONSOLE, Format.HTML));
	}

	@Override
	public InjectableStepsFactory stepsFactory() {
		// Pode ter mais de um Step
		return new InstanceStepsFactory(configuration(), new SomarSteps());
	}
}
