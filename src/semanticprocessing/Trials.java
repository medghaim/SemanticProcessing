/*
 * This is a test page. Will be removed before submitting.
 */
package semanticprocessing;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.htmlcleaner.HtmlCleaner;
import org.htmlcleaner.TagNode;

/**
 *
 * @author hussamkaka
 */
public class Trials {

    public static ArrayList<URL> extractSubURLs(String content) throws IOException {
        HtmlCleaner cleaner = new HtmlCleaner();
        TagNode node;
        node = cleaner.clean(content);
        TagNode[] childNodes = node.getElementsByName("a", true);
        System.out.println(childNodes.length);
        ArrayList<TagNode> anchorTags = new ArrayList<TagNode>();
        for (TagNode tagNode : childNodes) {
            if (tagNode.hasAttribute("href")) {
                anchorTags.add(tagNode);
            }
        }
        for (TagNode tag : anchorTags) {
            System.out.println(tag.getAttributeByName("href"));
        }
        return null;
    }

    public static void main(String[] args) throws IOException, NotAnHtmlUrlException {
        
        String [] original = {"toot", "<html><html><body>This is some html"
        + "<p>and this is a paragraph</p><p><a href = fgdfg>and this"
        + " is a link</a><br /></p></body></html><html><body>lol"
        + "</body></html></html>"};
        for (String s : original) {
            //System.out.println(s);
            //System.out.println(cleaner(s));
            //System.out.println("--------------\n\n");
        }

        ArrayList<Integer> testList = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
        testList.add(i);
        }
        
        URL url = new URL("http://www.yahoo.com/haha/index.html#rrom");
        //System.out.println(url.toString().replaceAll("/[^/]*$", "/"));
         
        URL context = new URL("http://www.yahoo.com/day/index.html" + " ");
        //URL url = new URL(context, "../toot.html");
    //    System.out.println(context.toString());
      //  System.out.println(context.toString());
        //System.out.println(context.getPath());
        //System.out.println(context.getPath().equals(""));
        System.out.println("AUTORITY: "+context.getAuthority());
        System.out.println("FILE: "+context.getFile());
        System.out.println("URL: "+context.getPath());
        System.out.println(context);
         

        //System.out.println(FileOps.readOnlineFile(new
        //      URL("http://upload.wikimedia.org/wikipedia/en/thumb/7/71/"
        //    + "Hoxne_Hoard_24.jpg/100px-Hoxne_Hoard_24.jpg")));
//        URL url = new URL("http://www.cdf.toronto.edu/~csc207h/fall/assignments/a2#lol");
//
//        URLConnection urlc = url.openConnection();
//        urlc.getHeaderFields();
//        System.out.println("Content-Type: " + urlc.getContentType());
//        System.out.println(urlc.getContentType().toLowerCase().contains("html"));
//        System.out.println(urlc.getURL());

        // System.out.println(removeFragment(new URL("http://www.youtube.com/watch?v=g3fm_IQ5Hco&feature=grec_index#hi?fg")));
//        FacultyMember member = new FacultyMember(new URL("http://www.cs.toronto.edu/~pgries"));
//        File f = new File("D:\\file.cache");
//        saveCache(member, f);

       // System.out.println(FileOps.readOnlineFile(new URL("http://www.facebook.com")));
    }

    public static String cleaner(String s) throws IOException {
        HtmlCleaner cleaner = new HtmlCleaner();
        TagNode[] toot = cleaner.clean(s).getAllElements(true);
        String str = "";
        for (TagNode element : toot) {
            str += " " + element.getName();
        }
        return str;
    }

    private static URL removeFragment(final URL url) {
        String urlString = url.toString();
        urlString = removeFragment(urlString);
        URL result = null;
        try {
            result = new URL(urlString);
        } catch (MalformedURLException ex) {
            // Never occurs since we are starting with a String from a URL.
        }
        return result;
    }

    private static String removeFragment(final String link) {
        Pattern fragmentPattern = Pattern.compile("(#\\w*$)");
        Matcher matcher = fragmentPattern.matcher(link);

        String result = link;

        if (matcher.find()) {
            result = link.substring(0, matcher.start());
        }

        return result;
    }

    public static void saveCache(FacultyMember member, File file) throws IOException {
        file.createNewFile();
        FileOutputStream bytetOut = new FileOutputStream(file);
        ObjectOutputStream outer = new ObjectOutputStream(bytetOut);
        outer.writeObject(member);
        outer.flush();
        outer.close();
    }

    public FacultyMember loadCache(File f) throws FileNotFoundException, IOException, ClassNotFoundException {
        FileInputStream byteOut = new FileInputStream(f);
        ObjectInputStream out = new ObjectInputStream(byteOut);
        FacultyMember cache = (FacultyMember) out.readObject();
        out.close();
        byteOut.close();
        return cache;
    }
}
