package com.gravity.goose

import org.junit.Test
import org.junit.Assert._
import utils.FileHelper
import java.time.{LocalDateTime, ZoneId, ZonedDateTime}
import com.netaporter.uri.Uri

/**
 * Created by Jim Plush
 * User: jim
 * Date: 8/19/11
 */

class ExtractionsTest {

  def getHtml(filename: String): String = {
    FileHelper.loadResourceFile(TestUtils.staticHtmlDir + filename, Goose.getClass)
  }

  @Test
  def fortune1(): Unit ={
    implicit val config = TestUtils.NO_IMAGE_CONFIG
    val html = getHtml("fortune1.txt")
    val url = "http://fortune.com/2016/04/14/gamestop-ceo-ransformation-games/"
    val article = TestUtils.getArticle(url = Uri.parse(url), rawHTML = html)
    val title = "GameStop CEO Paul Raines Talks Gaming Retail Transformation"
    val content = "GameStop gme has built a $1 billion digital business, and its"
    TestUtils.runArticleAssertions(article = article, expectedTitle = title, expectedStart = content)
    assert(article.publishDate.isDefined)
  }

  @Test
  def bloomberg1(): Unit ={
    implicit val config = TestUtils.NO_IMAGE_CONFIG
    val html = getHtml("bloomberg1.txt")
    val url = "http://www.bloomberg.com/news/articles/2016-05-10/bearish-grantham-admits-major-error-being-bullish-on-metals"
    val article = TestUtils.getArticle(url = Uri.parse(url), rawHTML = html)
    val title = "Bearish Grantham Admits `Major Error' Being Bullish on Metals"
    val content = "Jeremy Grantham, best known for spotting bubbles in equity markets, said he missed the one in metals."
    TestUtils.runArticleAssertions(article = article, expectedTitle = title, expectedStart = content)
    assert(article.publishDate.isDefined)
  }

  @Test
  def cnn1() {
    implicit val config = TestUtils.NO_IMAGE_CONFIG
    val html = getHtml("cnn1.txt")
    val url = "http://www.cnn.com/2010/POLITICS/08/13/democrats.social.security/index.html"
    val article = TestUtils.getArticle(url = Uri.parse(url), rawHTML = html)
    val title = "Democrats to use Social Security against GOP this fall"
    val content = "Washington (CNN) -- Democrats pledged "
    TestUtils.runArticleAssertions(article = article, expectedTitle = title, expectedStart = content)
  }

  @Test
  def businessWeek2() {
    implicit val config = TestUtils.NO_IMAGE_CONFIG
    val html = getHtml("businessweek2.txt")
    val url: String = "http://www.businessweek.com/technology/here-comes-apples-real-tv-09132011.html"
    val article = TestUtils.getArticle(Uri.parse(url), html)
    TestUtils.runArticleAssertions(article,
      expectedStart = "At Home Depot, we first realized we needed to have a real conversation with")
    TestUtils.printReport()
  }

  @Test
  def businessWeek3() {
    implicit val config = TestUtils.NO_IMAGE_CONFIG
    val html = getHtml("businessweek3.txt")
    val url: String = "http://www.businessweek.com/management/five-social-media-lessons-for-business-09202011.html"
    val article = TestUtils.getArticle(Uri.parse(url), html)
    TestUtils.runArticleAssertions(article = article,
      expectedStart = "Get ready, America, because by Christmas 2012 you will have an Apple TV in your living room")
    TestUtils.printReport()
  }

  @Test
  def techcrunch1() {
    implicit val config = TestUtils.NO_IMAGE_CONFIG
    val html = getHtml("techcrunch1.txt")
    val url = "http://techcrunch.com/2011/08/13/2005-zuckerberg-didnt-want-to-take-over-the-world/"
    val content = "The Huffington Post has come across this fascinating five-minute interview"
    val title = "2005 Zuckerberg Didn’t Want To Take Over The World"
    val article = TestUtils.getArticle(url = Uri.parse(url), rawHTML = html)
    TestUtils.runArticleAssertions(article = article, expectedTitle = title, expectedStart = content)
  }

  @Test
  def businessweek1() {
    implicit val config = TestUtils.NO_IMAGE_CONFIG
    val html = getHtml("businessweek1.txt")
    val url: String = "http://www.businessweek.com/magazine/content/10_34/b4192066630779.htm"
    val title = "Olivia Munn: Queen of the Uncool"
    val content = "Six years ago, Olivia Munn arrived in Hollywood with fading ambitions of making it as a sports reporter and set about deploying"
    val article = TestUtils.getArticle(url = Uri.parse(url), rawHTML = html)
    TestUtils.runArticleAssertions(article = article, expectedTitle = title, expectedStart = content)
  }

  @Test
  def foxNews() {
    implicit val config = TestUtils.NO_IMAGE_CONFIG
    val html = getHtml("foxnews1.txt")
    val url: String = "http://www.foxnews.com/politics/2010/08/14/russias-nuclear-help-iran-stirs-questions-improved-relations/"
    val content = "Russia's announcement that it will help Iran get nuclear fuel is raising questions"
    val article = TestUtils.getArticle(url = Uri.parse(url), rawHTML = html)
    TestUtils.runArticleAssertions(article = article, expectedStart = content)
  }

  @Test
  def aolNews() {
    implicit val config = TestUtils.NO_IMAGE_CONFIG
    val html = getHtml("aol1.txt")
    val url: String = "http://www.aolnews.com/nation/article/the-few-the-proud-the-marines-getting-a-makeover/19592478"
    val article = TestUtils.getArticle(url = Uri.parse(url), rawHTML = html)
    val content = "WASHINGTON (Aug. 13) -- Declaring \"the maritime soul of the Marine Corps\" is"
    TestUtils.runArticleAssertions(article = article, expectedStart = content)
  }

  @Test
  def huffingtonPost2() {
    implicit val config = TestUtils.NO_IMAGE_CONFIG
    val html = getHtml("huffpo2.txt")
    val url: String = "http://www.huffingtonpost.com/2011/10/06/alabama-workers-immigration-law_n_997793.html"
    val article = TestUtils.getArticle(url = Uri.parse(url), rawHTML = html)
    val content = "MONTGOMERY, Ala. -- Alabama's strict new immigration law may be backfiring."
    TestUtils.runArticleAssertions(article = article, expectedStart = content)
  }


  @Test
  def testHuffingtonPost() {
    implicit val config = TestUtils.NO_IMAGE_CONFIG
    val url: String = "http://www.huffingtonpost.com/2010/08/13/federal-reserve-pursuing_n_681540.html"
    val html = getHtml("huffpo1.txt")

    val title: String = "Federal Reserve's Low Rate Policy Is A 'Dangerous Gamble,' Says Top Central Bank Official"
    val content = "A top regional Federal Reserve official sharply criticized Friday"
    val keywords = "federal, reserve's, low, rate, policy, is, a, 'dangerous, gamble,', says, top, central, bank, official, business"
    val description = "A top regional Federal Reserve official sharply criticized Friday the Fed's ongoing policy of keeping interest rates near zero -- and at record lows -- as a \"dangerous gamble.\""
    val article = TestUtils.getArticle(url = Uri.parse(url), rawHTML = html)
    TestUtils.runArticleAssertions(article = article, expectedTitle = title, expectedStart = content, expectedDescription = description)

    val expectedTags = "Federal Open Market Committee" ::
        "Federal Reserve" ::
        "Federal Reserve Bank Of Kansas City" ::
        "Financial Crisis" ::
        "Financial Reform" ::
        "Financial Regulation" ::
        "Financial Regulatory Reform" ::
        "Fomc" ::
        "Great Recession" ::
        "Interest Rates" ::
        "Kansas City Fed" ::
        "Monetary Policy" ::
        "The Financial Fix" ::
        "Thomas Hoenig" ::
        "Too Big To Fail" ::
        "Wall Street Reform" ::
        "Business News" ::
        Nil
    assertNotNull("Tags should not be NULL!", article.tags)
    assertTrue("Tags should not be empty!", article.tags.size > 0)

    for (actualTag <- article.tags) {
      assertTrue("Each Tag should be contained in the expected set!", expectedTags.contains(actualTag))
    }
  }


  @Test
  def wallStreetJournal() {
    implicit val config = TestUtils.NO_IMAGE_CONFIG
    val html = getHtml("wsj1.txt")
    val url: String = "http://online.wsj.com/article/SB10001424052748704532204575397061414483040.html"
    val article = TestUtils.getArticle(url = Uri.parse(url), rawHTML = html)
    val content = "The Obama administration has paid out less than a third of the nearly $230 billion"
    TestUtils.runArticleAssertions(article = article, expectedStart = content)
  }

  @Test
  def wsj2(): Unit ={
    implicit val config = TestUtils.NO_IMAGE_CONFIG
    val html = getHtml("wsj2.txt")
    val url: String = "https://www.wsj.com/articles/uniteds-strategy-to-reduce-overbookings-1502676300"
    val article = TestUtils.getArticle(url = Uri.parse(url), rawHTML = html)
    val content = "United Continental Holdings Inc. UAL 1.28% has been in the news a lot"
    TestUtils.runArticleAssertions(article = article, expectedStart = content, expectedAuthor = "Steven Norton")
    assert(article.publishDate.isDefined)
  }

  @Test
  def usaToday() {
    implicit val config = TestUtils.NO_IMAGE_CONFIG
    val html = getHtml("usatoday1.txt")
    val url: String = "http://content.usatoday.com/communities/thehuddle/post/2010/08/brett-favre-practices-set-to-speak-about-return-to-minnesota-vikings/1"
    val article = TestUtils.getArticle(Uri.parse(url), rawHTML = html)
    val content = "Brett Favre says he couldn't give up on one more"
    TestUtils.runArticleAssertions(article = article, expectedStart = content)
  }

  @Test
  def wiredPubDate() {
    val url = "http://www.wired.com/playbook/2010/08/stress-hormones-boxing/";
    val html = getHtml("wired1.txt")

    // example of a custom PublishDateExtractor
    implicit val config = new Configuration();
    config.enableImageFetching = false
    /*config.setPublishDateExtractor(new PublishDateExtractor() {
      @Override
      def extract(rootElement: Element): Option[ZonedDateTime] = {
        // look for this guy: <meta name="DisplayDate" content="2010-08-18" />
        val elements = Selector.select("meta[name=DisplayDate]", rootElement);
        if (elements.size() == 0) return null;
        val metaDisplayDate = elements.get(0);
        if (metaDisplayDate.hasAttr("content")) {
          val dateStr = metaDisplayDate.attr("content");

          return Some(new ZonedDateTime(fmt.parse(dateStr)))
        }
        null;
      }
    });*/

    val article = TestUtils.getArticle(Uri.parse(url), rawHTML = html)

    TestUtils.runArticleAssertions(
      article,
      "Stress Hormones Could Predict Boxing Dominance",
      "On November 25, 1980, professional boxing");

    val expectedDateString = "2010-08-18";
    //assertEquals("Publish date should equal: \"2010-08-18\"", expectedDateString, fmt.format(article.publishDate));
    //System.out.println("Publish Date Extracted: " + fmt.format(article.publishDate));

  }

  @Test
  def espn() {
    implicit val config = TestUtils.NO_IMAGE_CONFIG
    val html = getHtml("espn1.txt")
    val url: String = "http://sports.espn.go.com/espn/commentary/news/story?id=5461430"
    val article = TestUtils.getArticle(Uri.parse(url), html)
    TestUtils.runArticleAssertions(article = article,
      expectedStart = "If you believe what college football coaches have said about sports")
  }


  @Test
  def engadget() {
    implicit val config = TestUtils.NO_IMAGE_CONFIG
    val html = getHtml("engadget1.txt")
    val url: String = "http://www.engadget.com/2010/08/18/verizon-fios-set-top-boxes-getting-a-new-hd-guide-external-stor/"
    val article = TestUtils.getArticle(Uri.parse(url), html)
    TestUtils.runArticleAssertions(article = article,
      expectedStart = "Streaming and downloading TV content to mobiles is nice")
  }

  @Test
  def msn1() {
    implicit val config = TestUtils.NO_IMAGE_CONFIG
    val html = getHtml("msn1.txt")
    val expected = getHtml("msn1_result.txt")
    val url: String = "http://lifestyle.msn.com/your-life/your-money-today/article.aspx?cp-documentid=31244150"
    val article = TestUtils.getArticle(Uri.parse(url), html)
    TestUtils.runArticleAssertions(article = article,
      expectedStart = expected)

  }

  @Test
  def guardian1() {
    implicit val config = TestUtils.NO_IMAGE_CONFIG
    val html = getHtml("guardian1.txt")
    val expected = getHtml("guardian1_result.txt")
    val url: String = "http://www.guardian.co.uk/film/2011/nov/18/kristen-wiig-bridesmaids"
    val article = TestUtils.getArticle(Uri.parse(url), html)
    TestUtils.runArticleAssertions(article = article,
      expectedStart = expected)

    assert(article.publishDate.isDefined)
  }


  @Test
  def time() {
    implicit val config = TestUtils.NO_IMAGE_CONFIG
    val html = getHtml("time1.txt")
    val url: String = "http://www.time.com/time/health/article/0,8599,2011497,00.html"
    val article = TestUtils.getArticle(Uri.parse(url), html)
    TestUtils.runArticleAssertions(article = article,
      expectedStart = "This month, the federal government released",
      expectedTitle = "Invisible Oil from BP Spill May Threaten Gulf Aquatic Life")
  }

  @Test
  def time2() {
    implicit val config = TestUtils.NO_IMAGE_CONFIG
    val html = getHtml("time2.txt")
    val url: String = "http://newsfeed.time.com/2011/08/24/washington-monument-closes-to-repair-earthquake-induced-crack/"
    val article = TestUtils.getArticle(Uri.parse(url), html)
    TestUtils.runArticleAssertions(article = article,
      expectedStart = "Despite what the jeers of jaded Californians might suggest")
  }

  @Test
  def cnet() {
    implicit val config = TestUtils.NO_IMAGE_CONFIG
    val html = getHtml("cnet1.txt")
    val url: String = "http://news.cnet.com/8301-30686_3-20014053-266.html?tag=topStories1"
    val article = TestUtils.getArticle(Uri.parse(url), html)
    TestUtils.runArticleAssertions(article = article,
      expectedStart = "NEW YORK--Verizon Communications is prepping a new")
  }

  @Test
  def yahoo() {
    implicit val config = TestUtils.NO_IMAGE_CONFIG
    val html = getHtml("yahoo1.txt")
    val url: String = "http://news.yahoo.com/apple-says-steve-jobs-resigning-ceo-224628633.html"
    val article = TestUtils.getArticle(Uri.parse(url), html)
    TestUtils.runArticleAssertions(article = article,
      expectedStart = "SAN FRANCISCO (AP) — Steve Jobs, the mind behind the iPhone")
  }

  @Test
  def politico() {
    implicit val config = TestUtils.NO_IMAGE_CONFIG
    val html = getHtml("politico1.txt")
    val url: String = "http://www.politico.com/news/stories/1010/43352.html"
    val article = TestUtils.getArticle(Uri.parse(url), html)
    TestUtils.runArticleAssertions(article = article,
      expectedStart = "If the newest Census Bureau estimates stay close to form")
    assert(article.publishDate.isDefined)
  }


  @Test
  def businessinsider1() {
    val url = "http://www.businessinsider.com/goldman-on-the-fed-announcement-2011-9"
    implicit val config = TestUtils.NO_IMAGE_CONFIG
    val html = getHtml("businessinsider1.txt")
    val article = TestUtils.getArticle(Uri.parse(url), html)
    TestUtils.runArticleAssertions(article = article,
      expectedStart = "As everyone in the world was transfixed on the Fed")
  }

  @Test
  def businessinsider2() {
    val url = "http://www.businessinsider.com/goldman-on-the-fed-announcement-2011-9"
    implicit val config = TestUtils.NO_IMAGE_CONFIG
    val html = getHtml("businessinsider2.txt")
    val article = TestUtils.getArticle(Uri.parse(url), html)

    TestUtils.runArticleAssertions(article = article,
      expectedStart = "From Goldman on the FOMC operation twist announcement")
  }

  @Test
  def cnbc1() {
    val url = "http://www.cnbc.com/id/44613978"
    implicit val config = TestUtils.NO_IMAGE_CONFIG
    val html = getHtml("cnbc1.txt")
    val article = TestUtils.getArticle(Uri.parse(url), html)
    TestUtils.runArticleAssertions(article = article,
      expectedStart = "Some traders found Wednesday's Fed statement to be a bit gloomier than expected.")
    assert(article.publishDate.isDefined)
  }

  @Test
  def stocksdaily() {
    val url = "http://www.stocksdaily.net/lam-research-corporation-nasdaqlrcx-held-6827-934-in-short-term-investmentscash/136092/"
    implicit val config = TestUtils.NO_IMAGE_CONFIG
    val html = getHtml("stocksdaily.txt")
    val article = TestUtils.getArticle(Uri.parse(url), html)
    TestUtils.runArticleAssertions(article = article,
      expectedStart = "Lam Research Corporation (NASDAQ:LRCX) had beginning cash of $1501.539 ")
    assert(article.publishDate.isDefined)
  }

 /* @Test
  def theatlantic1() {
    val url = "http://www.theatlantic.com/entertainment/archive/2014/12/how-a-rap-god-lost-his-powers/383571/"
    implicit val config = TestUtils.NO_IMAGE_CONFIG
    val html = getHtml("theatlantic1.txt")
    val article = TestUtils.getArticle(url, html)
    TestUtils.runArticleAssertions(article = article,
      expectedStart = "Did you hear that")
    assert(article.publishDate != null)
  }*/

  /*
  * --------------------------------------------------------
  * Test Fixes for GitHub Issues Submitted
  * --------------------------------------------------------
  */
  @Test
  def issue24() {
    implicit val config = TestUtils.NO_IMAGE_CONFIG
    val html = getHtml("issue_24.txt")
    val expected = getHtml("issue_24_result.txt")
    val url: String = "http://danielspicar.github.com/goose-bug.html"
    val article = TestUtils.getArticle(Uri.parse(url), html)
    assertEquals("The beginning of the article text was not as expected!", expected, article.cleanedArticleText)
  }

  @Test
  def issue25() {
    implicit val config = TestUtils.NO_IMAGE_CONFIG
    val html = getHtml("issue_25.txt")
    val url: String = "http://www.accountancyage.com/aa/analysis/2111729/institutes-ifrs-bang"
    val article = TestUtils.getArticle(Uri.parse(url), html)
    TestUtils.runArticleAssertions(article = article,
      expectedStart = "UK INSTITUTES have thrown their weight behind rapid adoption of international financial reporting standards in the US.")
  }

  @Test
  def issue28() {
    implicit val config = TestUtils.NO_IMAGE_CONFIG
    val html = getHtml("issue_28.txt")
    val url: String = "http://www.telegraph.co.uk/foodanddrink/foodanddrinknews/8808120/Worlds-hottest-chilli-contest-leaves-two-in-hospital.html"
    val article = TestUtils.getArticle(Uri.parse(url), html)
    TestUtils.runArticleAssertions(article = article,
      expectedStart = "Emergency services were called to Kismot Restaurant's curry-eating challenge,")
  }

  @Test
  def issue32() {
    // this link is an example of web devs putting content not in paragraphs but embedding them in span tags with br's
    implicit val config = TestUtils.NO_IMAGE_CONFIG
    val html = getHtml("issue_32.txt")
    val url: String = "http://www.tulsaworld.com/site/articlepath.aspx?articleid=20111118_61_A16_Opposi344152&rss_lnk=7"
    val article = TestUtils.getArticle(Uri.parse(url), html)
    TestUtils.runArticleAssertions(article = article,
      expectedStart = "Opposition to a proposal to remove certain personal data")
  }

  @Test
  def nyt1(): Unit ={
    // No Body
    implicit val config = TestUtils.NO_IMAGE_CONFIG
    val html = getHtml("nyt1.txt")
    val url: String = "http://www.nytimes.com/packages/khtml/2004/03/04/washington/20040304_BLACKMUN_FEATURE.html"
    val article = TestUtils.getArticle(Uri.parse(url), html)
    TestUtils.runArticleAssertions(article = article,
      expectedStart = null)
  }

  @Test
  def nyt2(): Unit ={
    // No Body
    implicit val config = TestUtils.NO_IMAGE_CONFIG
    val html = getHtml("nyt2.txt")
    val url: String = "https://www.nytimes.com/2018/01/09/us/california-mudslides.html?hp&action=click&pgtype=Homepage&clickSource=story-heading&module=photo-spot-region&region=top-news&WT.nav=top-news"
    val article = TestUtils.getArticle(Uri.parse(url), html)
    TestUtils.runArticleAssertions(article = article,
      expectedStart = "SAN FRANCISCO — Drenching rain sent mud roaring down the hillsides of Santa Barbara County on Tuesday, killing at least eight people, carrying ")
    assert(article.publishDate.isDefined)
  }

  @Test
  def cleveland1(): Unit ={
    // ld script
    implicit val config = TestUtils.NO_IMAGE_CONFIG
    val html = getHtml("cleveland1.txt")
    val url: String = "http://www.cleveland.com/parma/index.ssf/2016/11/residents_will_vote_on_a_numbe.html"
    val article = TestUtils.getArticle(Uri.parse(url), html)
    TestUtils.runArticleAssertions(article = article,
      expectedStart = null)
    assert(article.publishDate.isDefined)
  }

  @Test
  def titleArrayOutOfBounds(): Unit = {
    implicit val config = TestUtils.NO_IMAGE_CONFIG
    val html = getHtml("titleArrayOutOfBounds.txt")
    val url: String = "http://mightycleanhome.com/173/"
    val article = TestUtils.getArticle(Uri.parse(url), html)

    val html2 = getHtml("titleArrayOutOfBounds2.txt")
    val url2: String = "http://www.aseguratuventa.com/index.php?a=2&b=17624&utm_source=twitterfeed&utm_medium=twitter"
    val article2 = TestUtils.getArticle(Uri.parse(url), html2)
  }

  @Test
  def reuters1(): Unit = {
    implicit val config = TestUtils.NO_IMAGE_CONFIG
    val html = getHtml("reuters1.txt")
    val url = "http://www.reuters.com/article/us-mideast-crisis-iraq-mosul-idUSKBN19Q1HG?il=0"
    val article = TestUtils.getArticle(Uri.parse(url), html)
    TestUtils.runArticleAssertions(article = article,
      expectedStart = "GENEVA/ERBIL, Iraq (Reuters) - The population of Mosul")
    assert(article.publishDate.isDefined)
  }

  @Test
  def wapo1(): Unit = {
    implicit val config = TestUtils.NO_IMAGE_CONFIG
    val html = getHtml("wapo1.txt")
    val url = "https://www.washingtonpost.com/local/winning-numbers-drawn-in-dc-3-evening-game/2017/08/22/b19ad646-8799-11e7-96a7-d178cf3524eb_story.html"
    val article = TestUtils.getArticle(Uri.parse(url), html)
    TestUtils.runArticleAssertions(article = article,
      expectedStart = "WASHINGTON _ The winning numbers in Tuesday evening’s")
    assert(article.publishDate.isDefined)
  }

  @Test
  def nasdaq1(): Unit = {
    implicit val config = TestUtils.NO_IMAGE_CONFIG
    val html = getHtml("nasdaq1.txt")
    val url = "http://www.nasdaq.com/article/canadian-stocks-are-sinking-on-commodity-weakness--canadian-commentary-20151207-00647?utm_source=feedburner&utm_medium=feed&utm_campaign=Feed:+nasdaq/symbols+(Articles+by+Symbol)"
    val article = TestUtils.getArticle(Uri.parse(url), html)
    TestUtils.runArticleAssertions(article = article,
      expectedStart = "(RTTNews.com) - The Canadian stock market is solidly")
    assert(article.publishDate.isDefined)
  }

  @Test
  def yahoofinance1(): Unit = {
    implicit val config = TestUtils.NO_IMAGE_CONFIG
    val html = getHtml("yahoofinance1.txt")
    val url = "http://www.nasdaq.com/article/canadian-stocks-are-sinking-on-commodity-weakness--canadian-commentary-20151207-00647?utm_source=feedburner&utm_medium=feed&utm_campaign=Feed:+nasdaq/symbols+(Articles+by+Symbol)"
    val article = TestUtils.getArticle(Uri.parse(url), html)
    val publishDate = Some(ZonedDateTime.of(LocalDateTime.parse("2015-11-18T19:18:39"), ZoneId.of("UTC").normalized()))
    TestUtils.runArticleAssertions(article = article,
      expectedStart = "Just three exchange-traded funds hit 52-week highs",
      expectedPublishDate = publishDate)
  }

  @Test
  def businessinsider3(): Unit = {
    implicit val config = TestUtils.NO_IMAGE_CONFIG
    val html = getHtml("businessinsider3.txt")
    val url = "http://www.nasdaq.com/article/canadian-stocks-are-sinking-on-commodity-weakness--canadian-commentary-20151207-00647?utm_source=feedburner&utm_medium=feed&utm_campaign=Feed:+nasdaq/symbols+(Articles+by+Symbol)"
    val article = TestUtils.getArticle(Uri.parse(url), html)
    TestUtils.runArticleAssertions(article = article,
      expectedStart = "It turns out that Melania Trump and Chelsea Clinton")
    assert(article.publishDate.isDefined)
  }

  @Test
  def dallasnews1(): Unit = {
    implicit val config = TestUtils.NO_IMAGE_CONFIG
    val html = getHtml("dallasnews1.txt")
    val url = "https://www.dallasnews.com/opinion/commentary/2017/08/22/neighborhood-segregation-america-happen-accident"
    val article = TestUtils.getArticle(Uri.parse(url), html)
    TestUtils.runArticleAssertions(article = article,
      expectedStart = "Richard Rothstein's new book, \"The Color of Law, A Forgotten History of How Our Government Segregated America")
    assert(article.publishDate.isDefined)
  }

  @Test
  def newsmax1(): Unit = {
    implicit val config = TestUtils.NO_IMAGE_CONFIG
    val html = getHtml("newsmax1.txt")
    val url = "https://www.newsmax.com/politics/tom-cole-government-shutdown-mistake-border-wall/2017/08/23/id/809312/"
    val article = TestUtils.getArticle(Uri.parse(url), html)
    TestUtils.runArticleAssertions(article = article,
      expectedStart = "It would be a \"mistake\" if President Donald Trump's threat")
    assert(article.publishDate.isDefined)
  }

  @Test
  def bbc1(): Unit = {
    implicit val config = TestUtils.NO_IMAGE_CONFIG
    val html = getHtml("bbc1.txt")
    val url = "http://www.bbc.com/news/business-41032628?ocid=socialflow_twitter"
    val article = TestUtils.getArticle(Uri.parse(url), html)
    TestUtils.runArticleAssertions(article = article,
      expectedStart = "Uber is still losing money, but the ride-hailing firm appears to have stemmed the flow of cash to some degree.")
    assert(article.publishDate.isDefined)
  }

  @Test
  def marketwatch1(): Unit = {
    implicit val config = TestUtils.NO_IMAGE_CONFIG
    val html = getHtml("marketwatch1.txt")
    val url = "https://www.marketwatch.com/story/clapper-questions-trumps-fitness-for-office-trumps-approval-rating-hits-new-post-charlottesville-low-in-poll-2017-08-23?siteid=rss"
    val article = TestUtils.getArticle(Uri.parse(url), html)
    TestUtils.runArticleAssertions(article = article,
      expectedStart = "The former director of national intelligence is questioning President Donald Trump’s")
    assert(article.publishDate.isDefined)
  }

  @Test
  def bostonglobe1(): Unit = {
    implicit val config = TestUtils.NO_IMAGE_CONFIG
    val html = getHtml("bostonglobe1.txt")
    val url = "https://www.bostonglobe.com/magazine/2017/08/22/let-stop-teaching-kids-that-reading-boring/JqBLwfpPJA6kByavjcnCNO/story.html?s_campaign=bostonglobe%3Asocialflow%3Atwitter"
    val article = TestUtils.getArticle(Uri.parse(url), html)
    TestUtils.runArticleAssertions(article = article,
      expectedStart = "In June, my 6-year-old son got very excited about our town’s summer reading program, in which kids who read for a certain number of hours vote for a movie that gets screened at the library. ")
    assert(article.publishDate.isDefined)
  }

  @Test
  def skynews1(): Unit = {
    implicit val config = TestUtils.NO_IMAGE_CONFIG
    val html = getHtml("skynews1.txt")
    val url = "https://news.sky.com/story/pound-hits-lowest-level-since-2009-against-the-euro-11001861"
    val article = TestUtils.getArticle(Uri.parse(url), html)
    TestUtils.runArticleAssertions(article = article,
      expectedStart = "The pound has hit a fresh eight-year low against the euro after the single currency was boosted")
    assert(article.publishDate.isDefined)
  }

  @Test
  def miamiherald1(): Unit = {
    implicit val config = TestUtils.NO_IMAGE_CONFIG
    val html = getHtml("miamiherald1.txt")
    val url = "http://www.miamiherald.com/news/nation-world/world/americas/venezuela/article156672104.html"
    val article = TestUtils.getArticle(Uri.parse(url), html)
    TestUtils.runArticleAssertions(article = article,
      expectedStart = "RIO DE JANEIRO Maracanã Stadium pulsed with samba, bossa nova and forró music a year ago during the closing ceremony of the 2016 Rio Olympic Games")
    assert(article.publishDate.isDefined)
  }

  @Test
  def miamiherald2(): Unit = {
    implicit val config = TestUtils.NO_IMAGE_CONFIG
    val html = getHtml("miamiherald2.txt")
    val url = "http://www.miamiherald.com/news/nation-world/world/americas/article168120297.html"
    val article = TestUtils.getArticle(Uri.parse(url), html)
    TestUtils.runArticleAssertions(article = article,
      expectedStart = "The number of Venezuelans seeking asylum tripled from 2015 to 2016, as the once-wealthy nation continues to be trapped in a punishing economic, social and political crisis.")
    assert(article.publishDate.isDefined)
  }

  @Test
  def apnews1(): Unit = {
    implicit val config = TestUtils.NO_IMAGE_CONFIG
    val html = getHtml("apnews1.txt")
    val url = "https://apnews.com/f4f6e2d57e514e2da055d3d335285f26?utm_campaign=SocialFlow&utm_source=Twitter&utm_medium=AP"
    val article = TestUtils.getArticle(Uri.parse(url), html)
    TestUtils.runArticleAssertions(article = article,
      expectedStart = "COPENHAGEN, Denmark (AP) — Journalist Kim Wall had reported on conflicts,")
    assert(article.publishDate.isDefined)
  }

  @Test
  def yonhapnews1(): Unit = {
    implicit val config = TestUtils.NO_IMAGE_CONFIG
    val html = getHtml("yonhapnews1.txt")
    val url = "http://english.yonhapnews.co.kr/news/2017/06/01/38/0200000000AEN20170601002651315F.html"
    val article = TestUtils.getArticle(Uri.parse(url), html)
    TestUtils.runArticleAssertions(article = article,
      expectedStart = "SEOUL, June 1 (Yonhap) -- Sistar's new and final song \"Lonely\" on Thursday rose to No. 1 on major South Korean music streaming charts.")
    assert(article.publishDate.isDefined)
  }

  @Test
  def bloomberg2(): Unit = {
    implicit val config = TestUtils.NO_IMAGE_CONFIG
    val html = getHtml("bloomberg2.txt")
    val url = "https://www.bloomberg.com/news/articles/2018-01-17/how-to-reverse-america-s-foreign-tourist-problem"
    val article = TestUtils.getArticle(Uri.parse(url), html)
    TestUtils.runArticleAssertions(article = article,
      expectedStart = "After a long search for an executive to run operations in China, Airbnb Inc. named an existing executive,")
    assert(article.publishDate.isDefined)
  }

  @Test
  def seekingalpha1(): Unit = {
    implicit val config = TestUtils.NO_IMAGE_CONFIG
    val html = getHtml("seekingalpha1.txt")
    val url = "https://seekingalpha.com/article/4036547-blackstone-buying-brookdale-senior-living-inc-103_10-percent-held-institutions"
    val article = TestUtils.getArticle(Uri.parse(url), html)
    TestUtils.runArticleAssertions(article = article,
      expectedStart = "Brookdale did not integrate properly the company it acquired in 2014")
    assert(article.publishDate.isDefined)
  }

  @Test
  def abc1(): Unit = {
    implicit val config = TestUtils.NO_IMAGE_CONFIG
    val html = getHtml("abc1.txt")
    val url = "http://abcnews.go.com/Politics/putin-suggests-us-hackers-interfered-election-blamed-russia/story?id=47800206&cid=social_twitter_abcn"
    val article = TestUtils.getArticle(Uri.parse(url), html)
    TestUtils.runArticleAssertions(article = article,
      expectedStart = "Russian President Vladimir Putin says it is possible that American")
    assert(article.publishDate.isDefined)
    assert(article.canonicalLink.isDefined)
    assert(article.canonicalLink.get == "http://abcnews.go.com/Politics/putin-suggests-us-hackers-interfered-election-blamed-russia/story?id=47800206")
  }

  @Test
  def nikkei1(): Unit = {
    implicit val config = TestUtils.NO_IMAGE_CONFIG
    val html = getHtml("nikkei1.txt")
    val url = "https://asia.nikkei.com/Business/Trends/Companies-set-sights-on-Japan-s-homegrown-GPS"
    val article = TestUtils.getArticle(Uri.parse(url), html)
    TestUtils.runArticleAssertions(article = article,
      expectedStart = "TOKYO -- Japan's augmented Global Positioning System is expected to create a host of new business opportunities")
    assert(article.publishDate.isDefined)
    assert(article.canonicalLink.isDefined)
    //assert(article.canonicalLink.get == "http://abcnews.go.com/Politics/putin-suggests-us-hackers-interfered-election-blamed-russia/story?id=47800206")
  }

  @Test
  def fortune2(): Unit = {
    implicit val config = TestUtils.NO_IMAGE_CONFIG
    val html = getHtml("fortune2.txt")
    val url = "http://fortune.com/2017/06/01/jetblue-delta-boarding-checkin/"
    val article = TestUtils.getArticle(Uri.parse(url), html)
    TestUtils.runArticleAssertions(article = article,
      expectedStart = "We’re inching ever closer to")
    assert(article.publishDate.isDefined)
    assert(article.canonicalLink.isDefined)
    //assert(article.canonicalLink.get == "http://abcnews.go.com/Politics/putin-suggests-us-hackers-interfered-election-blamed-russia/story?id=47800206")
  }

  /*@Test
  def blogger1(): Unit ={
    // ld script
    implicit val config = TestUtils.NO_IMAGE_CONFIG
    val html = getHtml("blogger1.txt")
    val url: String = "http://fat-pitch.blogspot.com/2013/09/what-does-small-cap-outperformance-tell.html"
    val article = TestUtils.getArticle(url, html)
    TestUtils.runArticleAssertions(article = article,
      expectedStart = "For good reason, investors are looking at the performance of the Russell 2000 (RUT).",
      expectedImage = null)
    assertNotNull(article.publishDate)
  }*/
}