package io.citrine.pluginplussign.analysis;
import  org.apache.lucene.analysis.Analyzer;
import  org.apache.lucene.analysis.TokenStream;
import  org.apache.lucene.analysis.Tokenizer;
import  org.apache.lucene.analysis.core.LowerCaseFilter;

import java.io.IOException;
import  java.io.Reader;

/* Now that we have built our custom tokenizer and custom token filter, creating a new analyzer is
 * simple. In this class, we are going to use the PlusSignTokenizer tokenizer that we built, then
 * filter those tokens with our EmptyStringTokenFilter, and finally convert all strings to
 * lowercase using org.apache.lucene.analysis.core.LowerCaseFilter filter that comes with Lucene.
 * Overall, this has the effect that the input string “This+is++some+text” will be converted to the
 * tokens “this”, “is”, “some”, and “text”. Our analyzer must extend
 * org.apache.lucene.analysis.Analyzer.
 */
public class PlusSignAnalyzer extends Analyzer {

    /* This is the only function that we need to override for our analyzer. It takes in a
     * java.io.Reader object and saves the tokenizer and list of token filters that operate
     * on it.
     */
    @Override
    protected TokenStreamComponents createComponents(String field, Reader reader) {
        Tokenizer tokenizer = new PlusSignTokenizer(reader);
        TokenStream filter = new EmptyStringTokenFilter(tokenizer);
        filter = new LowerCaseFilter(filter);
        return new TokenStreamComponents(tokenizer, filter);
    }
}