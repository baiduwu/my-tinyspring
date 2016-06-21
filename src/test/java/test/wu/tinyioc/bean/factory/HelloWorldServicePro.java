package test.wu.tinyioc.bean.factory;

public class HelloWorldServicePro {
	private String text;

    public void helloWorld(){
    	System.out.println(text);

    }

    public void setText(String text) {
        this.text = text;
    }


}
