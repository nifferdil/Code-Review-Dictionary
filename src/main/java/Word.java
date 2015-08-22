import java.util.ArrayList;

public class Word {
	private static ArrayList<Word> instances = new ArrayList<Word>();
	private String mWord;
	private int mId;
	private ArrayList<Definition> mDefinitions = new ArrayList<Definition>();


	public Word(String word) {
		mWord = word;
		instances.add(this);
    mId = instances.size();
	}

	public String getWord() {
		return mWord;
	}

  public int getId() {
    return mId;
  }

	public ArrayList<Definition> getDefinitions() {
     return mDefinitions;
 }

  public void addDefinition(Definition def) {
		 mDefinitions.add(def);
	}

  public static ArrayList<Word> all() {
     return instances;
     }

  public static Word find(int id) {
    try {
      return instances.get(id - 1);
    } catch (IndexOutOfBoundsException e) {
      return null;
    }
  }

  public static void clear() {
    instances.clear();
  }
}
