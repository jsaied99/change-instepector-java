package cij.changerules;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import cij.changerules.method.MethodInformation;
import cij.grammar.java.CodeComponentNode;

public class MethodInformationDataCollector {

	private Set<MethodInformation> methodList = new HashSet<>();

	public Set<MethodInformation> getMethodList() {
		return methodList;
	}

	public void setMethodList(Set<MethodInformation> methodList) {
		this.methodList = methodList;
	}

	public void collectMethods(CodeComponentNode root) {
		// find the method declaration
		if(root.getType().equals("(methodDeclaration")) {
			MethodInformation method = new MethodInformation();
			for(CodeComponentNode child : root.getChildren()) {
				if(child.getType().equals("(methodModifier") && !child.getCodeList().isEmpty()) {
					// initialize the modifiers
					child.getCodeList().get(0).replace("(", "");
					method.getAccessModifier().add(child.getCodeList().get(0).replace(")", ""));
				}
				if(child.getType().equals("(methodHeader")) {
					// initialize the method return type
					method.setReturnType(collectMethodReturnType(child));
					// initialize the method name
					method.setMethodName(collectMethodName(child));
					// initialize method parameter list
					method.setParameterList(collectMethodParameterList(child));
					for(String parameter : method.getParameterList()) {
						String[] parameterToken = parameter.split(" ");
						method.getParameterTypeList().add(parameterToken[0]);
						method.getParameterNameList().add(parameterToken[1]);
					}

					method.setMethodBody(collectMethodBody(root));
				}
			}
			methodList.add(method);
		}
		else {
			for(CodeComponentNode child : root.getChildren()) {
				collectMethods(child);
			}
		}
	}

	private String collectMethodReturnType(CodeComponentNode root) {
		for(CodeComponentNode child : root.getChildren()) {
			if(child.getType().equals("(result")) {
				if(!child.getCodeList().isEmpty()) {
					child.getCodeList().get(0).replace("(", "");
					return child.getCodeList().get(0).replace(")", "");
				}
				else {

					do {
						child = child.getChildren().get(0);
					} while(child.getCodeList().isEmpty());

					child.getCodeList().get(0).replace("(", "");
					return child.getCodeList().get(0).replace(")", "");
				}
			}
		}
		return "";
	}

	private String collectMethodName(CodeComponentNode root) {
		for(CodeComponentNode child : root.getChildren()) {
			if(child.getType().equals("(methodDeclarator")) {
				return child.getCodeList().get(0);
			}
		}
		return "";
	}

	/**
	 * 
	 * @param root
	 * @return
	 */
	private ArrayList<String> collectMethodParameterList(CodeComponentNode root) {
		CodeComponentNode parameterNode = null;
		ArrayList<String> parameterList = new ArrayList<String>();
		for(CodeComponentNode node : root.getChildren()) {
			if(node.getType().equals("(methodDeclarator")) {
				if(node.getChildren().isEmpty())
					return parameterList;
				parameterNode = node.getChildren().get(0);
				break;
			}
		}

		for(CodeComponentNode child : parameterNode.getChildren()) {
			String parameterName = "";
			String parameterType = "";
			ArrayList<String> parameterModifiers = new ArrayList<String>();
			if(child.getType().equals("(formalParameters")) {
				for(CodeComponentNode parameterNodes : child.getChildren()) {
					if(parameterNodes.getType().equals("(formalParameter")) {
						for(CodeComponentNode parameterInfoNode : parameterNodes.getChildren()) {
							if(parameterInfoNode.getType().equals("(variableModifier")) {
								parameterModifiers.addAll(parameterInfoNode.getCodeList());
							}
							else if(parameterInfoNode.getType().equals("(variableDeclaratorId")) {
								parameterName = parameterInfoNode.getCodeList().get(0).replace(")", "");
							}
							else {
								do {
									parameterInfoNode = parameterInfoNode.getChildren().get(0);
								} while (!parameterInfoNode.getChildren().isEmpty());
								parameterType = parameterInfoNode.getCodeList().get(0).replace(")", "");
							}
						}
					}
					else if(parameterNodes.getType().equals("(variableModifier")) {
						parameterModifiers.addAll(parameterNodes.getCodeList());
					}
					else if(parameterNodes.getType().equals("(variableDeclaratorId")) {
						parameterName = parameterNodes.getCodeList().get(0).replace(")", "");
					}
					else {
						do {
							parameterNodes = parameterNodes.getChildren().get(0);
						} while (!parameterNodes.getChildren().isEmpty());
						parameterType = parameterNodes.getCodeList().get(0).replace(")", "");
					}
//					do {
//						if(parameterNodes.getChildren().size() > 1 && parameterNodes.getChildren().get(1).getType().equals("(variableDeclaratorId")) {
//							parameterName = parameterNodes.getChildren().get(1).getCodeList().get(0).replace(")", "");
//						}
//						parameterNodes = parameterNodes.getChildren().get(0);
//					} while (!parameterNodes.getChildren().isEmpty());
//					parameterType = parameterNodes.getCodeList().get(0).replace(")", "");
					parameterList.add(parameterType + " " + parameterName);
				}
			}
			if(child.getType().equals("(lastFormalParameter")) {
				for(CodeComponentNode parameterNodes : child.getChildren()) {
					if(parameterNodes.getType().equals("(formalParameter")) {
						for(CodeComponentNode parameterInfoNode : parameterNodes.getChildren()) {
							if(parameterInfoNode.getType().equals("(variableModifier")) {
								parameterModifiers.addAll(parameterInfoNode.getCodeList());
							}
							else if(parameterInfoNode.getType().equals("(variableDeclaratorId")) {
								parameterName = parameterInfoNode.getCodeList().get(0).replace(")", "");
							}
							else {
								do {
									parameterInfoNode = parameterInfoNode.getChildren().get(0);
								} while (!parameterInfoNode.getChildren().isEmpty());
								parameterType = parameterInfoNode.getCodeList().get(0).replace(")", "");
							}
						}
					}
					else if(parameterNodes.getType().equals("(variableModifier")) {
						parameterModifiers.addAll(parameterNodes.getCodeList());
					}
					else if(parameterNodes.getType().equals("(variableDeclaratorId")) {
						parameterName = parameterNodes.getCodeList().get(0).replace(")", "");
					}
					else {
						do {
							parameterNodes = parameterNodes.getChildren().get(0);
						} while (!parameterNodes.getChildren().isEmpty());
						parameterType = parameterNodes.getCodeList().get(0).replace(")", "");
					}
//					do {
//						if(parameterNodes.getChildren().size() > 1 && parameterNodes.getChildren().get(1).getType().equals("(variableDeclaratorId")) {
//							parameterName = parameterNodes.getChildren().get(1).getCodeList().get(0).replace(")", "");
//						}
//						parameterNodes = parameterNodes.getChildren().get(0);
//					} while (!parameterNodes.getChildren().isEmpty());
//					parameterType = parameterNodes.getCodeList().get(0).replace(")", "");
					
				}
				parameterList.add(parameterType + " " + parameterName);
//				do {
//					if(child.getChildren().size() > 1 && child.getChildren().get(1).getType().equals("(variableDeclaratorId")) {
//						parameterName = child.getChildren().get(1).getCodeList().get(0).replace(")", "");
//					}
//					child = child.getChildren().get(0);
//				} while (!child.getChildren().isEmpty());
//				parameterType = child.getCodeList().get(0).replace(")", "");
//				parameterList.add(parameterType + " " + parameterName);
			}
		}
		return parameterList;
	}

	private CodeComponentNode collectMethodBody(CodeComponentNode root) {
		for(CodeComponentNode child : root.getChildren()) {
			if(child.getType().equals("(methodBody")) {
				return child;
			}
		}
		return null;
	}
}