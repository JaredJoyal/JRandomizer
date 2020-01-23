package jaredjoyal.jrandomizer;

import java.util.Random;

/*
 * This static class generates a random sentence following one specific grammatical structure
 */
public class SentenceGenerator
{
	// collection of adverbs
	private static String [] adverbs =
			{"abnormally","absentmindedly","accidentally","acidly","actually","adventurously",
			"almost","always","angrily","annually","anxiously","arrogantly","awkwardly",
			"badly","bashfully","beautifully","bitterly","bleakly","blindly","blissfully",
			"boastfully","boldly","bravely","briefly","brightly","briskly","broadly",
			"busily","calmly","carefully","carelessly","cautiously","certainly",
			"cheerfully","clearly","cleverly","closely","coaxingly","colorfully","commonly",
			"continually","coolly","correctly","courageously","crossly","cruelly",
			"curiously","daily","daintily","dearly","deceivingly","delightfully","deeply",
			"defiantly","deliberately","delightfully","diligently","dimly","doubtfully",
			"dreamily","easily","elegantly","energetically","enormously","enthusiastically",
			"equally","especially","evenly","eventually","exactly","excitedly","extremely",
			"fairly","faithfully","famously","fast","fatally","ferociously","fervently",
			"fiercely","fondly","foolishly","fortunately","frankly","frantically","freely",
			"frenetically","frightfully","fully","furiously","generally","generously",
			"gently","gladly","gleefully","gracefully","gratefully","greatly","greedily",
			"happily","hastily","healthily","heavily","helpfully","helplessly","highly",
			"honestly","hopelessly","hourly","hungrily","immediately","innocently",
			"inquisitively","instantly","intensely","intently","interestingly","inwardly",
			"irritably","jaggedly","jealously","joshingly","joyfully","joyously","jovially",
			"jubilantly","judgementally","justly","keenly","kiddingly","kindheartedly",
			"kindly","kissingly","knavishly","knottily","knowingly","knowledgeably",
			"kookily","lazily","less","lightly","likely","limply","lively","loftily",
			"longingly","loosely","lovingly","loudly","loyally","madly","majestically",
			"meaningfully","mechanically","merrily","miserably","mockingly","monthly",
			"more","mortally","mostly","mysteriously","naturally","nearly","neatly",
			"needily","nervously","never","nicely","noisily","not","obediently",
			"obnoxiously","oddly","offensively","officially","often","only","openly",
			"optimistically","overconfidently","owlishly","painfully","partially",
			"patiently","perfectly","physically","playfully","politely","poorly",
			"positively","potentially","powerfully","promptly","properly","punctually",
			"quaintly","quarrelsomely","queasily","queerly","questionably","questioningly",
			"quickly","quietly","quirkily","quizzically","rapidly","rarely","readily",
			"really","reassuringly","recklessly","regularly","reluctantly","repeatedly",
			"reproachfully","restfully","righteously","rightfully","rigidly","roughly",
			"rudely","sadly","safely","scarcely","scarily","searchingly","sedately",
			"seemingly","seldom","selfishly","separately","seriously","shakily","sharply",
			"sheepishly","shrilly","shyly","silently","sleepily","slowly","smoothly",
			"softly","solemnly","solidly","sometimes","speedily","stealthily","sternly",
			"strictly","successfully","suddenly","surprisingly","suspiciously","sweetly",
			"swiftly","sympathetically","tenderly","tensely","terribly","thankfully",
			"thoroughly","thoughtfully","tightly","too","tremendously","triumphantly",
			"truly","truthfully","ultimately","unabashedly","unaccountably","unbearably",
			"unethically","unexpectedly","unfortunately","unimpressively","unnaturally",
			"unnecessarily","utterly","upliftingly","upwardly","urgently","usefully",
			"uselessly","usually","utterly","vacantly","vaguely","vainly","valiantly",
			"vastly","verbally","very","viciously","victoriously","violently","vivaciously",
			"voluntarily","warmly","weakly","wearily","wetly","wholly","wildly","willfully",
			"wisely","woefully","wonderfully","worriedly","wrongly","yawningly","yearly",
			"yearningly","yieldingly","youthfully","zealously","zestfully","zestily"};
	// collection of adjectives
	private static String [] adjectives =
			{"attractive","bald","beautiful","chubby","clean","dazzling","drab","elegant",
			"fancy","fit","flabby","glamorous","gorgeous","handsome","long","magnificent",
			"muscular","plain","plump","quaint","scruffy","shapely","skinny","stocky",
			"ugly","unkempt","unsightly","ashy","black","blue","gray","green","icy",
			"orange","purple","red","salmon","white","yellow","alive","better","careful",
			"clever","dead","easy","famous","gifted","hallowed","helpful","important",
			"inexpensive","mealy","mushy","odd","poor","powerful","rich","shy","tender",
			"unimportant","uninterested","wrong","aggressive","agreeable","ambitious",
			"brave","calm","delightful","eager","faithful","gentle","happy","jolly","kind",
			"lively","nice","obedient","polite","proud","silly","thankful","victorious",
			"witty","wonderful","zealous","angry","bewildered","clumsy","defeated",
			"embarrassed","fierce","grumpy","helpless","itchy","jealous","lazy",
			"mysterious","nervous","obnoxious","panicky","pitiful","repulsive","scary",
			"thoughtless","uptight","worried","broad","crooked","curved","deep","flat",
			"high","hollow","low","narrow","refined","round","shallow","square","steep",
			"straight","wide","big","colossal","fat","gigantic","great","huge","immense",
			"large","little","mammoth","massive","microscopic","miniature","petite","puny",
			"scrawny","small","tall","teeny","tiny","deafening","echoing","faint","harsh",
			"hissing","howling","loud","melodic","noisy","purring","quiet","rapping",
			"raspy","rhythmic","screeching","shrilling","squeaking","thundering","tinkling",
			"wailing","whining","whispering","ancient","brief","early","fast","future",
			"late","modern","old","old-fashioned","prehistoric","quick","rapid","short",
			"slow","swift","young","acidic","bitter","cool","creamy","delicious",
			"disgusting","fresh","greasy","juicy","hot","moldy","nutritious","nutty",
			"putrid","rancid","ripe","rotten","salty","savory","sour","spicy","spoiled",
			"stale","sweet","tangy","tart","tasteless","tasty","yummy","breezy","bumpy",
			"chilly","cold","cuddly","damaged","damp","dirty","dry","flaky","fluffy",
			"freezing","loose","melted","prickly","rough","shaggy","sharp","slimy","sticky",
			"strong","tight","uneven","warm","weak","wet","wooden","abundant","full",
			"limited","scarce","sparse","substantial"};
	// collection of singular nouns
	private static String [] nouns =
			{"abyss","alumnus","analysis","aquarium","arch","atlas","axe","baby","bacterium",
			"batch","beach","brush","bus","calf","chateau","cherry","child","church",
			"circus","city","cod","copy","crisis","curriculum","deer","dictionary","domino",
			"dwarf","echo","elf","emphasis","family","fax","fish","flush","fly","foot",
			"fungus","half","hero","hippopotamus","hoax","hoof","index","iris","kiss",
			"knife","lady","leaf","life","loaf","man","mango","memorandum","mess","moose",
			"motto","mouse","nanny","neurosis","nucleus","oasis","octopus","party","pass",
			"penny","person","plateau","poppy","potato","quiz","reflex","runner-up","scarf",
			"scratch","series","sheaf","sheep","shelf","son-in-law","species","splash",
			"spy","stitch","story","syllabus","tax","thesis","thief","tomato","tooth",
			"tornado","try","volcano","waltz","wash","watch","wharf","wife","woman","bison",
			"buffalo","duck","pike","salmon","squid","swine","trout","boat","house","cat",
			"river","wish","pitch","box","daisy","goose","cactus","focus","diagnosis",
			"phenomenon","criterion","datum","aircraft"};
	// collection of past-tense verbs
	private static String [] verbs =
			{"bore","became","began","bit","broke","brought","caught","chose","came","drank",
			"drove","ate","fell","felt","flew","froze","got","went","knew","laid","led",
			"lent","lay","lost","rode","rang","rose","ran","said","saw","set","shook",
			"sang","sank","sat","slept","spoke","stole","swam","took","threw","wore","won",
			"wrote","beat","bent","bet","bid","blew","built","burned","bought","cost","cut",
			"dug","dove","drew","dreamed","fought","found","forgot","forgave","gave","grew",
			"hung","had","heard","hid","hit","held","hurt","kept","left","let","made",
			"meant","met","paid","put","read","sold","sent","showed","shut","spent","stood",
			"taught","tore","told","thought","understood","woke","arose","awoke","bound",
			"bled","bred","broadcast","burst","could","clung","crept","dealt","fed",
			"forbade","ground","knelt","leaned","learned","lied","lit","might","mowed",
			"overtook","sawed","sewed","should","shed","shone","shot","shrank","slid",
			"smelt","sowed","spelled","spilled","spat","spread","stuck","stung","stank",
			"struck","swore","swept","swelled","swung","wept","would","wound"};
	// collection of conjunctions
	private static String [] conjunctions =
			{"after","although","as","as if","as long as","as much as","as soon as",
			"as though","because","before","by the time","even if","even though","if",
			"in case","lest","once","only if","provided that","since","though","till",
			"unless","until","when","whenever","where","wherever","while"};
	// random number generator
	private static Random r = new Random();
	
	/*
	 * This function generates a random sentence with the following grammatical structure:
	 * The [adverb] [adjective] [noun] [verb] [conjunction] the [adjective] [noun] [verb].
	 * 
	 * return - random sentence
	 */
	public static String GetRandomSentence()
	{
		String sentence = new String("The ");
		sentence += adverbs[r.nextInt(adverbs.length)] + " ";
		sentence += adjectives[r.nextInt(adjectives.length)] + " ";
		sentence += nouns[r.nextInt(nouns.length)] + " ";
		sentence += verbs[r.nextInt(verbs.length)] + " ";
		sentence += conjunctions[r.nextInt(conjunctions.length)] + " ";
		sentence += "the ";
		sentence += adjectives[r.nextInt(adjectives.length)] + " ";
		sentence += nouns[r.nextInt(nouns.length)] + " ";
		sentence += verbs[r.nextInt(verbs.length)] + ".";
		
		return sentence;
	}
}
