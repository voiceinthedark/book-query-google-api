package com.porphiros.booksquery;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public final class BookQueryUtils {

    private static final String TAG = "bookquery";

    private static final String DUMMY_JSON =
            "{\n" +
                    " \"kind\": \"books#volumes\",\n" +
                    " \"totalItems\": 435,\n" +
                    " \"items\": [\n" +
                    "  {\n" +
                    "   \"kind\": \"books#volume\",\n" +
                    "   \"id\": \"5NomkK4EV68C\",\n" +
                    "   \"etag\": \"LI0iWkG/orY\",\n" +
                    "   \"selfLink\": \"https://www.googleapis.com/books/v1/volumes/5NomkK4EV68C\",\n" +
                    "   \"volumeInfo\": {\n" +
                    "    \"title\": \"A Game of Thrones\",\n" +
                    "    \"subtitle\": \"A Song of Ice and Fire: Book One\",\n" +
                    "    \"authors\": [\n" +
                    "     \"George R. R. Martin\"\n" +
                    "    ],\n" +
                    "    \"publisher\": \"Bantam\",\n" +
                    "    \"publishedDate\": \"2003-01-01\",\n" +
                    "    \"description\": \"NOW THE ACCLAIMED HBO SERIES GAME OF THRONES From a master of contemporary fantasy comes the first novel of a landmark series unlike any you’ve ever read before. With A Game of Thrones, George R. R. Martin has launched a genuine masterpiece, bringing together the best the genre has to offer. Mystery, intrigue, romance, and adventure fill the pages of this magnificent saga, the first volume in an epic series sure to delight fantasy fans everywhere. A GAME OF THRONES A SONG OF ICE AND FIRE: BOOK ONE Long ago, in a time forgotten, a preternatural event threw the seasons out of balance. In a land where summers can last decades and winters a lifetime, trouble is brewing. The cold is returning, and in the frozen wastes to the north of Winterfell, sinister forces are massing beyond the kingdom’s protective Wall. To the south, the king’s powers are failing—his most trusted adviser dead under mysterious circumstances and his enemies emerging from the shadows of the throne. At the center of the conflict lie the Starks of Winterfell, a family as harsh and unyielding as the frozen land they were born to. Now Lord Eddard Stark is reluctantly summoned to serve as the king’s new Hand, an appointment that threatens to sunder not only his family but the kingdom itself. Sweeping from a harsh land of cold to a summertime kingdom of epicurean plenty, A Game of Thrones tells a tale of lords and ladies, soldiers and sorcerers, assassins and bastards, who come together in a time of grim omens. Here an enigmatic band of warriors bear swords of no human metal; a tribe of fierce wildlings carry men off into madness; a cruel young dragon prince barters his sister to win back his throne; a child is lost in the twilight between life and death; and a determined woman undertakes a treacherous journey to protect all she holds dear. Amid plots and counter-plots, tragedy and betrayal, victory and terror, allies and enemies, the fate of the Starks hangs perilously in the balance, as each side endeavors to win that deadliest of conflicts: the game of thrones. Unparalleled in scope and execution, A Game of Thrones is one of those rare reading experiences that catch you up from the opening pages, won’t let you go until the end, and leave you yearning for more. From the Hardcover edition.\",\n" +
                    "    \"industryIdentifiers\": [\n" +
                    "     {\n" +
                    "      \"type\": \"ISBN_10\",\n" +
                    "      \"identifier\": \"0553897845\"\n" +
                    "     },\n" +
                    "     {\n" +
                    "      \"type\": \"ISBN_13\",\n" +
                    "      \"identifier\": \"9780553897845\"\n" +
                    "     }\n" +
                    "    ],\n" +
                    "    \"readingModes\": {\n" +
                    "     \"text\": true,\n" +
                    "     \"image\": false\n" +
                    "    },\n" +
                    "    \"pageCount\": 720,\n" +
                    "    \"printType\": \"BOOK\",\n" +
                    "    \"categories\": [\n" +
                    "     \"Fiction\"\n" +
                    "    ],\n" +
                    "    \"averageRating\": 4.0,\n" +
                    "    \"ratingsCount\": 2810,\n" +
                    "    \"maturityRating\": \"NOT_MATURE\",\n" +
                    "    \"allowAnonLogging\": true,\n" +
                    "    \"contentVersion\": \"1.32.28.0.preview.2\",\n" +
                    "    \"panelizationSummary\": {\n" +
                    "     \"containsEpubBubbles\": false,\n" +
                    "     \"containsImageBubbles\": false\n" +
                    "    },\n" +
                    "    \"imageLinks\": {\n" +
                    "     \"smallThumbnail\": \"http://books.google.com/books/content?id=5NomkK4EV68C&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api\",\n" +
                    "     \"thumbnail\": \"http://books.google.com/books/content?id=5NomkK4EV68C&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"\n" +
                    "    },\n" +
                    "    \"language\": \"en\",\n" +
                    "    \"previewLink\": \"http://books.google.com.lb/books?id=5NomkK4EV68C&pg=PT204&dq=Game+of+thrones&hl=&cd=1&source=gbs_api\",\n" +
                    "    \"infoLink\": \"https://play.google.com/store/books/details?id=5NomkK4EV68C&source=gbs_api\",\n" +
                    "    \"canonicalVolumeLink\": \"https://market.android.com/details?id=book-5NomkK4EV68C\"\n" +
                    "   },\n" +
                    "   \"saleInfo\": {\n" +
                    "    \"country\": \"LB\",\n" +
                    "    \"saleability\": \"FOR_SALE\",\n" +
                    "    \"isEbook\": true,\n" +
                    "    \"listPrice\": {\n" +
                    "     \"amount\": 8965.0,\n" +
                    "     \"currencyCode\": \"LBP\"\n" +
                    "    },\n" +
                    "    \"retailPrice\": {\n" +
                    "     \"amount\": 8965.0,\n" +
                    "     \"currencyCode\": \"LBP\"\n" +
                    "    },\n" +
                    "    \"buyLink\": \"https://play.google.com/store/books/details?id=5NomkK4EV68C&rdid=book-5NomkK4EV68C&rdot=1&source=gbs_api\",\n" +
                    "    \"offers\": [\n" +
                    "     {\n" +
                    "      \"finskyOfferType\": 1,\n" +
                    "      \"listPrice\": {\n" +
                    "       \"amountInMicros\": 8.965E9,\n" +
                    "       \"currencyCode\": \"LBP\"\n" +
                    "      },\n" +
                    "      \"retailPrice\": {\n" +
                    "       \"amountInMicros\": 8.965E9,\n" +
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
                    "     \"acsTokenLink\": \"http://books.google.com.lb/books/download/A_Game_of_Thrones-sample-epub.acsm?id=5NomkK4EV68C&format=epub&output=acs4_fulfillment_token&dl_type=sample&source=gbs_api\"\n" +
                    "    },\n" +
                    "    \"pdf\": {\n" +
                    "     \"isAvailable\": false\n" +
                    "    },\n" +
                    "    \"webReaderLink\": \"http://play.google.com/books/reader?id=5NomkK4EV68C&hl=&printsec=frontcover&source=gbs_api\",\n" +
                    "    \"accessViewStatus\": \"SAMPLE\",\n" +
                    "    \"quoteSharingAllowed\": false\n" +
                    "   },\n" +
                    "   \"searchInfo\": {\n" +
                    "    \"textSnippet\": \"“What \\u003cb\\u003egame\\u003c/b\\u003e are you playing, Littlefinger? Catelyn is at Winterfell, hundreds of \\u003cbr\\u003e\\nleagues from here.” “Oh?” Littlefinger&#39;s grey-green eyes glittered with amusement\\u003cbr\\u003e\\n. “Then it appears someone has managed an astonishing impersonation. For the\\u003cbr\\u003e\\n&nbsp;...\"\n" +
                    "   }\n" +
                    "  },\n" +
                    "  {\n" +
                    "   \"kind\": \"books#volume\",\n" +
                    "   \"id\": \"l6xMUQ88vLAC\",\n" +
                    "   \"etag\": \"laO033uM4mQ\",\n" +
                    "   \"selfLink\": \"https://www.googleapis.com/books/v1/volumes/l6xMUQ88vLAC\",\n" +
                    "   \"volumeInfo\": {\n" +
                    "    \"title\": \"Re-Reading a Game of Thrones\",\n" +
                    "    \"subtitle\": \"A Critical Response to George R. R. Martin's Fantasy Classic\",\n" +
                    "    \"authors\": [\n" +
                    "     \"Remy J. Verhoeve\"\n" +
                    "    ],\n" +
                    "    \"publisher\": \"Nimble Books LLC\",\n" +
                    "    \"publishedDate\": \"2011-04\",\n" +
                    "    \"description\": \"In 1996, George R.R. Martin electrified fantasy fans around the world when he published A Game of Thrones, the first book in his acclaimed A Song of Ice and Fire series. Since then, Martin has published three more books in the series. The engrossing tale Martin spun with these first novels in his saga has gained more and more fans across the world and has resulted in a number of spin-off products, such including HBO's TV series, card and board games, computer games, sword replicas, comic books and calendars. Perhaps paradoxically, the number of years between each time Martin publishes a new book in the series has increased. Fans have been clamoring for the fifth volume, A Dance with Dragons, since 2005: A book that promises to pick up the storylines of fan-favorite characters left hanging since 1999. As Martin struggles to reach the finish line, or indeed even the halfway point in his epic, his fans wait for the next fix. One way to keep sane during the long waits is to re-read the already published novels. Journey to Westeros with Remy J. Verhoeve as he celebrates his tenth reading of A Game of Thrones. Chapter by chapter, the author, a Dutch-Norwegian English teacher and self-confessed fantasy geek, is both fellow traveler and tour guide as he shares his insightful reflections on Martin's writing techniques, major - and seemingly minor - plot points and characters, and much more. True to its origins as a blogging project undertaken while not-so-patiently waiting for A Dance With Dragons, the author does not hold back in this unauthorized companion book that is both an unabashed homage to the novel that started it all, as well as a candid - and at times controversial - commentary on the issues surrounding the delayed release of the fifth book. Whether or not they agree with everything the author has to say, all fans of A Song of Ice and Fire, from those who have loved the series since its inception in 1996 to those who have only just discovered it through the HBO series, will enjoy this thought-provoking and outspoken book.\",\n" +
                    "    \"industryIdentifiers\": [\n" +
                    "     {\n" +
                    "      \"type\": \"ISBN_13\",\n" +
                    "      \"identifier\": \"9781608881154\"\n" +
                    "     },\n" +
                    "     {\n" +
                    "      \"type\": \"ISBN_10\",\n" +
                    "      \"identifier\": \"1608881156\"\n" +
                    "     }\n" +
                    "    ],\n" +
                    "    \"readingModes\": {\n" +
                    "     \"text\": true,\n" +
                    "     \"image\": true\n" +
                    "    },\n" +
                    "    \"pageCount\": 372,\n" +
                    "    \"printType\": \"BOOK\",\n" +
                    "    \"categories\": [\n" +
                    "     \"Literary Criticism\"\n" +
                    "    ],\n" +
                    "    \"averageRating\": 5.0,\n" +
                    "    \"ratingsCount\": 1,\n" +
                    "    \"maturityRating\": \"NOT_MATURE\",\n" +
                    "    \"allowAnonLogging\": true,\n" +
                    "    \"contentVersion\": \"0.0.1.0.preview.3\",\n" +
                    "    \"panelizationSummary\": {\n" +
                    "     \"containsEpubBubbles\": false,\n" +
                    "     \"containsImageBubbles\": false\n" +
                    "    },\n" +
                    "    \"imageLinks\": {\n" +
                    "     \"smallThumbnail\": \"http://books.google.com/books/content?id=l6xMUQ88vLAC&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api\",\n" +
                    "     \"thumbnail\": \"http://books.google.com/books/content?id=l6xMUQ88vLAC&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"\n" +
                    "    },\n" +
                    "    \"language\": \"en\",\n" +
                    "    \"previewLink\": \"http://books.google.com.lb/books?id=l6xMUQ88vLAC&printsec=frontcover&dq=Game+of+thrones&hl=&cd=2&source=gbs_api\",\n" +
                    "    \"infoLink\": \"http://books.google.com.lb/books?id=l6xMUQ88vLAC&dq=Game+of+thrones&hl=&source=gbs_api\",\n" +
                    "    \"canonicalVolumeLink\": \"https://books.google.com/books/about/Re_Reading_a_Game_of_Thrones.html?hl=&id=l6xMUQ88vLAC\"\n" +
                    "   },\n" +
                    "   \"saleInfo\": {\n" +
                    "    \"country\": \"LB\",\n" +
                    "    \"saleability\": \"NOT_FOR_SALE\",\n" +
                    "    \"isEbook\": false\n" +
                    "   },\n" +
                    "   \"accessInfo\": {\n" +
                    "    \"country\": \"LB\",\n" +
                    "    \"viewability\": \"PARTIAL\",\n" +
                    "    \"embeddable\": true,\n" +
                    "    \"publicDomain\": false,\n" +
                    "    \"textToSpeechPermission\": \"ALLOWED\",\n" +
                    "    \"epub\": {\n" +
                    "     \"isAvailable\": true,\n" +
                    "     \"acsTokenLink\": \"http://books.google.com.lb/books/download/Re_Reading_a_Game_of_Thrones-sample-epub.acsm?id=l6xMUQ88vLAC&format=epub&output=acs4_fulfillment_token&dl_type=sample&source=gbs_api\"\n" +
                    "    },\n" +
                    "    \"pdf\": {\n" +
                    "     \"isAvailable\": true,\n" +
                    "     \"acsTokenLink\": \"http://books.google.com.lb/books/download/Re_Reading_a_Game_of_Thrones-sample-pdf.acsm?id=l6xMUQ88vLAC&format=pdf&output=acs4_fulfillment_token&dl_type=sample&source=gbs_api\"\n" +
                    "    },\n" +
                    "    \"webReaderLink\": \"http://play.google.com/books/reader?id=l6xMUQ88vLAC&hl=&printsec=frontcover&source=gbs_api\",\n" +
                    "    \"accessViewStatus\": \"SAMPLE\",\n" +
                    "    \"quoteSharingAllowed\": false\n" +
                    "   },\n" +
                    "   \"searchInfo\": {\n" +
                    "    \"textSnippet\": \"In 1996, George R.R. Martin electrified fantasy fans around the world when he published A Game of Thrones, the first book in his acclaimed A Song of Ice and Fire series. Since then, Martin has published three more books in the series.\"\n" +
                    "   }\n" +
                    "  },\n" +
                    "  {\n" +
                    "   \"kind\": \"books#volume\",\n" +
                    "   \"id\": \"gd7UCwAAQBAJ\",\n" +
                    "   \"etag\": \"TP+FQcG1W1c\",\n" +
                    "   \"selfLink\": \"https://www.googleapis.com/books/v1/volumes/gd7UCwAAQBAJ\",\n" +
                    "   \"volumeInfo\": {\n" +
                    "    \"title\": \"A Game of Thrones: The Illustrated Edition\",\n" +
                    "    \"subtitle\": \"A Song of Ice and Fire: Book One\",\n" +
                    "    \"authors\": [\n" +
                    "     \"George R. R. Martin\"\n" +
                    "    ],\n" +
                    "    \"publisher\": \"Bantam\",\n" +
                    "    \"publishedDate\": \"2016-10-18\",\n" +
                    "    \"description\": \"Published in celebration of the twentieth anniversary of George R. R. Martin’s landmark series, this lavishly illustrated special edition of A Game of Thrones—featuring gorgeous full-page artwork as well as black-and-white illustrations in every chapter—revitalizes the fantasy masterpiece that became a cultural phenomenon. And now the mystery, intrigue, romance, and adventure of this magnificent saga come to life as never before. A GAME OF THRONES A SONG OF ICE AND FIRE: BOOK ONE With a special foreword by John Hodgman Winter is coming, and in the frozen wastes to the North, sinister and supernatural forces are massing beyond the kingdom’s protective Wall. At the center of the conflict lie the Starks of Winterfell, a family as harsh and unyielding as the land they were born to. Sweeping from a region of brutal cold to a distant summertime kingdom of epicurean plenty, here is a tale rife with plots and counterplots, tragedy and betrayal, victory and terror, as each faction endeavors to win that deadliest of conflicts: the game of thrones. From the Hardcover edition.\",\n" +
                    "    \"industryIdentifiers\": [\n" +
                    "     {\n" +
                    "      \"type\": \"ISBN_13\",\n" +
                    "      \"identifier\": \"9781101965870\"\n" +
                    "     },\n" +
                    "     {\n" +
                    "      \"type\": \"ISBN_10\",\n" +
                    "      \"identifier\": \"1101965878\"\n" +
                    "     }\n" +
                    "    ],\n" +
                    "    \"readingModes\": {\n" +
                    "     \"text\": true,\n" +
                    "     \"image\": false\n" +
                    "    },\n" +
                    "    \"pageCount\": 800,\n" +
                    "    \"printType\": \"BOOK\",\n" +
                    "    \"categories\": [\n" +
                    "     \"Fiction\"\n" +
                    "    ],\n" +
                    "    \"averageRating\": 5.0,\n" +
                    "    \"ratingsCount\": 1,\n" +
                    "    \"maturityRating\": \"NOT_MATURE\",\n" +
                    "    \"allowAnonLogging\": true,\n" +
                    "    \"contentVersion\": \"1.3.2.0.preview.2\",\n" +
                    "    \"panelizationSummary\": {\n" +
                    "     \"containsEpubBubbles\": false,\n" +
                    "     \"containsImageBubbles\": false\n" +
                    "    },\n" +
                    "    \"imageLinks\": {\n" +
                    "     \"smallThumbnail\": \"http://books.google.com/books/content?id=gd7UCwAAQBAJ&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api\",\n" +
                    "     \"thumbnail\": \"http://books.google.com/books/content?id=gd7UCwAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"\n" +
                    "    },\n" +
                    "    \"language\": \"en\",\n" +
                    "    \"previewLink\": \"http://books.google.com.lb/books?id=gd7UCwAAQBAJ&printsec=frontcover&dq=Game+of+thrones&hl=&cd=3&source=gbs_api\",\n" +
                    "    \"infoLink\": \"https://play.google.com/store/books/details?id=gd7UCwAAQBAJ&source=gbs_api\",\n" +
                    "    \"canonicalVolumeLink\": \"https://market.android.com/details?id=book-gd7UCwAAQBAJ\"\n" +
                    "   },\n" +
                    "   \"saleInfo\": {\n" +
                    "    \"country\": \"LB\",\n" +
                    "    \"saleability\": \"FOR_SALE\",\n" +
                    "    \"isEbook\": true,\n" +
                    "    \"listPrice\": {\n" +
                    "     \"amount\": 15844.0,\n" +
                    "     \"currencyCode\": \"LBP\"\n" +
                    "    },\n" +
                    "    \"retailPrice\": {\n" +
                    "     \"amount\": 15844.0,\n" +
                    "     \"currencyCode\": \"LBP\"\n" +
                    "    },\n" +
                    "    \"buyLink\": \"https://play.google.com/store/books/details?id=gd7UCwAAQBAJ&rdid=book-gd7UCwAAQBAJ&rdot=1&source=gbs_api\",\n" +
                    "    \"offers\": [\n" +
                    "     {\n" +
                    "      \"finskyOfferType\": 1,\n" +
                    "      \"listPrice\": {\n" +
                    "       \"amountInMicros\": 1.5844E10,\n" +
                    "       \"currencyCode\": \"LBP\"\n" +
                    "      },\n" +
                    "      \"retailPrice\": {\n" +
                    "       \"amountInMicros\": 1.5844E10,\n" +
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
                    "     \"acsTokenLink\": \"http://books.google.com.lb/books/download/A_Game_of_Thrones_The_Illustrated_Editio-sample-epub.acsm?id=gd7UCwAAQBAJ&format=epub&output=acs4_fulfillment_token&dl_type=sample&source=gbs_api\"\n" +
                    "    },\n" +
                    "    \"pdf\": {\n" +
                    "     \"isAvailable\": false\n" +
                    "    },\n" +
                    "    \"webReaderLink\": \"http://play.google.com/books/reader?id=gd7UCwAAQBAJ&hl=&printsec=frontcover&source=gbs_api\",\n" +
                    "    \"accessViewStatus\": \"SAMPLE\",\n" +
                    "    \"quoteSharingAllowed\": false\n" +
                    "   },\n" +
                    "   \"searchInfo\": {\n" +
                    "    \"textSnippet\": \"A dazzling illustrated edition of the book that started it all—for readers of A Song of Ice and Fire and fans of HBO’s Game of Thrones.\"\n" +
                    "   }\n" +
                    "  },\n" +
                    "  {\n" +
                    "   \"kind\": \"books#volume\",\n" +
                    "   \"id\": \"i_SorqUvsOEC\",\n" +
                    "   \"etag\": \"ioyaZzm4jP0\",\n" +
                    "   \"selfLink\": \"https://www.googleapis.com/books/v1/volumes/i_SorqUvsOEC\",\n" +
                    "   \"volumeInfo\": {\n" +
                    "    \"title\": \"A Game of Thrones\",\n" +
                    "    \"subtitle\": \"The Graphic Novel. Volume 1\",\n" +
                    "    \"authors\": [\n" +
                    "     \"Daniel Abraham\",\n" +
                    "     \"George R. R. Martin\"\n" +
                    "    ],\n" +
                    "    \"publisher\": \"Bantam\",\n" +
                    "    \"publishedDate\": \"2012\",\n" +
                    "    \"description\": \"The kingdom of the royal Stark family faces its ultimate challenge in the onset of a generation-long winter, the poisonous plots of the rival Lannisters, the emergence of the Neverborn demons and the arrival of barbarian hordes. 75,000 first printing.\",\n" +
                    "    \"industryIdentifiers\": [\n" +
                    "     {\n" +
                    "      \"type\": \"ISBN_13\",\n" +
                    "      \"identifier\": \"9780440423218\"\n" +
                    "     },\n" +
                    "     {\n" +
                    "      \"type\": \"ISBN_10\",\n" +
                    "      \"identifier\": \"044042321X\"\n" +
                    "     }\n" +
                    "    ],\n" +
                    "    \"readingModes\": {\n" +
                    "     \"text\": false,\n" +
                    "     \"image\": false\n" +
                    "    },\n" +
                    "    \"pageCount\": 240,\n" +
                    "    \"printType\": \"BOOK\",\n" +
                    "    \"categories\": [\n" +
                    "     \"Comics & Graphic Novels\"\n" +
                    "    ],\n" +
                    "    \"averageRating\": 3.5,\n" +
                    "    \"ratingsCount\": 5,\n" +
                    "    \"maturityRating\": \"NOT_MATURE\",\n" +
                    "    \"allowAnonLogging\": false,\n" +
                    "    \"contentVersion\": \"2.1.0.0.preview.0\",\n" +
                    "    \"panelizationSummary\": {\n" +
                    "     \"containsEpubBubbles\": false,\n" +
                    "     \"containsImageBubbles\": false\n" +
                    "    },\n" +
                    "    \"imageLinks\": {\n" +
                    "     \"smallThumbnail\": \"http://books.google.com/books/content?id=i_SorqUvsOEC&printsec=frontcover&img=1&zoom=5&source=gbs_api\",\n" +
                    "     \"thumbnail\": \"http://books.google.com/books/content?id=i_SorqUvsOEC&printsec=frontcover&img=1&zoom=1&source=gbs_api\"\n" +
                    "    },\n" +
                    "    \"language\": \"en\",\n" +
                    "    \"previewLink\": \"http://books.google.com.lb/books?id=i_SorqUvsOEC&dq=Game+of+thrones&hl=&cd=4&source=gbs_api\",\n" +
                    "    \"infoLink\": \"http://books.google.com.lb/books?id=i_SorqUvsOEC&dq=Game+of+thrones&hl=&source=gbs_api\",\n" +
                    "    \"canonicalVolumeLink\": \"https://books.google.com/books/about/A_Game_of_Thrones.html?hl=&id=i_SorqUvsOEC\"\n" +
                    "   },\n" +
                    "   \"saleInfo\": {\n" +
                    "    \"country\": \"LB\",\n" +
                    "    \"saleability\": \"NOT_FOR_SALE\",\n" +
                    "    \"isEbook\": false\n" +
                    "   },\n" +
                    "   \"accessInfo\": {\n" +
                    "    \"country\": \"LB\",\n" +
                    "    \"viewability\": \"NO_PAGES\",\n" +
                    "    \"embeddable\": false,\n" +
                    "    \"publicDomain\": false,\n" +
                    "    \"textToSpeechPermission\": \"ALLOWED\",\n" +
                    "    \"epub\": {\n" +
                    "     \"isAvailable\": false\n" +
                    "    },\n" +
                    "    \"pdf\": {\n" +
                    "     \"isAvailable\": false\n" +
                    "    },\n" +
                    "    \"webReaderLink\": \"http://play.google.com/books/reader?id=i_SorqUvsOEC&hl=&printsec=frontcover&source=gbs_api\",\n" +
                    "    \"accessViewStatus\": \"NONE\",\n" +
                    "    \"quoteSharingAllowed\": false\n" +
                    "   },\n" +
                    "   \"searchInfo\": {\n" +
                    "    \"textSnippet\": \"The kingdom of the royal Stark family faces its ultimate challenge in the onset of a generation-long winter, the poisonous plots of the rival Lannisters, the emergence of the Neverborn demons and the arrival of barbarian hordes. 75,000 ...\"\n" +
                    "   }\n" +
                    "  },\n" +
                    "  {\n" +
                    "   \"kind\": \"books#volume\",\n" +
                    "   \"id\": \"jkfGDgAAQBAJ\",\n" +
                    "   \"etag\": \"DSMKOPrShqg\",\n" +
                    "   \"selfLink\": \"https://www.googleapis.com/books/v1/volumes/jkfGDgAAQBAJ\",\n" +
                    "   \"volumeInfo\": {\n" +
                    "    \"title\": \"Game of Thrones, une métaphysique des meurtres\",\n" +
                    "    \"authors\": [\n" +
                    "     \"Marianne Chaillan\"\n" +
                    "    ],\n" +
                    "    \"publisher\": \"Le Passeur\",\n" +
                    "    \"publishedDate\": \"2017-05-04\",\n" +
                    "    \"description\": \"La saga culte de George R. R. Martin décryptée dans ses profondeurs philosophiques. Un essai aussi rigoureux qu'original, alors que la saison 7 de la série s'apprête à être diffusée sur HBO. Pour la première fois de son histoire, la série télévisée au succès planétaire Game of Thrones a rattrapé les livres dont elle est l'adaptation. Les fans du monde entier sont plongés dans un suspense insoutenable : qui est appelé à régner sur le Royaume des Sept Couronnes ? Pour répondre à cette interrogation, Marianne Chaillan convoque les meilleurs experts possibles : les philosophes. Elle imagine une soirée télé en compagnie des meilleurs spécialistes de philosophie morale et politique pour déchiffrer les clés de la série tirée de la saga de George R.R. Martin. Qui, selon Kant, mériterait de régner ? Qui faut-il soutenir pour Hobbes ? Qui semble le plus doué pour conquérir le pouvoir selon Machiavel ? Pour aller plus loin, cet essai stimulant vous met à contribution : grâce à d'étonnantes expériences de pensée, vous pourrez ainsi découvrir de quel philosophe vous êtes le banneret et de quel personnage vous êtes le plus proche. Alors êtes-vous un Stark ou un Lannister ? Daenerys a-telle plus de chance de régner que Cersei ? Ce voyage d'Essos à Westeros en compagnie des plus grands philosophes démontre que regarder Game of Thrones peut se révéler aussi instructif que divertissant.\",\n" +
                    "    \"industryIdentifiers\": [\n" +
                    "     {\n" +
                    "      \"type\": \"ISBN_13\",\n" +
                    "      \"identifier\": \"9782368905388\"\n" +
                    "     },\n" +
                    "     {\n" +
                    "      \"type\": \"ISBN_10\",\n" +
                    "      \"identifier\": \"2368905383\"\n" +
                    "     }\n" +
                    "    ],\n" +
                    "    \"readingModes\": {\n" +
                    "     \"text\": true,\n" +
                    "     \"image\": false\n" +
                    "    },\n" +
                    "    \"pageCount\": 259,\n" +
                    "    \"printType\": \"BOOK\",\n" +
                    "    \"categories\": [\n" +
                    "     \"Philosophy\"\n" +
                    "    ],\n" +
                    "    \"maturityRating\": \"NOT_MATURE\",\n" +
                    "    \"allowAnonLogging\": true,\n" +
                    "    \"contentVersion\": \"preview-1.0.0\",\n" +
                    "    \"imageLinks\": {\n" +
                    "     \"smallThumbnail\": \"http://books.google.com/books/content?id=jkfGDgAAQBAJ&printsec=frontcover&img=1&zoom=5&source=gbs_api\",\n" +
                    "     \"thumbnail\": \"http://books.google.com/books/content?id=jkfGDgAAQBAJ&printsec=frontcover&img=1&zoom=1&source=gbs_api\"\n" +
                    "    },\n" +
                    "    \"language\": \"fr\",\n" +
                    "    \"previewLink\": \"http://books.google.com.lb/books?id=jkfGDgAAQBAJ&dq=Game+of+thrones&hl=&cd=5&source=gbs_api\",\n" +
                    "    \"infoLink\": \"http://books.google.com.lb/books?id=jkfGDgAAQBAJ&dq=Game+of+thrones&hl=&source=gbs_api\",\n" +
                    "    \"canonicalVolumeLink\": \"https://books.google.com/books/about/Game_of_Thrones_une_m%C3%A9taphysique_des_me.html?hl=&id=jkfGDgAAQBAJ\"\n" +
                    "   },\n" +
                    "   \"saleInfo\": {\n" +
                    "    \"country\": \"LB\",\n" +
                    "    \"saleability\": \"NOT_FOR_SALE\",\n" +
                    "    \"isEbook\": false\n" +
                    "   },\n" +
                    "   \"accessInfo\": {\n" +
                    "    \"country\": \"LB\",\n" +
                    "    \"viewability\": \"NO_PAGES\",\n" +
                    "    \"embeddable\": false,\n" +
                    "    \"publicDomain\": false,\n" +
                    "    \"textToSpeechPermission\": \"ALLOWED\",\n" +
                    "    \"epub\": {\n" +
                    "     \"isAvailable\": true\n" +
                    "    },\n" +
                    "    \"pdf\": {\n" +
                    "     \"isAvailable\": true\n" +
                    "    },\n" +
                    "    \"webReaderLink\": \"http://play.google.com/books/reader?id=jkfGDgAAQBAJ&hl=&printsec=frontcover&source=gbs_api\",\n" +
                    "    \"accessViewStatus\": \"NONE\",\n" +
                    "    \"quoteSharingAllowed\": false\n" +
                    "   },\n" +
                    "   \"searchInfo\": {\n" +
                    "    \"textSnippet\": \"Pour répondre à cette interrogation, Marianne Chaillan convoque les meilleurs experts possibles : les philosophes.\"\n" +
                    "   }\n" +
                    "  }\n" +
                    " ]\n" +
                    "}\n";

    private BookQueryUtils() {
    }

    public static List<Book> getBooksList(){
        //TODO: fix the method
        return parseJSONResponse(DUMMY_JSON);
    }

    /**
     * helper method to parse the JSON response received
     * @param response the JSON response
     * @return List<Book> a list of books
     */
    private static List<Book> parseJSONResponse(String response){
        //setup an empty book list
        List<Book> bookList = new ArrayList<>();

        try {
            //set The JSON object root
            JSONObject root = new JSONObject(response);
            //find the items array
            JSONArray itemsArray = root.getJSONArray("items");
            //loop over the array items
            for (int i = 0; i < itemsArray.length(); i++) {
                //get the object at location i
                JSONObject item = itemsArray.getJSONObject(i);
                //get the googleid
                String googleId = item.optString("id", "");

                Log.i(TAG, "googleid: " + googleId);

                //get the object called volume info
                JSONObject volumeInfo = item.getJSONObject("volumeInfo");
                String title = volumeInfo.getString("title");
                //get subtitle
                String subtitle = volumeInfo.optString("subtitle", "");
                //get authors array
                List<String> authors = new ArrayList<>();
                JSONArray authorsArray = volumeInfo.optJSONArray("authors");
                for (int j = 0; j < authorsArray.length(); j++) {
                    String author = authorsArray.optString(j);
                    authors.add(author);

                    Log.i(TAG, "author: " + author);
                }
                //get publisher
                String publisher = volumeInfo.optString("publisher", "");
                //get publishing date
                String date = volumeInfo.optString("publishedDate", "");
                //get description
                String description = volumeInfo.getString("description");
                //get ISBN array
                JSONArray isbnArray = volumeInfo.getJSONArray("industryIdentifiers");
                JSONObject isbnObj = isbnArray.getJSONObject(0);
                String isbn = isbnObj.optString("identifier", "1111");
                //get pageCount
                int pages = volumeInfo.optInt("pageCount", 0);
                //get categories array
                JSONArray categoriesArray = volumeInfo.getJSONArray("categories");
                List<String> categories = new ArrayList<>();
                for (int j = 0; j < categoriesArray.length(); j++) {
                    String category = categoriesArray.optString(j);
                    categories.add(category);

                    Log.i(TAG, "category: " + category);
                }
                //get averageRating
                double rating = volumeInfo.optDouble("averageRating", 0.0);
                //get imageLinks object , get thumbnail string
                JSONObject imagesObject = volumeInfo.getJSONObject("imageLinks");
                String imgUrl = imagesObject.optString("smallThumbnail", "");
                //get language
                String language = volumeInfo.optString("language", "en");
                //get previewLink
                String previewLink = volumeInfo.optString("previewLink", "");

                //Add the data to the book object
                Book book = new Book.Builder(title, description)
                        .googleId(googleId)
                        .isbn(isbn)
                        .subtitle(subtitle)
                        .publishedOn(date)
                        .rating(rating)
                        .thumbnail(imgUrl)
                        .language(language)
                        .publisher(publisher)
                        .pages(pages)
                        .url(previewLink)
                        .authors(authors)
                        .categories(categories).build();
                //add the book to the list
                bookList.add(book);
            }


        } catch (JSONException e) {
            e.printStackTrace();
        }

        return bookList;
    }


}
