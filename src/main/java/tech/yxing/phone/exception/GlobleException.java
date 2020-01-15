package tech.yxing.phone.exception;


import tech.yxing.phone.result.CodeMsg;

public class GlobleException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	private CodeMsg cm;

	public GlobleException(CodeMsg cm) {
		super(cm.toString());
		this.cm = cm;
	}

	public GlobleException(CodeMsg cm, String url){
		super(cm.toString());
		this.cm = cm;
	}

	public CodeMsg getCm() {
		return cm;
	}
}
