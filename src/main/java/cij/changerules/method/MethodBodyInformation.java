package cij.changerules.method;

import java.util.ArrayList;

import cij.grammar.java.CodeComponentNode;

public class MethodBodyInformation extends MethodInformation {
	
	private ArrayList<String> ifList = new ArrayList<>();
	
	
	public void setIfList(ArrayList<String> list) {
		this.ifList = list;
	}

	public ArrayList<String> getIfList() {
		return ifList;
	}

	
	
}
