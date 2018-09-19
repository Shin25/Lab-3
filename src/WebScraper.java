import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class WebScraper {
    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }

    /**
     * @param unused String array
     */
    public static void main(String[] unused) {
//    System.out.println(WordCount(urlToString("http://erdani.com/tdpl/hamlet.txt")));
//    System.out.println(WordCount(urlToString("http://tgftp.nws.noaa.gov/data/raw/fz/fzus53.klot.srf.lot.txt")));
//    System.out.println(WordCount(urlToString("https://www.bls.gov/tus/charts/chart9.txt")));
      System.out.println(OneWordCount(urlToString("http://erdani.com/tdpl/hamlet.txt")));
      System.out.println(UniqueWords(urlToString("http://erdani.com/tdpl/hamlet.txt")));
    }
    /**
     * @param s String from the url
     * @return wordcount
     */
    public static int WordCount(String s) {
        return s.split("\\s+").length;
    }
    public static int OneWordCount(String s) {
        int count = 0;
        for (int i = 0; i < s.length() - 6; i++) {
            if (s.substring(i, i + 6).toLowerCase().equals("prince")) {
                count++;
            }
        }
        return count;
    }
    public static int UniqueWords(String s) {
        int Unique = 0;
        String[] wrds = new String[s.length()];
        String[] temp = new String[s.length()];
        for (int i = 0; i < wrds.length; i++) {
            for (int j = 0; j < wrds.length; j++) {
                if (temp[i].equals(wrds[j]) && !temp[j].equals(wrds[i])) {
                    Unique++;
                }
            }
        }
        return Unique;
    }
}
