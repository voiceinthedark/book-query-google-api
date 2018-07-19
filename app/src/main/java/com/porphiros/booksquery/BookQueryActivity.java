package com.porphiros.booksquery;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

public class BookQueryActivity extends AppCompatActivity {

    private static final String DUMMY_JSON =
            "{\n" +
                    " \"kind\": \"books#volumes\",\n" +
                    " \"totalItems\": 470,\n" +
                    " \"items\": [\n" +
                    "  {\n" +
                    "   \"kind\": \"books#volume\",\n" +
                    "   \"id\": \"qKFDDAAAQBAJ\",\n" +
                    "   \"etag\": \"ASGtTVigM0E\",\n" +
                    "   \"selfLink\": \"https://www.googleapis.com/books/v1/volumes/qKFDDAAAQBAJ\",\n" +
                    "   \"volumeInfo\": {\n" +
                    "    \"title\": \"Android\",\n" +
                    "    \"authors\": [\n" +
                    "     \"P.K. Dixit\"\n" +
                    "    ],\n" +
                    "    \"publisher\": \"Vikas Publishing House\",\n" +
                    "    \"publishedDate\": \"2014\",\n" +
                    "    \"description\": \"Android is a movement that has transferred data from laptop to hand-held devices like mobiles. Though there are alternate technologies that compete with Android, but it is the front runner in mobile technology by a long distance. Good knowledge in basic Java will help you to understand and develop Android technology and apps. Many universities in India and across the world are now teaching Android in their syllabus, which shows the importance of this subject. This book can be read by anyone who knows Java and XML concepts. It includes a lot of diagrams along with explanations to facilitate better understanding by students. This book aptly concludes with a project that uses Android, which will greatly benefit students in learning the practical aspects of Android. Key Features • Instructions in designing different Android user interfaces • Thorough explanations of all activities • JSON • Android-based project to aid practical understanding\",\n" +
                    "    \"industryIdentifiers\": [\n" +
                    "     {\n" +
                    "      \"type\": \"ISBN_13\",\n" +
                    "      \"identifier\": \"9789325977884\"\n" +
                    "     },\n" +
                    "     {\n" +
                    "      \"type\": \"ISBN_10\",\n" +
                    "      \"identifier\": \"9325977885\"\n" +
                    "     }\n" +
                    "    ],\n" +
                    "    \"readingModes\": {\n" +
                    "     \"text\": false,\n" +
                    "     \"image\": true\n" +
                    "    },\n" +
                    "    \"pageCount\": 372,\n" +
                    "    \"printType\": \"BOOK\",\n" +
                    "    \"categories\": [\n" +
                    "     \"Computers\"\n" +
                    "    ],\n" +
                    "    \"maturityRating\": \"NOT_MATURE\",\n" +
                    "    \"allowAnonLogging\": false,\n" +
                    "    \"contentVersion\": \"preview-1.0.0\",\n" +
                    "    \"panelizationSummary\": {\n" +
                    "     \"containsEpubBubbles\": false,\n" +
                    "     \"containsImageBubbles\": false\n" +
                    "    },\n" +
                    "    \"imageLinks\": {\n" +
                    "     \"smallThumbnail\": \"http://books.google.com/books/content?id=qKFDDAAAQBAJ&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api\",\n" +
                    "     \"thumbnail\": \"http://books.google.com/books/content?id=qKFDDAAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"\n" +
                    "    },\n" +
                    "    \"language\": \"en\",\n" +
                    "    \"previewLink\": \"http://books.google.com.lb/books?id=qKFDDAAAQBAJ&printsec=frontcover&dq=android&hl=&cd=1&source=gbs_api\",\n" +
                    "    \"infoLink\": \"https://play.google.com/store/books/details?id=qKFDDAAAQBAJ&source=gbs_api\",\n" +
                    "    \"canonicalVolumeLink\": \"https://market.android.com/details?id=book-qKFDDAAAQBAJ\"\n" +
                    "   },\n" +
                    "   \"saleInfo\": {\n" +
                    "    \"country\": \"LB\",\n" +
                    "    \"saleability\": \"FOR_SALE\",\n" +
                    "    \"isEbook\": true,\n" +
                    "    \"listPrice\": {\n" +
                    "     \"amount\": 21000.0,\n" +
                    "     \"currencyCode\": \"LBP\"\n" +
                    "    },\n" +
                    "    \"retailPrice\": {\n" +
                    "     \"amount\": 21000.0,\n" +
                    "     \"currencyCode\": \"LBP\"\n" +
                    "    },\n" +
                    "    \"buyLink\": \"https://play.google.com/store/books/details?id=qKFDDAAAQBAJ&rdid=book-qKFDDAAAQBAJ&rdot=1&source=gbs_api\",\n" +
                    "    \"offers\": [\n" +
                    "     {\n" +
                    "      \"finskyOfferType\": 1,\n" +
                    "      \"listPrice\": {\n" +
                    "       \"amountInMicros\": 2.1E10,\n" +
                    "       \"currencyCode\": \"LBP\"\n" +
                    "      },\n" +
                    "      \"retailPrice\": {\n" +
                    "       \"amountInMicros\": 2.1E10,\n" +
                    "       \"currencyCode\": \"LBP\"\n" +
                    "      }\n" +
                    "     }\n" +
                    "    ]\n" +
                    "   },\n" +
                    "   \"accessInfo\": {\n" +
                    "    \"country\": \"LB\",\n" +
                    "    \"viewability\": \"PARTIAL\",\n" +
                    "    \"embeddable\": true,\n" +
                    "    \"publicDomain\": false,\n" +
                    "    \"textToSpeechPermission\": \"ALLOWED\",\n" +
                    "    \"epub\": {\n" +
                    "     \"isAvailable\": false\n" +
                    "    },\n" +
                    "    \"pdf\": {\n" +
                    "     \"isAvailable\": true,\n" +
                    "     \"acsTokenLink\": \"http://books.google.com.lb/books/download/Android-sample-pdf.acsm?id=qKFDDAAAQBAJ&format=pdf&output=acs4_fulfillment_token&dl_type=sample&source=gbs_api\"\n" +
                    "    },\n" +
                    "    \"webReaderLink\": \"http://play.google.com/books/reader?id=qKFDDAAAQBAJ&hl=&printsec=frontcover&source=gbs_api\",\n" +
                    "    \"accessViewStatus\": \"SAMPLE\",\n" +
                    "    \"quoteSharingAllowed\": false\n" +
                    "   },\n" +
                    "   \"searchInfo\": {\n" +
                    "    \"textSnippet\": \"Many universities in India and across the world are now teaching Android in their syllabus, which shows the importance of this subject. This book can be read by anyone who knows Java and XML concepts.\"\n" +
                    "   }\n" +
                    "  },\n" +
                    "  {\n" +
                    "   \"kind\": \"books#volume\",\n" +
                    "   \"id\": \"PRlytmflmhoC\",\n" +
                    "   \"etag\": \"5t/z58eN2Kc\",\n" +
                    "   \"selfLink\": \"https://www.googleapis.com/books/v1/volumes/PRlytmflmhoC\",\n" +
                    "   \"volumeInfo\": {\n" +
                    "    \"title\": \"Learn HTML5 and JavaScript for Android\",\n" +
                    "    \"authors\": [\n" +
                    "     \"Gavin Williams\"\n" +
                    "    ],\n" +
                    "    \"publisher\": \"Apress\",\n" +
                    "    \"publishedDate\": \"2012-09-22\",\n" +
                    "    \"description\": \"Learn HTML5 and JavaScript for Android teaches the essential HTML5 and JavaScript skills you need to make great apps for the Android platform and browser. This book guides you through the creation of a mobile web app. You'll put the HTML5, CSS3 and JavaScript skills you learn into practice, giving you invaluable first-hand experience that will serve you well as you go on to develop your own web apps for Android smartphones and tablets. Throughout this book, you will learn new skills and bring these altogether to create a web app that runs on the Android platform as well as other mobile platforms.\",\n" +
                    "    \"industryIdentifiers\": [\n" +
                    "     {\n" +
                    "      \"type\": \"ISBN_13\",\n" +
                    "      \"identifier\": \"9781430243489\"\n" +
                    "     },\n" +
                    "     {\n" +
                    "      \"type\": \"ISBN_10\",\n" +
                    "      \"identifier\": \"1430243481\"\n" +
                    "     }\n" +
                    "    ],\n" +
                    "    \"readingModes\": {\n" +
                    "     \"text\": true,\n" +
                    "     \"image\": true\n" +
                    "    },\n" +
                    "    \"pageCount\": 386,\n" +
                    "    \"printType\": \"BOOK\",\n" +
                    "    \"categories\": [\n" +
                    "     \"Computers\"\n" +
                    "    ],\n" +
                    "    \"maturityRating\": \"NOT_MATURE\",\n" +
                    "    \"allowAnonLogging\": true,\n" +
                    "    \"contentVersion\": \"2.4.3.0.preview.3\",\n" +
                    "    \"panelizationSummary\": {\n" +
                    "     \"containsEpubBubbles\": false,\n" +
                    "     \"containsImageBubbles\": false\n" +
                    "    },\n" +
                    "    \"imageLinks\": {\n" +
                    "     \"smallThumbnail\": \"http://books.google.com/books/content?id=PRlytmflmhoC&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api\",\n" +
                    "     \"thumbnail\": \"http://books.google.com/books/content?id=PRlytmflmhoC&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"\n" +
                    "    },\n" +
                    "    \"language\": \"en\",\n" +
                    "    \"previewLink\": \"http://books.google.com.lb/books?id=PRlytmflmhoC&printsec=frontcover&dq=android&hl=&cd=2&source=gbs_api\",\n" +
                    "    \"infoLink\": \"https://play.google.com/store/books/details?id=PRlytmflmhoC&source=gbs_api\",\n" +
                    "    \"canonicalVolumeLink\": \"https://market.android.com/details?id=book-PRlytmflmhoC\"\n" +
                    "   },\n" +
                    "   \"saleInfo\": {\n" +
                    "    \"country\": \"LB\",\n" +
                    "    \"saleability\": \"FOR_SALE\",\n" +
                    "    \"isEbook\": true,\n" +
                    "    \"listPrice\": {\n" +
                    "     \"amount\": 54675.0,\n" +
                    "     \"currencyCode\": \"LBP\"\n" +
                    "    },\n" +
                    "    \"retailPrice\": {\n" +
                    "     \"amount\": 54675.0,\n" +
                    "     \"currencyCode\": \"LBP\"\n" +
                    "    },\n" +
                    "    \"buyLink\": \"https://play.google.com/store/books/details?id=PRlytmflmhoC&rdid=book-PRlytmflmhoC&rdot=1&source=gbs_api\",\n" +
                    "    \"offers\": [\n" +
                    "     {\n" +
                    "      \"finskyOfferType\": 1,\n" +
                    "      \"listPrice\": {\n" +
                    "       \"amountInMicros\": 5.4675E10,\n" +
                    "       \"currencyCode\": \"LBP\"\n" +
                    "      },\n" +
                    "      \"retailPrice\": {\n" +
                    "       \"amountInMicros\": 5.4675E10,\n" +
                    "       \"currencyCode\": \"LBP\"\n" +
                    "      }\n" +
                    "     }\n" +
                    "    ]\n" +
                    "   },\n" +
                    "   \"accessInfo\": {\n" +
                    "    \"country\": \"LB\",\n" +
                    "    \"viewability\": \"PARTIAL\",\n" +
                    "    \"embeddable\": true,\n" +
                    "    \"publicDomain\": false,\n" +
                    "    \"textToSpeechPermission\": \"ALLOWED\",\n" +
                    "    \"epub\": {\n" +
                    "     \"isAvailable\": true,\n" +
                    "     \"acsTokenLink\": \"http://books.google.com.lb/books/download/Learn_HTML5_and_JavaScript_for_Android-sample-epub.acsm?id=PRlytmflmhoC&format=epub&output=acs4_fulfillment_token&dl_type=sample&source=gbs_api\"\n" +
                    "    },\n" +
                    "    \"pdf\": {\n" +
                    "     \"isAvailable\": true,\n" +
                    "     \"acsTokenLink\": \"http://books.google.com.lb/books/download/Learn_HTML5_and_JavaScript_for_Android-sample-pdf.acsm?id=PRlytmflmhoC&format=pdf&output=acs4_fulfillment_token&dl_type=sample&source=gbs_api\"\n" +
                    "    },\n" +
                    "    \"webReaderLink\": \"http://play.google.com/books/reader?id=PRlytmflmhoC&hl=&printsec=frontcover&source=gbs_api\",\n" +
                    "    \"accessViewStatus\": \"SAMPLE\",\n" +
                    "    \"quoteSharingAllowed\": false\n" +
                    "   },\n" +
                    "   \"searchInfo\": {\n" +
                    "    \"textSnippet\": \"Learn HTML5 and JavaScript for Android teaches the essential HTML5 and JavaScript skills you need to make great apps for the Android platform and browser. This book guides you through the creation of a mobile web app.\"\n" +
                    "   }\n" +
                    "  },\n" +
                    "  {\n" +
                    "   \"kind\": \"books#volume\",\n" +
                    "   \"id\": \"MoXpe6H2B5gC\",\n" +
                    "   \"etag\": \"kH/rv8trfqM\",\n" +
                    "   \"selfLink\": \"https://www.googleapis.com/books/v1/volumes/MoXpe6H2B5gC\",\n" +
                    "   \"volumeInfo\": {\n" +
                    "    \"title\": \"Android in The Attic\",\n" +
                    "    \"authors\": [\n" +
                    "     \"Nicholas Allan\"\n" +
                    "    ],\n" +
                    "    \"publisher\": \"Hachette UK\",\n" +
                    "    \"publishedDate\": \"2013-01-03\",\n" +
                    "    \"description\": \"Aunt Edna has created a no-nonsense nanny android to make sure Billy and Alfie don't have any fun. But then Alfie discovers how to override Auntie Anne-Droid's programming and nothing can stop them eating all the Cheeki Choko Cherry Cakes they like ... until the real aunt Edna is kidnapped!\",\n" +
                    "    \"industryIdentifiers\": [\n" +
                    "     {\n" +
                    "      \"type\": \"ISBN_13\",\n" +
                    "      \"identifier\": \"9781444905465\"\n" +
                    "     },\n" +
                    "     {\n" +
                    "      \"type\": \"ISBN_10\",\n" +
                    "      \"identifier\": \"1444905465\"\n" +
                    "     }\n" +
                    "    ],\n" +
                    "    \"readingModes\": {\n" +
                    "     \"text\": true,\n" +
                    "     \"image\": false\n" +
                    "    },\n" +
                    "    \"pageCount\": 192,\n" +
                    "    \"printType\": \"BOOK\",\n" +
                    "    \"categories\": [\n" +
                    "     \"Juvenile Fiction\"\n" +
                    "    ],\n" +
                    "    \"maturityRating\": \"NOT_MATURE\",\n" +
                    "    \"allowAnonLogging\": false,\n" +
                    "    \"contentVersion\": \"1.2.2.0.preview.2\",\n" +
                    "    \"panelizationSummary\": {\n" +
                    "     \"containsEpubBubbles\": false,\n" +
                    "     \"containsImageBubbles\": false\n" +
                    "    },\n" +
                    "    \"imageLinks\": {\n" +
                    "     \"smallThumbnail\": \"http://books.google.com/books/content?id=MoXpe6H2B5gC&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api\",\n" +
                    "     \"thumbnail\": \"http://books.google.com/books/content?id=MoXpe6H2B5gC&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"\n" +
                    "    },\n" +
                    "    \"language\": \"en\",\n" +
                    "    \"previewLink\": \"http://books.google.com.lb/books?id=MoXpe6H2B5gC&printsec=frontcover&dq=android&hl=&cd=3&source=gbs_api\",\n" +
                    "    \"infoLink\": \"https://play.google.com/store/books/details?id=MoXpe6H2B5gC&source=gbs_api\",\n" +
                    "    \"canonicalVolumeLink\": \"https://market.android.com/details?id=book-MoXpe6H2B5gC\"\n" +
                    "   },\n" +
                    "   \"saleInfo\": {\n" +
                    "    \"country\": \"LB\",\n" +
                    "    \"saleability\": \"FOR_SALE\",\n" +
                    "    \"isEbook\": true,\n" +
                    "    \"listPrice\": {\n" +
                    "     \"amount\": 9054.0,\n" +
                    "     \"currencyCode\": \"LBP\"\n" +
                    "    },\n" +
                    "    \"retailPrice\": {\n" +
                    "     \"amount\": 9054.0,\n" +
                    "     \"currencyCode\": \"LBP\"\n" +
                    "    },\n" +
                    "    \"buyLink\": \"https://play.google.com/store/books/details?id=MoXpe6H2B5gC&rdid=book-MoXpe6H2B5gC&rdot=1&source=gbs_api\",\n" +
                    "    \"offers\": [\n" +
                    "     {\n" +
                    "      \"finskyOfferType\": 1,\n" +
                    "      \"listPrice\": {\n" +
                    "       \"amountInMicros\": 9.054E9,\n" +
                    "       \"currencyCode\": \"LBP\"\n" +
                    "      },\n" +
                    "      \"retailPrice\": {\n" +
                    "       \"amountInMicros\": 9.054E9,\n" +
                    "       \"currencyCode\": \"LBP\"\n" +
                    "      }\n" +
                    "     }\n" +
                    "    ]\n" +
                    "   },\n" +
                    "   \"accessInfo\": {\n" +
                    "    \"country\": \"LB\",\n" +
                    "    \"viewability\": \"PARTIAL\",\n" +
                    "    \"embeddable\": true,\n" +
                    "    \"publicDomain\": false,\n" +
                    "    \"textToSpeechPermission\": \"ALLOWED_FOR_ACCESSIBILITY\",\n" +
                    "    \"epub\": {\n" +
                    "     \"isAvailable\": true,\n" +
                    "     \"acsTokenLink\": \"http://books.google.com.lb/books/download/Android_in_The_Attic-sample-epub.acsm?id=MoXpe6H2B5gC&format=epub&output=acs4_fulfillment_token&dl_type=sample&source=gbs_api\"\n" +
                    "    },\n" +
                    "    \"pdf\": {\n" +
                    "     \"isAvailable\": false\n" +
                    "    },\n" +
                    "    \"webReaderLink\": \"http://play.google.com/books/reader?id=MoXpe6H2B5gC&hl=&printsec=frontcover&source=gbs_api\",\n" +
                    "    \"accessViewStatus\": \"SAMPLE\",\n" +
                    "    \"quoteSharingAllowed\": false\n" +
                    "   },\n" +
                    "   \"searchInfo\": {\n" +
                    "    \"textSnippet\": \"Aunt Edna has created a no-nonsense nanny android to make sure Billy and Alfie don&#39;t have any fun.\"\n" +
                    "   }\n" +
                    "  },\n" +
                    "  {\n" +
                    "   \"kind\": \"books#volume\",\n" +
                    "   \"id\": \"lVLg6SAV9dgC\",\n" +
                    "   \"etag\": \"TxzSVUHKwLQ\",\n" +
                    "   \"selfLink\": \"https://www.googleapis.com/books/v1/volumes/lVLg6SAV9dgC\",\n" +
                    "   \"volumeInfo\": {\n" +
                    "    \"title\": \"Android for Work\",\n" +
                    "    \"subtitle\": \"Productivity for Professionals\",\n" +
                    "    \"authors\": [\n" +
                    "     \"Marziah Karch\"\n" +
                    "    ],\n" +
                    "    \"publisher\": \"Apress\",\n" +
                    "    \"publishedDate\": \"2011-01-26\",\n" +
                    "    \"description\": \"Android is new, Android is open, and Android is fun. It’s also serious about business. Android for Work shows you how to harness the power of Android to stay productive and take your office on the road. This book also sheds light on the often daunting task of finding the right Android phone for the business user. Whether this is your first smartphone, your first Android smartphone, or your first attempt to make your phone into a productivity tool, Android for Work gets you started. You’ll learn how to manage email and tasks, but you’ll also learn how to weed through the sea of games to find specialized productivity tools for a variety of professions. For those that are more interested in an enterprise wide deployment, the book includes an appendix of information on administering Android phones, creating custom interfaces, and creating specialized apps for your enterprise. You’ll also learn more about integrating Android with other Google Apps for enterprise.\",\n" +
                    "    \"industryIdentifiers\": [\n" +
                    "     {\n" +
                    "      \"type\": \"ISBN_13\",\n" +
                    "      \"identifier\": \"9781430230014\"\n" +
                    "     },\n" +
                    "     {\n" +
                    "      \"type\": \"ISBN_10\",\n" +
                    "      \"identifier\": \"1430230010\"\n" +
                    "     }\n" +
                    "    ],\n" +
                    "    \"readingModes\": {\n" +
                    "     \"text\": true,\n" +
                    "     \"image\": true\n" +
                    "    },\n" +
                    "    \"pageCount\": 312,\n" +
                    "    \"printType\": \"BOOK\",\n" +
                    "    \"categories\": [\n" +
                    "     \"Computers\"\n" +
                    "    ],\n" +
                    "    \"maturityRating\": \"NOT_MATURE\",\n" +
                    "    \"allowAnonLogging\": false,\n" +
                    "    \"contentVersion\": \"1.5.4.0.preview.3\",\n" +
                    "    \"panelizationSummary\": {\n" +
                    "     \"containsEpubBubbles\": false,\n" +
                    "     \"containsImageBubbles\": false\n" +
                    "    },\n" +
                    "    \"imageLinks\": {\n" +
                    "     \"smallThumbnail\": \"http://books.google.com/books/content?id=lVLg6SAV9dgC&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api\",\n" +
                    "     \"thumbnail\": \"http://books.google.com/books/content?id=lVLg6SAV9dgC&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"\n" +
                    "    },\n" +
                    "    \"language\": \"en\",\n" +
                    "    \"previewLink\": \"http://books.google.com.lb/books?id=lVLg6SAV9dgC&printsec=frontcover&dq=android&hl=&cd=4&source=gbs_api\",\n" +
                    "    \"infoLink\": \"https://play.google.com/store/books/details?id=lVLg6SAV9dgC&source=gbs_api\",\n" +
                    "    \"canonicalVolumeLink\": \"https://market.android.com/details?id=book-lVLg6SAV9dgC\"\n" +
                    "   },\n" +
                    "   \"saleInfo\": {\n" +
                    "    \"country\": \"LB\",\n" +
                    "    \"saleability\": \"FOR_SALE\",\n" +
                    "    \"isEbook\": true,\n" +
                    "    \"listPrice\": {\n" +
                    "     \"amount\": 43961.0,\n" +
                    "     \"currencyCode\": \"LBP\"\n" +
                    "    },\n" +
                    "    \"retailPrice\": {\n" +
                    "     \"amount\": 43961.0,\n" +
                    "     \"currencyCode\": \"LBP\"\n" +
                    "    },\n" +
                    "    \"buyLink\": \"https://play.google.com/store/books/details?id=lVLg6SAV9dgC&rdid=book-lVLg6SAV9dgC&rdot=1&source=gbs_api\",\n" +
                    "    \"offers\": [\n" +
                    "     {\n" +
                    "      \"finskyOfferType\": 1,\n" +
                    "      \"listPrice\": {\n" +
                    "       \"amountInMicros\": 4.3961E10,\n" +
                    "       \"currencyCode\": \"LBP\"\n" +
                    "      },\n" +
                    "      \"retailPrice\": {\n" +
                    "       \"amountInMicros\": 4.3961E10,\n" +
                    "       \"currencyCode\": \"LBP\"\n" +
                    "      }\n" +
                    "     }\n" +
                    "    ]\n" +
                    "   },\n" +
                    "   \"accessInfo\": {\n" +
                    "    \"country\": \"LB\",\n" +
                    "    \"viewability\": \"PARTIAL\",\n" +
                    "    \"embeddable\": true,\n" +
                    "    \"publicDomain\": false,\n" +
                    "    \"textToSpeechPermission\": \"ALLOWED\",\n" +
                    "    \"epub\": {\n" +
                    "     \"isAvailable\": true,\n" +
                    "     \"acsTokenLink\": \"http://books.google.com.lb/books/download/Android_for_Work-sample-epub.acsm?id=lVLg6SAV9dgC&format=epub&output=acs4_fulfillment_token&dl_type=sample&source=gbs_api\"\n" +
                    "    },\n" +
                    "    \"pdf\": {\n" +
                    "     \"isAvailable\": true,\n" +
                    "     \"acsTokenLink\": \"http://books.google.com.lb/books/download/Android_for_Work-sample-pdf.acsm?id=lVLg6SAV9dgC&format=pdf&output=acs4_fulfillment_token&dl_type=sample&source=gbs_api\"\n" +
                    "    },\n" +
                    "    \"webReaderLink\": \"http://play.google.com/books/reader?id=lVLg6SAV9dgC&hl=&printsec=frontcover&source=gbs_api\",\n" +
                    "    \"accessViewStatus\": \"SAMPLE\",\n" +
                    "    \"quoteSharingAllowed\": false\n" +
                    "   },\n" +
                    "   \"searchInfo\": {\n" +
                    "    \"textSnippet\": \"Android for Work shows you how to harness the power of Android to stay productive and take your office on the road. This book also sheds light on the often daunting task of finding the right Android phone for the business user.\"\n" +
                    "   }\n" +
                    "  },\n" +
                    "  {\n" +
                    "   \"kind\": \"books#volume\",\n" +
                    "   \"id\": \"hoFI5pxjGesC\",\n" +
                    "   \"etag\": \"JKr7RysdN68\",\n" +
                    "   \"selfLink\": \"https://www.googleapis.com/books/v1/volumes/hoFI5pxjGesC\",\n" +
                    "   \"volumeInfo\": {\n" +
                    "    \"title\": \"ANDROID A PROGRAMMERS GUIDE\",\n" +
                    "    \"authors\": [\n" +
                    "     \"J. F. DiMarzio\"\n" +
                    "    ],\n" +
                    "    \"publisher\": \"McGraw Hill Professional\",\n" +
                    "    \"publishedDate\": \"2008-08-14\",\n" +
                    "    \"description\": \"Master the Android mobile development platform Build compelling Java-based mobile applications using the Android SDK and the Eclipse open-source software development platform. Android: A Programmer's Guide shows you, step-by-step, how to download and set up all of the necessary tools, build and tune dynamic Android programs, and debug your results. Discover how to provide web and chat functions, interact with the phone dialer and GPS devices, and access the latest Google services. You'll also learn how to create custom Content Providers and database-enable your applications using SQLite. Install and configure Java, Eclipse, and Android plugin Create Android projects from the Eclipse UI or command line Integrate web content, images, galleries, and sounds Deploy menus, progress bars, and auto-complete functions Trigger actions using Android Intents, Filters, and Receivers Implement GPS, Google Maps, Google Earth, and GTalk Build interactive SQLite databases, calendars, and notepads Test applications using the Android Emulator and Debug Bridge\",\n" +
                    "    \"industryIdentifiers\": [\n" +
                    "     {\n" +
                    "      \"type\": \"ISBN_10\",\n" +
                    "      \"identifier\": \"0071599894\"\n" +
                    "     },\n" +
                    "     {\n" +
                    "      \"type\": \"ISBN_13\",\n" +
                    "      \"identifier\": \"9780071599894\"\n" +
                    "     }\n" +
                    "    ],\n" +
                    "    \"readingModes\": {\n" +
                    "     \"text\": true,\n" +
                    "     \"image\": true\n" +
                    "    },\n" +
                    "    \"pageCount\": 400,\n" +
                    "    \"printType\": \"BOOK\",\n" +
                    "    \"categories\": [\n" +
                    "     \"Computers\"\n" +
                    "    ],\n" +
                    "    \"averageRating\": 3.0,\n" +
                    "    \"ratingsCount\": 11,\n" +
                    "    \"maturityRating\": \"NOT_MATURE\",\n" +
                    "    \"allowAnonLogging\": true,\n" +
                    "    \"contentVersion\": \"2.14.5.0.preview.3\",\n" +
                    "    \"panelizationSummary\": {\n" +
                    "     \"containsEpubBubbles\": false,\n" +
                    "     \"containsImageBubbles\": false\n" +
                    "    },\n" +
                    "    \"imageLinks\": {\n" +
                    "     \"smallThumbnail\": \"http://books.google.com/books/content?id=hoFI5pxjGesC&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api\",\n" +
                    "     \"thumbnail\": \"http://books.google.com/books/content?id=hoFI5pxjGesC&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"\n" +
                    "    },\n" +
                    "    \"language\": \"en\",\n" +
                    "    \"previewLink\": \"http://books.google.com.lb/books?id=hoFI5pxjGesC&printsec=frontcover&dq=android&hl=&cd=5&source=gbs_api\",\n" +
                    "    \"infoLink\": \"https://play.google.com/store/books/details?id=hoFI5pxjGesC&source=gbs_api\",\n" +
                    "    \"canonicalVolumeLink\": \"https://market.android.com/details?id=book-hoFI5pxjGesC\"\n" +
                    "   },\n" +
                    "   \"saleInfo\": {\n" +
                    "    \"country\": \"LB\",\n" +
                    "    \"saleability\": \"FOR_SALE\",\n" +
                    "    \"isEbook\": true,\n" +
                    "    \"listPrice\": {\n" +
                    "     \"amount\": 60480.0,\n" +
                    "     \"currencyCode\": \"LBP\"\n" +
                    "    },\n" +
                    "    \"retailPrice\": {\n" +
                    "     \"amount\": 60480.0,\n" +
                    "     \"currencyCode\": \"LBP\"\n" +
                    "    },\n" +
                    "    \"buyLink\": \"https://play.google.com/store/books/details?id=hoFI5pxjGesC&rdid=book-hoFI5pxjGesC&rdot=1&source=gbs_api\",\n" +
                    "    \"offers\": [\n" +
                    "     {\n" +
                    "      \"finskyOfferType\": 1,\n" +
                    "      \"listPrice\": {\n" +
                    "       \"amountInMicros\": 6.048E10,\n" +
                    "       \"currencyCode\": \"LBP\"\n" +
                    "      },\n" +
                    "      \"retailPrice\": {\n" +
                    "       \"amountInMicros\": 6.048E10,\n" +
                    "       \"currencyCode\": \"LBP\"\n" +
                    "      }\n" +
                    "     }\n" +
                    "    ]\n" +
                    "   },\n" +
                    "   \"accessInfo\": {\n" +
                    "    \"country\": \"LB\",\n" +
                    "    \"viewability\": \"PARTIAL\",\n" +
                    "    \"embeddable\": true,\n" +
                    "    \"publicDomain\": false,\n" +
                    "    \"textToSpeechPermission\": \"ALLOWED_FOR_ACCESSIBILITY\",\n" +
                    "    \"epub\": {\n" +
                    "     \"isAvailable\": true,\n" +
                    "     \"acsTokenLink\": \"http://books.google.com.lb/books/download/ANDROID_A_PROGRAMMERS_GUIDE-sample-epub.acsm?id=hoFI5pxjGesC&format=epub&output=acs4_fulfillment_token&dl_type=sample&source=gbs_api\"\n" +
                    "    },\n" +
                    "    \"pdf\": {\n" +
                    "     \"isAvailable\": true,\n" +
                    "     \"acsTokenLink\": \"http://books.google.com.lb/books/download/ANDROID_A_PROGRAMMERS_GUIDE-sample-pdf.acsm?id=hoFI5pxjGesC&format=pdf&output=acs4_fulfillment_token&dl_type=sample&source=gbs_api\"\n" +
                    "    },\n" +
                    "    \"webReaderLink\": \"http://play.google.com/books/reader?id=hoFI5pxjGesC&hl=&printsec=frontcover&source=gbs_api\",\n" +
                    "    \"accessViewStatus\": \"SAMPLE\",\n" +
                    "    \"quoteSharingAllowed\": false\n" +
                    "   },\n" +
                    "   \"searchInfo\": {\n" +
                    "    \"textSnippet\": \"Master the Android mobile development platform Build compelling Java-based mobile applications using the Android SDK and the Eclipse open-source software development platform.\"\n" +
                    "   }\n" +
                    "  }\n" +
                    " ]\n" +
                    "}\n";

    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_query);

        mRecyclerView = findViewById(R.id.recycler_list);
    }
}
