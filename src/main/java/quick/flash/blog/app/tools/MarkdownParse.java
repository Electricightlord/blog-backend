package quick.flash.blog.app.tools;

import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.profiles.pegdown.Extensions;
import com.vladsch.flexmark.profiles.pegdown.PegdownOptionsAdapter;
import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.data.DataHolder;
import com.vladsch.flexmark.util.data.MutableDataSet;

/**
 * @author lihao
 * @date 2019-09-14 00:44
 */
public class MarkdownParse {
    private MarkdownParse() {
    }

    public static String parse(String content) {
        DataHolder options = PegdownOptionsAdapter.flexmarkOptions(
                Extensions.GITHUB_COMMENT_COMPATIBLE
        );

        MutableDataSet formatOptions = new MutableDataSet();
        // copy extensions from Pegdown compatible to Formatting
        formatOptions.set(Parser.EXTENSIONS, options.get(Parser.EXTENSIONS));

        Parser parser = Parser.builder(options).build();
        HtmlRenderer renderer = HtmlRenderer.builder(formatOptions).build();

        // You can re-use parser and renderer instances
        Node document = parser.parse(content);
        return renderer.render(document);
    }
}
