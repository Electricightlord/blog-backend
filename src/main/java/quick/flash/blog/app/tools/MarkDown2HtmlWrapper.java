package quick.flash.blog.app.tools;

import java.util.Arrays;

import com.vladsch.flexmark.ext.tables.TablesExtension;
import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.parser.ParserEmulationProfile;
import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.data.MutableDataSet;
import quick.flash.blog.app.tools.entity.MarkDownEntity;

public class MarkDown2HtmlWrapper {

    private static String MD_CSS = null;

    static {
        try {
            MD_CSS = FileUtils.readAll("md/mark.css");
            MD_CSS = "<style type=\"text/css\">\n" + MD_CSS + "\n</style>\n";
        } catch (Exception e) {
            MD_CSS = "";
        }
    }

    /**
     * 直接将markdown语义的文本转为html格式输出
     *
     *
     * @param content markdown语义文本
     * @return
     */
    public static MarkDownEntity ofContent(String content) {
        String html = parse(content);
        MarkDownEntity entity = new MarkDownEntity();
        entity.setCss(MD_CSS);
        entity.setHtml(html);
        entity.addDivStyle("class", "markdown-body");
        return entity;
    }


    /**
     * markdown to image
     *
     * @param content markdown contents
     * @return parse html contents
     */
    public static String parse(String content) {
        MutableDataSet options = new MutableDataSet();
        options.setFrom(ParserEmulationProfile.MARKDOWN);

        // enable table parse!
        options.set(Parser.EXTENSIONS, Arrays.asList(TablesExtension.create()));


        Parser parser = Parser.builder(options).build();
        HtmlRenderer renderer = HtmlRenderer.builder(options).build();

        Node document = parser.parse(content);
        return renderer.render(document);
    }

}