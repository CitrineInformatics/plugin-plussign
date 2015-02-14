package io.citrine.pluginplussign.plugin;
import  org.elasticsearch.index.analysis.AnalysisModule;

public class PlusSignBinderProcessor extends AnalysisModule.AnalysisBinderProcessor {

    /* This is the only function that you need. It simply adds our PlusSignAnalyzerProvider class
     * to a list of bindings.
     */
    @Override
    public void processAnalyzers(AnalyzersBindings analyzersBindings) {
        analyzersBindings.processAnalyzer(PlusSignAnalyzerProvider.NAME,
            PlusSignAnalyzerProvider.class);
    }
}