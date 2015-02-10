package io.citrine.pluginplussign.plugin;
import  io.citrine.pluginplussign.analysis.PlusSignAnalyzer;
import  org.elasticsearch.common.inject.Inject;
import  org.elasticsearch.common.inject.assistedinject.Assisted;
import  org.elasticsearch.common.settings.Settings;
import  org.elasticsearch.env.Environment;
import  org.elasticsearch.index.Index;
import  org.elasticsearch.index.analysis.AbstractIndexAnalyzerProvider;
import  org.elasticsearch.index.settings.IndexSettings;
import  java.io.IOException;

/* Provider to generate an instance of a PlusSignAnalyzer object. It extends the Elasticsearch class
 * org.elasticsearch.index.analysis.AbstractIndexAnalyzerProvider.
 */
public class PlusSignAnalyzerProvider extends AbstractIndexAnalyzerProvider<PlusSignAnalyzer> {

    /* Constructor. Nothing special here. */
    @Inject
    public PlusSignAnalyzerProvider(Index index, @IndexSettings Settings indexSettings,
    Environment env, @Assisted String name, @Assisted Settings settings) throws IOException {
        super(index, indexSettings, name, settings);
    }

    /* This function needs to be overridden to return an instance of PlusSignAnalyzer. */
    @Override
    public PlusSignAnalyzer get() {
        return new PlusSignAnalyzer();
    }

    /* Name to associate with this class. We will use this in PlusSignBinderProcessor. */
    public static final String NAME = "plus_sign";
}