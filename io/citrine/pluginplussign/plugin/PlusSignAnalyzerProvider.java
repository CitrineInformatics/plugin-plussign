package io.citrine.pluginplussign.plugin;
import  org.elasticsearch.common.inject.Inject;
import  org.elasticsearch.common.inject.assistedinject.Assisted;
import  org.elasticsearch.common.settings.Settings;
import  org.elasticsearch.env.Environment;
import  org.elasticsearch.index.Index;
import  org.elasticsearch.index.analysis.AbstractIndexAnalyzerProvider;
import org.elasticsearch.index.settings.IndexSettingsService;
import io.citrine.pluginplussign.analysis.PlusSignAnalyzer;

import  java.io.IOException;

public class PlusSignAnalyzerProvider extends AbstractIndexAnalyzerProvider<PlusSignAnalyzer> {

    /* Constructor. Nothing special here. */
    @Inject
    public PlusSignAnalyzerProvider(Index index, IndexSettingsService indexSettingsService,
                                    Environment env, @Assisted String name, @Assisted Settings settings) throws IOException {
        super(index, indexSettingsService.getSettings(), name, settings);
    }

    /* This function needs to be overridden to return an instance of PlusSignAnalyzer. */
    public PlusSignAnalyzer get() {
        return this.analyzer;
    }

    /* Instance of PlusSignAnalyzer class that is returned by this class. */
    protected PlusSignAnalyzer analyzer = new PlusSignAnalyzer();

    /* Name to associate with this class. We will use this in PlusSignBinderProcessor. */
    public static final String NAME = "plus_sign";
}
