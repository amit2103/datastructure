package com.amit.datastructure;


public class Trie {
	private static final int ALPHABETS = 26;
	private Trie[] links;
	private boolean isEndOfString;
	public Trie() {
		links = new Trie[ALPHABETS];
		isEndOfString = false;
	}
	public void addString(String s) {
		Trie t = this;
		int k;
		int limit = s.length();
		for (k = 0; k < limit; k++) {
			int index = s.charAt(k) - 'a';
			if (t.links[index] == null)
				t.links[index] = new Trie();
			t = t.links[index];
		}
		t.isEndOfString = true;
	}
	void print(String s, Trie t) {
		if (t != null) {
			if (t.isEndOfString)
				System.out.println(s);
			int k;
			for (k = 0; k < ALPHABETS; k++)
				if (t.links[k] != null)
					print(s + (char) (k + 'a'), t.links[k]);
		}
	}
	public boolean isEndOfString(String s) {
		Trie t = this;
		int k;
		int limit = s.length();
		for (k = 0; k < limit; k++) {
			int index = s.charAt(k) - 'a';
			if (t.links[index] == null)
				return false;
			t = t.links[index];
		}
		return t.isEndOfString;
	}
	public boolean isEndOfString() {
		return isEndOfString;
	}
	Trie childAt(char ch) {
		return links[ch - 'a'];
	}
	public static void main(String[] args) {
		Trie t = new Trie();
		t.addString("car"); t.addString("care"); t.addString("caree");
		t.addString("career"); t.addString("careerm"); t.addString("careermonk");
		System.out.println("Is careermo included? " + t.isEndOfString("careermo"));
		System.out.println("Is career included? " + t.isEndOfString("career"));
	}
}
