package cij.changerules.method;

import java.util.ArrayList;

import cij.grammar.java.CodeComponentNode;

public class MethodBodyInformation extends MethodInformation {
	
	private ArrayList<String> ifList = new ArrayList<>();
	private ArrayList<String> whileList = new ArrayList<>();
 	private ArrayList<String> forList = new ArrayList<>();
 	
	public void setIfList(ArrayList<String> list) {
		this.ifList = list;
	}

	public ArrayList<String> getIfList() {
		return ifList;
	}

	public void setWhileList(ArrayList<String> list) {
		this.whileList = list;
	}
	
	public ArrayList<String> getWhileList() {
		return whileList;
	}
	
	public void setForList(ArrayList<String> list) {
		this.forList = list;
	}
	
	public ArrayList<String> getForList() {
		return forList;
	}
	
	
}
