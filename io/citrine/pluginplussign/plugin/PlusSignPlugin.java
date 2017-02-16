package io.citrine.pluginplussign.plugin;
import  org.elasticsearch.index.analysis.AnalysisModule;
import  org.elasticsearch.plugins.Plugin;

public class PlusSignPlugin extends Plugin {

    /* Set the name that will be assigned to this plugin. */
    @Override
    public String name() {
        return "plugin-plussign";
    }

    /* Return a description of this plugin. */
    @Override
    public String description() {
        return "Analyzer to split a string at + symbols, remove tokens containing " +
            "empty strings, and convert all strings to lowercase";
    }

    /* This is the function that will register our analyzer with Elasticsearch. */
    public void onModule(AnalysisModule analysisModule) {
        analysisModule.addProcessor(new PlusSignBinderProcessor());
    }
}
